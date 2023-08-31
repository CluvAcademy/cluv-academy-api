package com.ec.cluv.academy.security.jwt;

import com.ec.cluv.academy.security.Encryptor;
import com.ec.cluv.academy.security.UserDetailsServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Map;

public class JwtTokenFilter extends OncePerRequestFilter {

    private final static Logger logger = LoggerFactory.getLogger(JwtTokenFilter.class);

    @Autowired
    JwtProvider jwtProvider;

    @Autowired
    UserDetailsServiceImpl userDetailsServiceImpl;

    @Autowired
    private Encryptor encryptor;

    @Override
    protected void doFilterInternal(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws ServletException, IOException {
        ServletRequest modifiedRequest = null;
        try {
/*
            if (req.getMethod().equals("POST")) {
                String requestBody = StreamUtils.copyToString(req.getInputStream(), StandardCharsets.UTF_8);
                // Obtener el valor del parámetro "data"
                String encryptedData = encryptor.extractEncryptedData(requestBody);
                String decryptedBody = encryptor.desencriptador(encryptedData);

                byte[] modifiedBody = decryptedBody.getBytes(StandardCharsets.UTF_8);
                modifiedRequest = new RequestWrapper(req, modifiedBody);

            } else if (req.getMethod().equals("GET")) {

                String encryptedURL = req.getRequestURI();
                String decryptedURL = encryptor.decryptURL(encryptedURL);

                // Crea una nueva solicitud con la URL desencriptada
                HttpServletRequestWrapper requestWrapper = new HttpServletRequestWrapper(req) {
                    @Override
                    public String getRequestURI() {
                        return decryptedURL;
                    }

                    @Override
                    public StringBuffer getRequestURL() {
                        return new StringBuffer(decryptedURL);
                    }
                };

                modifiedRequest = requestWrapper;


            }else if (req.getMethod().equals("DELETE")) {
                modifiedRequest = req;
            }*/

            // Encriptar la respuesta antes de enviarla al cliente
            String contentType = res.getContentType();
            if (contentType != null && contentType.contains("application/json")) {
                // Obtener el cuerpo de la respuesta
                String responseBody = res.getWriter().toString();
                // Encriptar el cuerpo de la respuesta
                String encryptedResponse = encryptor.encrypt(responseBody);
                // Establecer el cuerpo de la respuesta encriptada
                res.getWriter().write(encryptedResponse);
            }

            //TODO: descomentar para encriptacion
            /*String encryptedBody = this.getBodyFromRequest(req);
            String decryptedBody = this.encriptador(encryptedBody);

            byte[] modifiedBody = decryptedBody.getBytes(StandardCharsets.UTF_8);
            modifiedRequest = new RequestWrapper(req, modifiedBody);
             */
            //TODO: comentar para encriptacion
            modifiedRequest = req;
            String token = getToken(req);
            if (token != null && jwtProvider.validateToken(token)) {
                String userName = jwtProvider.getUserNameFromToken(token);
                UserDetails userDetails = userDetailsServiceImpl.loadUserByUsername(userName);
                UsernamePasswordAuthenticationToken auth =
                        new UsernamePasswordAuthenticationToken(userName, null,
                                userDetails.getAuthorities());
                auth.setDetails(new WebAuthenticationDetailsSource().buildDetails((HttpServletRequest) modifiedRequest));
                SecurityContextHolder.getContext().setAuthentication(auth);
            }
        } catch (Exception e) {
            logger.error("fail en el método doFilter " + e.getMessage());
            e.printStackTrace();
        }
        chain.doFilter(modifiedRequest, res);
    }


    private String getToken(HttpServletRequest req) {
        String authReq = req.getHeader("Authorization");
        if (authReq != null && authReq.startsWith("Bearer "))
            return authReq.replace("Bearer ", "");
        return null;
    }


    private static class RequestWrapper extends HttpServletRequestWrapper {

        private byte[] body;
        private Map<String, String[]> parameters;

        private String decryptedUrl;

        RequestWrapper(HttpServletRequest request, byte[] body) {
            super(request);
            this.body = body;
        }

        RequestWrapper(HttpServletRequest request, Map<String, String[]> parameters) {

            super(request);
            //this.decryptedUrl = request.getRequestURL().toString().replace("=", "");
            this.parameters = parameters;
        }

        /* @Override
         public String getRequestURI() {
             return decryptedUrl;
         }

         @Override
         public StringBuffer getRequestURL() {
             return new StringBuffer(decryptedUrl);
         }


         @Override
         public Map<String, String[]> getParameterMap() {
             return parameters;
         }
 */
        @Override
        public ServletInputStream getInputStream() throws IOException {
            return new ServletInputStreamWrapper(this.body);
        }

        @Override
        public int getContentLength() {
            return this.body.length;
        }

        @Override
        public long getContentLengthLong() {
            return this.body.length;
        }

    }

    private static class ServletInputStreamWrapper extends ServletInputStream {

        private ByteArrayInputStream byteArrayInputStream;

        ServletInputStreamWrapper(byte[] bytes) {
            this.byteArrayInputStream = new ByteArrayInputStream(bytes);
        }

        @Override
        public boolean isFinished() {
            return byteArrayInputStream.available() == 0;
        }

        @Override
        public boolean isReady() {
            return true;
        }

        @Override
        public void setReadListener(ReadListener readListener) {
            throw new UnsupportedOperationException();
        }

        @Override
        public int read() throws IOException {
            return byteArrayInputStream.read();
        }
    }

}
