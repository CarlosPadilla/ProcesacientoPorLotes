/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * @author Alejandra
 * @author carlos
 */
public class CPU {
    private Proceso[] cola; 
    private Proceso enEjecucion; 
    private ejecucion VMenu;
    public int tamaño;

//    colasmultiples
    public CPU(ejecucion visual, int tamaño){
        this.cola = new Proceso[tamaño];
        this.VMenu = visual;
    }
//    roundRobin
    public CPU(){
        
    }
    public void Ejecutar(){

    }
    public void imprimir(){
        for (Proceso proceso : this.cola) {
            if (proceso != null) {
                System.out.println(proceso.toString());
            }
        }

    }
    public void recorrer(){

    }
    public void nuevoProceso(String nombre, int tiempo, char prioridad){
        this.cola[0] = new Proceso(nombre, tiempo, prioridad);
    }
}
