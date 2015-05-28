/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Implementacion;

import java.util.ArrayList;

/**
 *
 * @author cenesis
 */

    
public class Prueba{
    
    private ArrayList<String> resultado= new ArrayList<String>();

    // append reverse of order n gray code to prefix string, and print
    public void yarg(String prefix, int n) {
        System.out.println(" que hace");
        if (n == 0){
                      resultado.add(prefix);
        }
        else {
            gray(prefix + "1", n - 1);
            yarg(prefix + "0", n - 1);
        }
    }  

    // append order n gray code to end of prefix string, and print
    public void gray(String prefix, int n) {
        System.out.println("hola");
        if (n == 0){
                      resultado.add(prefix);
        }
        else {
            gray(prefix + "0", n - 1);
            yarg(prefix + "1", n - 1);
        }
        
        
    }  
    
    public void imprimir(){
        int tam = resultado.size();
        
        for(int i =0; i<tam; i++){
            System.out.println(resultado.get(i));
        }
    }


    public static void main(String[] args) {
        int N = 4;
        Prueba p = new Prueba();
        p.gray("", N);
        //p.imprimir();
        
    }

}

