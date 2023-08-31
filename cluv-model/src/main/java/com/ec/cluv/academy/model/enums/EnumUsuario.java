package com.ec.cluv.academy.model.enums;

public enum EnumUsuario {
    USUARIO_EXISTENTE("El usuario ya se encuentra Registrado, proceda a Inscribirse"),
    USUARIO_ELIMINADO("El usuario ha sido eliminado"),
    AD_USUARIO_NO_EXISTENTE("El usuario no esta registrado en Cluv Academy");

    private String valor;

    EnumUsuario(String nombreValor) {
        this.valor = nombreValor;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }
}
