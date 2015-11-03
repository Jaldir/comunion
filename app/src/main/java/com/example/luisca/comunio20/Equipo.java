package com.example.luisca.comunio20;

/**
 * Created by Luisca on 2/11/15.
 */

import java.util.ArrayList;

public class Equipo {
    private String eNombre;
    private ArrayList<Jugador> eJugadores;
    private int ePresupuesto;

    public Equipo(String eNombre, int ePresupuesto) {
        this.eNombre = eNombre;
        ArrayList<Jugador> eJugadores = new ArrayList<Jugador>();
        this.ePresupuesto = ePresupuesto;
    }

    public void crearEquipo(){
        eNombre = "Real Madrid";
        ePresupuesto = 50000;
        for(int i=0; i<11; i++){
            Jugador j = new Jugador("Jug"+i,geteNombre(),500+i);
            this.addJugador(j);
        }
    }


    public String geteNombre() {
        return eNombre;
    }

    public void seteNombre(String eNombre) {
        this.eNombre = eNombre;
    }

    public ArrayList geteJugadores() {
        return eJugadores;
    }

    public void seteJugadores(ArrayList eJugadores) {
        this.eJugadores = eJugadores;
    }

    public int getePresupuesto() {
        return ePresupuesto;
    }

    public void setePresupuesto(int ePresupuesto) {
        this.ePresupuesto = ePresupuesto;
    }

    public void addJugador(Jugador jug){
        this.eJugadores.add(jug);
    }

}
