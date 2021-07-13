package com.kevintx28;

class Comida {
    String nombre;
    int codigo;
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
    
    

    public void insertarCodigo(int nuevoCodigo) {
        this.codigo = nuevoCodigo;
    }
    public int recuperarCodigo() {
        return this.codigo;
    }
    

}