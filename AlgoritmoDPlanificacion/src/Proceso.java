/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author carlos
 */
class Proceso {
    private String nombre;
    private int time;
    private char priority;
    public Proceso(String nombre, int time, char priority){
        this.nombre = nombre;
        this.time = time;
        this.priority = priority;
    }
    public Proceso(String nombre, int time){
        
    }
     @Override
    public String toString(){
        return "hola " + this.nombre + " tiempo: " + this.time;

    }
}
