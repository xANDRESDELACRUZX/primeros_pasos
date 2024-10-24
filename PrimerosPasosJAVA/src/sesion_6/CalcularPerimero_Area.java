package sesion_6;

import java.util.Scanner;

public class CalcularPerimero_Area {
    public static void main(String[] args) {
        var consola = new Scanner(System.in); //in  - input entrda de datos

        //usuario
        System.out.print("Escribe la base de rectangulo ");
        var base = Integer.parseInt(consola.nextLine());

        //contraseña
        System.out.print("Escribe la altura de rectangulo ");
        var altura = Integer.parseInt(consola.nextLine());

        //calcular area

        var area = base * altura;
        var perimetro = 2 *(base + altura);

        System.out.printf("El area es: %d, El perimetro %d", area, perimetro);
    }
}
