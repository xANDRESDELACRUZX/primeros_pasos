package sesion_6;

public class OperadoresAsignacion {
    public static void main(String[] args) {
        //asignacion
        var miNumero = 10;
        int miNumero2;

        //asignacion compuesta
        miNumero += 5; // miNumero = minumero + 5;
        System.out.println("miNumero = " + miNumero);

        // -=, *=. /= Y %=
        miNumero -= 5; // miNumero = minumero - 5;
        System.out.println("miNumero - = " + miNumero);
        miNumero *= 5; // miNumero = minumero * 5;
        System.out.println("miNumero *= " + miNumero);
        miNumero /= 5; // miNumero = minumero / 5;
        System.out.println("miNumero  /= " + miNumero);
        miNumero %= 5; // miNumero = minumero % 5;
        System.out.println("miNumero  %= " + miNumero);

        //asignacion de variables multiples
        int a = 5, b = 3, respuesta; //  tipo de dato especifico y especificarle el valor

    }
}
