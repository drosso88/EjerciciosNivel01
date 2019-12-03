/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejerciciosnivel01java;

/**
 *
 * @author Rocio Soriano Gomez
 */
public class EjerciciosNivel01Java {
    int [] listaNumeros= {50, 31, 27, 2, 5, 99};

public int maximo (int []lista){
    int auxiliar = lista [0];
    for (int i=0; i<lista.length;i++){
        if (auxiliar < lista [i]){
            auxiliar=lista [i];
        }
    }
    return auxiliar;
}
   
public int[] maximos ( int[] lista){
        int [] arrayMaximos = {lista[0], lista[0]};
        
        for (int i=0; i< lista.length; i++){
           if (arrayMaximos[0] < lista[i]){
               arrayMaximos[1] = arrayMaximos[0];
               arrayMaximos[0] = lista[i];
           } 
        }
        return arrayMaximos;
    }
   
    /**
     * @param args the command line arguments
     */
    public static void main (String [] args) {
        EjerciciosNivel01Java ejercicio =new EjerciciosNivel01Java();
        System.out.println(ejercicio.maximo(ejercicio.listaNumeros));
          
       
    }
    
}
       


        
    
    

