/**
 * ********************************************
 * Autor: Miguel Angel Lopez Fernandez
 * Correo: miguel.angel.lopez@correounivalle.edu.co
 * Código: 1326691
 * Fecha: 02-may-2015
 * Nombre del Archivo: Comite.java
 * Plan: Ingeniería de Sistemas - 3743
 * Institución Educativa: Universidad del Valle (Cali - Colombia)
 * *********************************************
 */
package Implementacion;

import java.util.ArrayList;

public class ComiteIngenuo {
    private ArrayList<Monitor> monitors;//Esta lista contiene a todos los monitores
    private ArrayList<Monitor> comite;//Conjunto de todos los comites posibles
    private int numComite;//Variable encargada de llevar registro de cual es menor comite
      private ArrayList<String> tabla= new ArrayList<String>();

    public ComiteIngenuo(ArrayList<Monitor> monitors){
        this.monitors = monitors;
        comite = new ArrayList<Monitor>();
        numComite = monitors.size() ;
    }
    
   
    public void yarg(String prefix, int n) {
        if (n == 0){
                      tabla.add(prefix);
        }
        else {
            gray(prefix + "1", n - 1);
            yarg(prefix + "0", n - 1);
        }
    }  

  
    public void gray(String prefix, int n) {
        if (n == 0){
                      tabla.add(prefix);
        }
        else {
            gray(prefix + "0", n - 1);
            yarg(prefix + "1", n - 1);
        }
        
        
    } 
    
    public void generarTabla(){
        gray("",monitors.size());
        
    }
    
    public void validate(){
        int tam = tabla.size();
        int tam2 = monitors.size();
        
        for(int i=0; i<tam; i++){
            
            
        }
    }
    
    public ArrayList<Monitor>subMonitor(String combinacion){
        ArrayList<Monitor> arrayM = new ArrayList<>();
        int tam= monitors.size();
        
        for(int i=0; i<tam; i++){
            if(combinacion.charAt(i) == '1'){
                arrayM.add(monitors.get(i));
            }
        }
        
        return arrayM;
    }
    
    
    public boolean checkNoIntegrante(Monitor monitor1, Monitor monitor2){
        boolean cruza = false;
            //Se compara que este en el mismo dia
            if (monitor1.getDia().equals(monitor2.getDia())){
                //Se compara sus horas se cruzan
                if (monitor1.getHoraInicio() < monitor2.getHoraFin() &&
                        monitor1.getHoraFin() > monitor2.getHoraInicio()){
                    cruza = true;
                }

            }

        return cruza;
    }
    
    
    public boolean checkTupla(ArrayList<Monitor> subMon){//2 a la n * n
        boolean resp=true;
        boolean cruza;
        int tam= subMon.size();
            
        for(int i=0; i<tam; i++){
            
            for(int j=0; j<tam; j++ ){
                
                if(i!=j){
                    cruza = checkNoIntegrante(subMon.get(i), subMon.get(j));
                    if(cruza){
                        resp=false;
                    }
                }
            }
            
        }  
        return resp;
    }
    

    //Getters y Setters
    public ArrayList<Monitor> getMonitors() {
        return monitors;
    }

    public void setMonitors(ArrayList<Monitor> monitors) {
        this.monitors = monitors;
    }
}
