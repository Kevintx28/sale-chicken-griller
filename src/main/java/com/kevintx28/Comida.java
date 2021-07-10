package com.kevintx28;

class Comida {
    String nombre;
    //String codigo;
    double precio;

    public void modificarNombre(String nuevoNombre) {
        this.nombre = nuevoNombre;
    }
    public String recuperarNombre() {
        return this.nombre;
    }


    public void insertarPrecio(double nuevoPrecio) {
        this.precio = nuevoPrecio;
    }
    public double recuperarPrecio() {
        return this.precio;
    }

}