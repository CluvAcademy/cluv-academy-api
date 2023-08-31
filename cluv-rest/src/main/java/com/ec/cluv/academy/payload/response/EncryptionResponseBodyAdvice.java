package com.ec.cluv.academy.payload.response;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.ec.cluv.academy.advice.EncryptResponse;
import com.ec.cluv.academy.security.Encryptor;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.security.NoSuchAlgorithmException;

@ControllerAdvice
public class EncryptionResponseBodyAdvice implements ResponseBodyAdvice<Object> {

    private Encryptor encryptor = new Encryptor();

    public EncryptionResponseBodyAdvice() throws NoSuchAlgorithmException {
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType,
                                  Class<? extends HttpMessageConverter<?>> selectedConverterType,
                                  ServerHttpRequest request, ServerHttpResponse response) {
        // Realiza la encriptación del body de la respuesta aquí
        // Puedes acceder al objeto body y aplicar la encriptación deseada
        // Aplica la encriptación al body de la respuesta
        Gson gson = new GsonBuilder()
                //.registerTypeAdapter(Date.class, new DateDeserializer())
                .setDateFormat("yyyy-MM-dd HH:mm:ss.SSS")
                .create();
        response.getHeaders().add("Encription", "true");
        response.getHeaders().add("Access-Control-Expose-Headers", "Encription");
        if (body instanceof String) {
            // Encripta el body si es un String
            String encryptedBody = null;
            try {
                String jsonBody = gson.toJson(body);

                encryptedBody = encryptor.encrypt(jsonBody);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            return encryptedBody;
        } else {
            // Si el body no es un String, puedes manejarlo según tus necesidades
            // Por ejemplo, puedes convertirlo a JSON y luego encriptarlo
            // Utiliza la librería Gson para convertir el body a JSON

            String jsonBody = gson.toJson(body);
            String encryptedBody = null;
            try {
                HttpHeaders headers = response.getHeaders();
                headers.add("X-Encrypted-Response", "true");
                encryptedBody = encryptor.encrypt(jsonBody);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            return encryptedBody;
        }
    }

    @Override
    public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> aClass) {
        // Indica si este advice se aplica a la respuesta actual
        // Puedes aplicarlo a todos los métodos o condicionarlo según el tipo de retorno, el controlador, etc.
        //return true;
        return methodParameter.hasMethodAnnotation(EncryptResponse.class);

    }
}
