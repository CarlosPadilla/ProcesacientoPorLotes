
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author carlos
 */
public class VPU extends Thread {
    public Proceso[] arProcesos;
    public int maxLengt;
    public vista visual;
//    inicializa nuestro CPU "VPU = virtual prosesing unit..."
    public VPU(int tamaño, vista visua ) {
        this.visual = visua;
        this.maxLengt = tamaño;
        this.arProcesos = new Proceso[tamaño];
    }
//    inicializa un nuevo proceso en la cola del arreglo de procesos
    public boolean nuevoProceso(String name, int time){
        boolean writted = false;
        int index = 0;
        while (!writted && index <= this.maxLengt) {            
            if (this.length() > this.maxLengt-1) {
                    JOptionPane.showMessageDialog(null, "Lista de procesos llena");
                    return false;
                }
            if (this.arProcesos[index] == null && !writted) {
                
                this.arProcesos[index] = new Proceso(name, time);
                writted = !writted;
            }
            index++;
        }
        this.muestra();
        return true;
    }
//   actualiza los distintos campos de la vista en tiempo de ejecucion
    public void muestra() {
        this.visual.setNProcesos(this.length());
        DefaultTableModel table;
        table = new DefaultTableModel(new Object[]{"Proceso", "Quantums"}, 0);
        
        for (Proceso arProceso : this.arProcesos) {
            if (arProceso != null) {
                table.addRow(new Object[] {arProceso.getName(), arProceso.getQuantums()});
                System.out.println(arProceso.toString());
            }
        }
        this.visual.setTable(table);
    }
//    nos devuelve el numero de registros ingresados en el arreglo
    private int length() {
        int length = 0;
        for (Proceso arProceso : this.arProcesos) {
            if (arProceso != null) {
                length++;
            }
        }
        return length;
    }
//    ejecuta los procesos como otro proceso
    @Override
    public void run(){
            try {
            this.ejecuta(this.visual.ismulti());
        } catch (InterruptedException ex) {
            Logger.getLogger(VPU.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
//    hace la ejecucion metodica de los procesos en la memoria
    public boolean ejecuta(boolean isMultiprogramacion) throws InterruptedException {
        if(isMultiprogramacion){
            this.ordenar();
        }
        Thread.sleep(1000);
        System.out.println("Ejecutando");
        boolean acaba = true;
        this.muestra();
        if(this.arProcesos[0] != null){
            acaba = this.arProcesos[0].reducirTiempo();
        }
        this.recorrer();
        if(this.arProcesos[0] != null){
            if (!acaba) {
                this.arProcesos[0].deleteOfCount();
                this.arProcesos[0] = null;
            }
        } else {
            return true;
        }
        return this.ejecuta(isMultiprogramacion);
    }
//    elimina los campos vacios al inicio del arreglo moviendo todo hacia delante
    public void recorrer() {
        int index = 0;
        boolean writted = false;
        Proceso[] recorrido = new Proceso[this.maxLengt];
        
        for (Proceso elemento : this.arProcesos) {
            while (elemento != null &&!writted && index < this.maxLengt) {
                if(!writted && recorrido[index] == null){
                    recorrido[index] = elemento;
                    writted = !writted;
                }
                index++;
            }
            writted = false;
        }
        this.arProcesos = recorrido;
    }
//    hace la ordenacion por metodo de seleccion
    public void ordenar() {
        int minimo = 0;
        Proceso auxiliar; 
        this.recorrer();
        for (int selecciona = 0; selecciona < this.maxLengt - 1; selecciona++) {
            if(this.arProcesos[selecciona] != null){
                minimo = selecciona;
                for (int compara = selecciona + 1; compara < this.maxLengt; compara++) {
                    if(this.arProcesos[compara] != null && this.arProcesos[minimo] != null && this.arProcesos[minimo].getTime() > this.arProcesos[compara].getTime()){
                        minimo = compara;
                    }

                }
            auxiliar = this.arProcesos[selecciona];
            this.arProcesos[selecciona] = this.arProcesos[minimo];
            this.arProcesos[minimo] = auxiliar;
            }
        }
    }
}
