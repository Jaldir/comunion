package com.example.luisca.comunio20;


/**
 * Created by Carlos on 29/10/2015.
 */
public class Jugador {
    private String jNombre;
    private int jPrecio;
    private String jEquipo;

    public Jugador(String jNombre, String jEquipo, int jPrecio) {
        this.jNombre=jNombre;
        this.jEquipo=jEquipo;
        this.jPrecio=jPrecio;
    }


    public int getjPrecio() {
        return jPrecio;
    }

    public void setjPrecio(int jPrecio) {
        this.jPrecio = jPrecio;
    }

    public String getjNombre() {
        return jNombre;
    }

    public void setjNombre(String jNombre) {
        this.jNombre = jNombre;
    }

    public String getjEquipo() {
        return jEquipo;
    }

    public void setjEquipo(String jEquipo) {
        this.jEquipo = jEquipo;
    }



}
