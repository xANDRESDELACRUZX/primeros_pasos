package sesion_5;

import java.util.Scanner;

public class ManejoConsola {
    public static void main(String[] args) {
        var consola = new Scanner(System.in); //in  - input entrda de datos
        System.out.println("Escribe tu nombre");
        var nombre = consola.nextLine();

        System.out.println(nombre);
    }
}
