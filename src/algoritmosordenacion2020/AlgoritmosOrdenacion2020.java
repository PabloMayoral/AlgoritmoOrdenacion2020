package algoritmosordenacion2020;

import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author pmart
 */
public class AlgoritmosOrdenacion2020 {

    public void ordenacionBurbuja(int[] numeros) {
        //el metodo recibe un array de numeros y lo ordenara mediante el algoritmo burbuja
        for (int j = 0; j < numeros.length; j++) {
            for (int i = 0; i < numeros.length - 1; i++) {
                if (numeros[i] > numeros[i + 1]) {
                    //si se cumple intercambio los valores de i e i+1
                    int aux = numeros[i + 1];
                    numeros[i + 1] = numeros[i];
                    numeros[i] = aux;
                }
            }
        }
    }
    int[] lista1 = {13, 27, 455, 621, 23, 1, 15};
    int[] arrayParaBurbuja;
    int[] arrayParaInserccion;

    public void ordenacionInsercion(int[] numeros) {
        for (int i = 2; i < numeros.length; i++) {
            int aux = numeros[i];
            int j = 0;
            for (j = i - 1; j >= 0 && numeros[j] > aux; j--) {
                numeros[j + 1] = numeros[j];
            }
            numeros[j + 1] = aux;
        }
    }

    //crea una array de tantos numeros aleatorios 
    //como le pasemos en la variable dimension
    public int[] generaNumerosRandom(int dimension) {
        int[] numeros = new int[dimension];
        Random r = new Random();
        for (int i = 0; i < dimension; i++) {
            numeros[i] = r.nextInt();
        }
        return numeros;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        AlgoritmosOrdenacion2020 ordenacion = new AlgoritmosOrdenacion2020();
        System.out.println("lista sin ordenar:" + Arrays.toString(ordenacion.lista1));

        ordenacion.ordenacionBurbuja(ordenacion.lista1);
        System.out.println("lista ordenada:" + Arrays.toString(ordenacion.lista1));

        //empiezo las pruebas de rendimiento de los distintos algoritmos
        int rangoPrueba = 10000;//numero de datos con los que probamos
        int[] numeros = ordenacion.generaNumerosRandom(rangoPrueba);
        ordenacion.arrayParaBurbuja = new int[rangoPrueba];
        ordenacion.arrayParaInserccion = new int[rangoPrueba];
        for (int i = 0; i < rangoPrueba; i++) {
            ordenacion.arrayParaBurbuja[i] = numeros[i];
            ordenacion.arrayParaInserccion[i] = numeros[i];
        }
        //aqui ya tengo dos copias exactas de la array de datos aleatorios 

        System.out.println("Empieza la burbuja: (vete a por un cafe)");
        long tiempoInicio = System.currentTimeMillis();

        ordenacion.ordenacionBurbuja(ordenacion.arrayParaBurbuja);

        long tiempoFinal = System.currentTimeMillis();
        System.out.println("La burbuja ha tardado: " + (tiempoFinal - tiempoInicio));

        ///////////////////////////////////////////////////////////////////////7
        
         System.out.println("Empieza la inserccion Directa: ");
        tiempoInicio = System.currentTimeMillis();

        ordenacion.ordenacionInsercion(ordenacion.arrayParaInserccion);

        tiempoFinal = System.currentTimeMillis();
        System.out.println("La Inserccion Directa ha tardado: " + (tiempoFinal - tiempoInicio));
    }

}
