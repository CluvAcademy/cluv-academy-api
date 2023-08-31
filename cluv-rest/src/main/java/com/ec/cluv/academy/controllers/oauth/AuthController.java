package com.ec.cluv.academy.controllers.oauth;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ec.cluv.academy.exception.TokenRefreshException;
import com.ec.cluv.academy.model.entities.publick.RefreshToken;
import com.ec.cluv.academy.model.entities.publick.Usuario;
import com.ec.cluv.academy.model.response.ResponseGenerico;
import com.ec.cluv.academy.payload.request.LogOutRequest;
import com.ec.cluv.academy.payload.request.LoginRequest;
import com.ec.cluv.academy.payload.request.SignupRequest;
import com.ec.cluv.academy.payload.request.TokenRefreshRequest;
import com.ec.cluv.academy.payload.response.JwtResponse;
import com.ec.cluv.academy.payload.response.MessageResponse;
import com.ec.cluv.academy.payload.response.TokenRefreshResponse;
import com.ec.cluv.academy.repository.publick.UsuarioRepository;
import com.ec.cluv.academy.security.RefreshTokenService;
import com.ec.cluv.academy.security.UsuarioPrincipal;
import com.ec.cluv.academy.security.jwt.JwtProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT,
        RequestMethod.OPTIONS})
@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UsuarioRepository userRepository;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JwtProvider jwtProvider;

    @Autowired
    RefreshTokenService refreshTokenService;

    private final Logger logger = Logger.getLogger(AuthController.class.getName());

    @GetMapping("/test")
    public String test() {
        return "test: ";
    }

    public ResponseEntity<?> authenticateUserV2(@RequestBody String loginRequest) {
        System.out.println("DATA LOGIN REQUEST: " + loginRequest);
        ObjectMapper mapper = new ObjectMapper();
        try {
            LoginRequest dataRequest = mapper.readValue(loginRequest, LoginRequest.class);
            return this.authenticateUser(dataRequest);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }


    }

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

        System.out.println("DATA LOGIN REQUEST: " + loginRequest.getNombreUsuario());

        try {


            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequest.getNombreUsuario(), "Chester_1")
            );
            SecurityContextHolder.getContext().setAuthentication(authentication);
            String jwt = jwtProvider.generateToken(authentication);

            UsuarioPrincipal userDetails = (UsuarioPrincipal) authentication.getPrincipal();

            //TODO: obtener tokens
            List<String> roles = userDetails.getAuthorities().stream().map(GrantedAuthority::getAuthority)
                    .collect(Collectors.toList());

            //TODO: obtener los refhesh tokens
            RefreshToken refreshToken = refreshTokenService.createRefreshToken(userDetails.getUsername());

            System.out.println("TOKEN OBTENIDO" + jwt);
            System.out.println("refreshToken.getToken()" + refreshToken.getToken());
            System.out.println("userDetails.getUsername()" + userDetails.getUsername());
            System.out.println("userDetails.getAuthorities()" + userDetails.getAuthorities());

            return ResponseEntity.ok(new JwtResponse(jwt, refreshToken.getToken(), userDetails.getId(),
                    userDetails.getUsername(), userDetails.getCedula(), roles));

        } catch (BadCredentialsException e) {
            ResponseGenerico<?> response = new ResponseGenerico<>();
            response.setCodigoRespuestaValue(HttpStatus.CONFLICT.value());
            response.setCodigoRespuestaName(HttpStatus.CONFLICT.name());
            response.setMensaje(e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.CONFLICT);
        } catch (Exception e) {
            e.printStackTrace();
            ResponseGenerico<?> response = new ResponseGenerico<>();
            response.setCodigoRespuestaValue(HttpStatus.INTERNAL_SERVER_ERROR.value());
            response.setCodigoRespuestaName(HttpStatus.INTERNAL_SERVER_ERROR.name());
            response.setMensaje(e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
        if (userRepository.findByNombreUsuario(signUpRequest.getUsername()) != null) {
            return ResponseEntity.badRequest().body(new MessageResponse("Error: Username is already taken!"));
        }

        if (userRepository.existsByCedula(signUpRequest.getEmail())) {
            return ResponseEntity.badRequest().body(new MessageResponse("Error: DNI is already in use!"));
        }

        Usuario user = new Usuario(signUpRequest.getUsername(), signUpRequest.getEmail(),
                encoder.encode(signUpRequest.getPassword()));

        Set<String> strRoles = signUpRequest.getRole();
    /*Set<Role> roles = new HashSet<>();

    if (strRoles == null) {
      Role userRole = roleRepository.findByName(ERole.ROLE_USER)
          .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
      roles.add(userRole);
    } else {
      strRoles.forEach(role -> {
        switch (role) {
        case "admin":
          Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
              .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
          roles.add(adminRole);

          break;
        case "mod":
          Role modRole = roleRepository.findByName(ERole.ROLE_MODERATOR)
              .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
          roles.add(modRole);

          break;
        default:
          Role userRole = roleRepository.findByName(ERole.ROLE_USER)
              .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
          roles.add(userRole);
        }
      });
    }

    user.setRoles(roles);*/
        userRepository.save(user);

        return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
    }

    @PostMapping("/refreshtoken")
    public ResponseEntity<?> refreshtoken(@Valid @RequestBody TokenRefreshRequest request) {
        String requestRefreshToken = request.getRefreshToken();

        return refreshTokenService.findByToken(requestRefreshToken)
                .map(refreshTokenService::verifyExpiration)
                .map(RefreshToken::getUser)
                .map(user -> {
                    Authentication authentication = authenticationManager.authenticate(
                            new UsernamePasswordAuthenticationToken(user.getNombreUsuario(), user.getClave())
                    );
                    String token = jwtProvider.generateToken(authentication);
                    return ResponseEntity.ok(new TokenRefreshResponse(token, requestRefreshToken));
                })
                .orElseThrow(() -> new TokenRefreshException(requestRefreshToken,
                        "Refresh token is not in database!"));
    }

    @PostMapping("/logout")
    public ResponseEntity<?> logoutUser(@Valid @RequestBody LogOutRequest logOutRequest) {
        refreshTokenService.deleteByUserId(logOutRequest.getUserName());
        return ResponseEntity.ok(new MessageResponse("Log out successful!"));
    }

}
