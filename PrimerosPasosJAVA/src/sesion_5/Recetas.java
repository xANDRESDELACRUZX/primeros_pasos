package sesion_5;

import java.util.Scanner;

public class Recetas {

        public static void main(String[] args) {
            var consola = new Scanner(System.in); //in  - input entrda de datos

            System.out.print("Escribe el nombre ");
            var nombre = consola.nextLine();

            System.out.print("Escribe los ingredientes ");
            var ingredientes = consola.nextLine();

            System.out.print("tiempo de preparacion ");
            var tiempoPreparacion = consola.nextLine();

            System.out.print("dificulta de la receta (facil/medio/dificil) ");
            var dificultad = consola.nextLine();

            System.out.print("Nombre de la receta: "+ nombre +"\n");
            System.out.print("ingredientes: "+ ingredientes+"\n");
            System.out.print("tiempo de Preparacion: "+ tiempoPreparacion+"\n");
            System.out.print("dificultad: " + dificultad);

        }
    }

