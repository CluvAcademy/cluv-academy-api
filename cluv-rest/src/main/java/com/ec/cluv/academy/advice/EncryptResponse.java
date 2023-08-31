package com.ec.cluv.academy.advice;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface EncryptResponse {
    //TODO: clase para especificar que endpoints requieren encriptacion
    //TODO: no se necesitamodificar la clase
}
