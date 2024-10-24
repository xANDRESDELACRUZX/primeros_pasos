package sesion_9;

import java.util.Scanner;

public class Calificaciones {
    public static void main(String[] args) {

        var consola = new Scanner(System.in); //in  - input entrda de datos
        var largoArr = 0 ;
        int[] calificaciones;
        var sumaPromedio = 0;
        var promedio = 0;

        //pedir el largo del arreglo
        System.out.print("numero de calificaciones ha ingresar ");
        largoArr = Integer.parseInt(consola.nextLine());

        calificaciones = new int[largoArr]; //inicializar el arreglo

        //llenar el arreglo
        for (int i = 0; i < calificaciones.length; i++) {
            System.out.printf("ingresa las calificacion %d ",i);
            calificaciones[i] = Integer.parseInt(consola.nextLine());
            sumaPromedio += calificaciones[i];// sumar las notas
        }
        promedio = sumaPromedio/ calificaciones.length; //sacar el promedio

        //imprimir respuesta
        System.out.println("el promedio de las notas es de "+promedio);

    }
}
