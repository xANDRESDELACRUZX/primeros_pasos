package sesion_6;

import java.util.Scanner;

public class Login {
    public static void main(String[] args) {
        var consola = new Scanner(System.in); //in  - input entrda de datos
        final var userCorrecto = "andres";
        final var passwordCorrecto = "andres";

        //usuario
        System.out.print("Escribe tu usuario ");
        var user = consola.nextLine();

        //contraseña
        System.out.print("Escribe tu contraseña ");
        var password = consola.nextLine();

        //validar del login
        
        if (userCorrecto.equals(user) && passwordCorrecto.equals(password)){
            System.out.println("log in");
                return;
        } else if (userCorrecto.equals(user) && password != passwordCorrecto) {
            System.out.println("credenciales incorrectas");
            return;
        }

        System.out.println("no existe el usuario");

    }
}
