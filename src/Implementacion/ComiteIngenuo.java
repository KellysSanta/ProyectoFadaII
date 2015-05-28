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

    //Metodo encargado de generar el menor comite
    public ArrayList<Monitor> generarComiteIngenua(){
        comite = new ArrayList<Monitor>();
        return comite;
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
    
    



    //Metodo encargado de verificar si el nuevo comite es menor que el que hay y si es asi lo añade
    public void addComite(ArrayList<Monitor> newComite){
        if (comite.size() == 0){
            comite = newComite;
            numComite = comite.size();
        }else if (comite.size() > newComite.size()){
            comite = newComite;
            numComite = comite.size();
        }
    }

    //Metodo encargado de verificar si un monitor puede no ser parte del comite
    public boolean checkNoIntegrante(ArrayList<Monitor> comite, Monitor monitor){
        boolean noIntegrante = false;
        for (int i = 0; i < comite.size(); i++) {
            //Se compara que este en el mismo dia
            if (monitor.getDia().equals(comite.get(i).getDia())){
                //Se compara si la hora de inicio del monitor esta entre una de las horas del comite
                if (monitor.getHoraInicio() < comite.get(i).getHoraFin() &&
                        monitor.getHoraFin() > comite.get(i).getHoraInicio()){
                    noIntegrante = true;
                }

            }
        }
        return noIntegrante;
    }

    //Funcion auxiliar que retorna un array list sin el monitor de la posicion que se le pasa
    public ArrayList<Monitor> excludeMonitor(ArrayList<Monitor> monitors, int posExclude){
        ArrayList<Monitor> tmp = new ArrayList<Monitor>(monitors); //Se crea una copia de los monitores
        tmp.remove(posExclude);//Se elimina el monitor de la posicion que se ingresa
        return tmp; //Se retorna la lista de monitores sin el monitor eliminado
    }

    //Getters y Setters
    public ArrayList<Monitor> getMonitors() {
        return monitors;
    }

    public void setMonitors(ArrayList<Monitor> monitors) {
        this.monitors = monitors;
    }
}
