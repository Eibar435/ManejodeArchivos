package com.company;
import java.io.Serializable;

public class Contacto implements Serializable {

    private String numero;
    private String nombre;

    public Contacto(){}
    public Contacto(String numero,String nombre){
        this.numero=numero;
        this.nombre=nombre;
    }
    public String getNumero() {
        return numero;
    }
    public void setNumero(String numero) {
        this.numero = numero;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String toString() {
        return "Contacto [Numero:" + numero + ", Nombre:" + nombre+ "]";
    }
}