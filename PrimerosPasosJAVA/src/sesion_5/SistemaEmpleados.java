package sesion_5;

import java.util.Scanner;

public class SistemaEmpleados
{
    public static void main(String[] args) {
        var consola = new Scanner(System.in); //in  - input entrda de datos

        System.out.print("Escribe tu nombre ");
        var nombre = consola.nextLine();

        System.out.print("Escribe tu edad ");
        var edad = Integer.parseInt(consola.nextLine());

        System.out.print("Escribe tu salario ");
        var salario = Double.parseDouble(consola.nextLine());

        System.out.print("eres el jefe de tu area? ");
        var esJefe = Boolean.parseBoolean(consola.nextLine());

         System.out.print("Nombre "+ nombre +"\n");
         System.out.print("edad "+ edad+"\n");
         System.out.print("salario "+ salario+"\n");

         if (esJefe){
            System.out.print("eres jefe" );
            return;
         }
        System.out.print("no eres jefe" );

    }
}
