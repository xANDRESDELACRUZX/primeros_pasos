package sesion_5;

import java.util.Random;
import java.util.Scanner;

public class GeneradorIdUnico
{
    public static void main(String[] args) {
        var ramdom = new Random();
        var consola = new Scanner(System.in); //in  - input entrda de datos
        var idUnico = new StringBuilder();

        System.out.print("Ingresa tus nombres ");
        var nombre = consola.nextLine();

        System.out.print("Ingresa tus apellidos ");
        var apellido = consola.nextLine();

        System.out.print("ingresa tu año de nacimento (YYYY) ");
        var año = consola.nextLine();

        var guid = ramdom.nextInt(9999);

        //generar el id unico
        idUnico.append(nombre.toUpperCase().charAt(0));
        idUnico.append(nombre.toUpperCase().charAt(1));
        idUnico.append(apellido.toUpperCase().charAt(0));
        idUnico.append(apellido.toUpperCase().charAt(1));
        idUnico.append(año.toUpperCase().charAt(2));
        idUnico.append(año.toUpperCase().charAt(3));
        idUnico.append(String.format("%04d",guid));


        System.out.printf("nombres: %s, Apellidos: %s, Año de nacimiento  %s, ID: %s",nombre, apellido,año,idUnico);


    }
}
