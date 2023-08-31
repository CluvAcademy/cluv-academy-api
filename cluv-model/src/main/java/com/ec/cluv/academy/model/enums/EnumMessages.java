package com.ec.cluv.academy.model.enums;

public enum EnumMessages {
    INGRESO_EXITOSO("Registro Exitoso"),
    INGRESO_FALLIDO("Registro Fallido"),
    REGISTRO_EXISTENTE("Registro Existente"),
    REGISTRO_NO_EXISTENTE("Registro NO Existente"),
    ELIMINADO_EXITOSO("Eliminación Exitosa"),
    ELIMINADO_FALLIDO("Eliminación Fallida"),
    DATO_EXISTE("Información Existente"),
    DATO_NO_EXISTE("Información NO Existe"),
    INACTIVO_EXITOSO("Registro INACTIVADO porque tiene transacciones vinculadas."),
    INACTIVO_FALLIDO("Se intentó inactivar el registro ya que tiene transacciones. Hubo errores.."),
    ACTIVO_EXITOSO("Activación Exitosa"),
    ACTIVO_FALLIDO("Activación Fallida");

    private String valor;

    EnumMessages(String nombreValor) {
        this.valor = nombreValor;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }
}
