/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejerciciosnivel01java;

import static java.lang.Double.max;
import java.util.Arrays;

/**
 *
 * @author Rocio Soriano Gomez
 */
public class EjerciciosNivel01Java {

    int[] listaNumeros = {333, 31, 200, 20, 5, 99};

    public int[] maximo(int[] lista) {

//lo que esta [aqui dentro] es donde queremos que empiece a comparar
        int auxiliar = lista[0];
        //necesitamos unaseguna variable para encontrar el segundo maximo
        int maximo2 = lista[1];

        // no hay q hacer lista.length-1 xk preguntamos por lo que sea menor,
        //no menor o =
        for (int i = 0; i < lista.length; i++) {

            if (auxiliar < lista[i]) {
                //hacemos referencia a que el maximo será el de la lista
                maximo2 = auxiliar;
                auxiliar = lista[i];
            } else if (maximo2 < lista[i] && lista[i] != auxiliar) {
                maximo2 = lista[i];
            }
        }
        int[] max = {auxiliar, maximo2};
        return max;
    }

    public boolean palindromo(String frase) {
//este metodo solo funciona con palabras sin tilde

        frase = frase.toUpperCase();
        int incrementa = 0;
        frase = quita(frase);
        //-1 para que nos mida la longitud real
        int desciende = frase.length() - 1;
        //METODO PARA NO USAR EQUALS

        while ((incrementa < desciende) && (frase.charAt(incrementa) == frase.charAt(desciende))) {
            incrementa++;
            desciende--;
        }
        if (incrementa > desciende) {
            System.out.println("la frase " + frase + " es palindromo bro, tú molas!!!");
            return true;
        } else {
            System.out.println("la frase " + frase + " no es palíndromo bro, eres mierda!!");
            return false;
        }
    }
    //creamos un METODO QUITA
    private String quita(String cadena) {
        String auxiliar = "";
        for (int i = 0; i < cadena.length(); i++) {
            if (cadena.charAt(i) != ' ') {
                auxiliar = auxiliar + cadena.charAt(i);
            }   
        }
          return auxiliar;
    }

    //MI METODO::
    //metodo para quitar espacios y lo devuelva en mayuscula
    // Si queremos saber si es palíndromo una frase
    /*
        //creo la cadena al reves
        int auxiliar2 = auxiliar.length() - 1;
        String aux2 = "";

        for (int i = auxiliar2; i >= 0; i--) {
            aux2 = aux2 + auxiliar.charAt(i);
        }
        //comparamos cadenas
        if (auxiliar.equals(aux2)) {
            System.out.println("la frase " + frase + " es palindromo bro, tú molas!!!");
            return true;

        } else {
            System.out.println("la frase " + frase + " no es palíndromo bro, eres mierda!!");
            return false;
        }
    }
     */
    public boolean isograma(String str) {
        str = str.toUpperCase();
        int numero = str.length();
        int auxiliar = 0;
        //por si te pones cabron y es una frase
        str = quita(str);

        for (int i = 0; i < numero; i++) {
            for (int j = 0; j < numero; j++) {
                if (str.charAt(i) == str.charAt(j)) {
                    auxiliar++;
                    System.out.println(" " + auxiliar + "");
                }
            }
        }
        if (numero == auxiliar) {
            System.out.println("la palabra " + str + " es un isograma, esto aumenta tu autoestima de mierda");
            return true;
        }
        System.out.println("la palabra " + str + " no es un isograma, no vales ni para tomar por culo");
        return false;
    }
    
    public String acronimo(String frase){
        try{
            frase = frase.toUpperCase();
            String[] arr=frase.split(" ");//convertir frase en array de palabras
            String[] forbidden = {"Y", "E", "DE", "LA", "LAS"};//palabras prohibidas
            String acronim = "";
            for(int i=0;i<arr.length;i++){
                boolean del = false;
                for (int j = 0; j<forbidden.length;j++){
                    if (arr[i].equals(forbidden[j]) && !del){
                        del = true;//detector de si esa palabra hay que eliminarla o no
                    }
                }
                if (!del){
                    acronim += arr[i].charAt(0);
                }
            }
            return acronim;
        }
        catch(Exception e){
            String error = "error al procesar la frase, comprueba que no haya espacios extra :D";
            return error;
        }
    }
    public void imprimeMes(int dia){
        if (dia > 0 && dia <= 7){
            int contador = 0;
            for (int i = 1; i < dia; i++){
                    System.out.print("XX ");
                    contador = contador + 1;
            }
            for (int j = 1; j <= 31; j++){
                if(contador < 7){
                    if(j < 10){
                        System.out.print("0" + j + " ");//añade 0 inicial en los valores inferiores a 10
                        contador += 1;
                    }
                    else{
                        System.out.print(j + " ");
                        contador += 1;
                    }
                }
                if (contador >= 7){
                    System.out.println("");//añade salto de linea cuando ha cumplido todos los dias de la semana
                    contador = 0;
                }
            }
            for (int x = contador; x < 7; x++){
                System.out.print("XX ");//dias sin numero se reemplazan por XX
            }
            System.out.println("");
        }
        else{
            System.out.println("Elige un numero entre el 1 y el 7");
        }
    }
     public boolean anagrama(String palabra1, String palabra2) {
        palabra1 = palabra1.toUpperCase();
        palabra2 = palabra2.toUpperCase();
        palabra1 = quita(palabra1);
        palabra2 = quita(palabra2);
        if (palabra1.length() == palabra2.length()){ 
            char [] string1 = palabra1.toCharArray();//pasa la string a arrays de caracteres
            char [] string2 = palabra2.toCharArray();
            Arrays.sort(string1);//coloca los caracteres de la array en orden ascendente
            Arrays.sort(string2);
            return (Arrays.equals(string1, string2));//compara
        }
        return false;
    }

        
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EjerciciosNivel01Java ejercicio = new EjerciciosNivel01Java();
         System.out.println("Maximo y segundo maximo:");
        System.out.println(Arrays.toString(ejercicio.maximo(ejercicio.listaNumeros)));
        System.out.println("palindromo:");
        System.out.println(ejercicio.palindromo("ligar es ser agil"));
        System.out.println("isograma:");
        System.out.println(ejercicio.isograma("murcielago"));
        System.out.println("acronimo:");
        System.out.println(ejercicio.acronimo("murcielago demente monge arbitro"));
        System.out.println("calendario");
        ejercicio.imprimeMes(4);
        
        System.out.println("anagrama");
        if (ejercicio.anagrama("cosa", "saco")){
            System.out.println("Es un anagrama");
        }
       
        

    }

}
