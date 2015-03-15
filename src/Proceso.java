public class Proceso {
    private Integer time;
    private String name;
    private static int nProceso;

    public Proceso(String name, Integer time) {
        this.name = name;
        this.time = time;
        nProceso++;
    }
//  creamos un metodo para imprimir de forma facil el objeto
    @Override
    public String toString() {
        String nameProceso = this.name + " quantums: " + this.time; 
        return nameProceso;
    }
//    obtenemos el nombre de uestro proceso
    public String getName() {
        return (String)this.name;
    }
//    obtenemos los cuantums o tiempo de ejecucion para imprimir
    public String getQuantums(){
        return (String)Integer.toString(this.time);
    }
//  obtenemos el tiempo de ejecucion typo integer
    public int getTime() {
        return (int)this.time;
    }
//    reduce el tiempo y regresa dalse cuando este se ha acabado
    public boolean reducirTiempo(){
        if(this.time > 0){
            this.time--;
        }
        return this.time > 0;
    }
//    resta un proceso del conteo de procesos creados
    public void deleteOfCount(){
        nProceso--;
    }
    
    
    
}
