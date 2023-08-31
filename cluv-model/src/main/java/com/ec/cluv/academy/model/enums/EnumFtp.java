package com.ec.cluv.academy.model.enums;

public enum EnumFtp {
    ERROR_UPLOAD("Inconvenientes en subir archivo."),
    SUCCESS_UPLOAD("Archivo cargado exitosamente.!");

    private String valor;

    EnumFtp(String nombreValor) {
        this.valor = nombreValor;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }
}
