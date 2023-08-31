package com.ec.cluv.academy.model.enums;

public enum EnumRole {

    USUARIO_ADMIN(1),
    USUARIO_OPERARIO(2),
    USUARIO_SENSEI(3),
    USUARIO_ESTUDIANTE(4);


    private int valor;

    EnumRole(int nombreValor) {
        this.valor = nombreValor;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }
    }
