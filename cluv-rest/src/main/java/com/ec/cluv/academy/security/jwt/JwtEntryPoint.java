package com.ec.cluv.academy.security.jwt;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Component
public class JwtEntryPoint implements AuthenticationEntryPoint {

    private final static Logger logger = LoggerFactory.getLogger(JwtEntryPoint.class);

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException e) throws IOException, ServletException {
       try {
           logger.error("fail en el método commence "+e.getMessage());
           response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "credenciales erróneas");
           response.setContentType(MediaType.APPLICATION_JSON_VALUE);
           response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);

           final Map<String, Object> body = new HashMap<>();
           body.put("status", HttpServletResponse.SC_UNAUTHORIZED);
           body.put("error", "Unauthorized");
           body.put("message", e.getMessage());
           body.put("path", request.getServletPath());

           final ObjectMapper mapper = new ObjectMapper();
           mapper.writeValue(response.getOutputStream(), body);

//    response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Error: Unauthorized");
       }catch (Exception ex)
       {
           logger.error("exception fail en el método commence " + ex.getMessage());
           ex.printStackTrace();
       }

    }
}
