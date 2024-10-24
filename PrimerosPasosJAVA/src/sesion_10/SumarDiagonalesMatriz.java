package sesion_10;

import java.util.Scanner;

public class SumarDiagonalesMatriz {
    public static void main(String[] args) {

        var consola = new Scanner(System.in); //in  - input entrda de datos
        int[][] matriz;
        var filas = 0;
        var columnas = 0;
        var sumarMatriz = 0;

        //pedir la longitud de la matriz

        System.out.print("numero de filas de la matriz: ");
        filas = Integer.parseInt(consola.nextLine());

        System.out.print("numero de columnas de la matriz: ");
        columnas = Integer.parseInt(consola.nextLine());

        //asignacion de las filas y la columnas  para la matriz
         matriz = new int[filas][columnas];

         //llenar la info de arrglo
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {

                System.out.printf("ingresa el valor de la matirz en la posicion [%d][%d] ",i,j);
                matriz[i][j] = Integer.parseInt(consola.nextLine());

                if(i == j){
                    sumarMatriz += matriz[i][j];
                }

            }
        }

        //imprimir arreglo
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.printf("valor de la matirz en la posicion [%d][%d] es: %d %n",i,j,matriz[i][j]);
            }
        }
        System.out.println("la suma de las diagonales es "+sumarMatriz);

    }
}
