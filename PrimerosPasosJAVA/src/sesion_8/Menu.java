package sesion_8;

import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {

        var consola = new Scanner(System.in); //in  - input entrda de datos
        var indexMenu = 0;
        var salir = false;
        do {
            System.out.print("***Menu****\n" +
                    "1: Crear usuario\n" +
                    "2: Eliminar usuario\n" +
                    "3: Salir \n" +
                    "escoge tu opcion " );

            indexMenu = Integer.parseInt(consola.nextLine());
            switch (indexMenu) {
                case 1:
                    System.out.println("creando usuario");
                   break;
                case 2:
                    System.out.println("eliminando usuario");
                    break;
                case 3:
                    System.out.println("log out");
                    salir = true;
                    break;

                default:
                    System.out.println("opcion invalida");

            };
        }while (!salir);
    }
}
