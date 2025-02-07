package com.usuarionoticiacomentario.models;

public enum Categoria {
    DEPORTES(1), POLITICA(2), ECONOMIA(3);
    
    private final int puntos;
    
    Categoria(int puntos) {
        this.puntos = puntos;
    }
    
    public int getPuntos() {
        return puntos;
    }
}
