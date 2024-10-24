package sesion_5;

public class FormateoCadenas {
    public static void main(String[] args) {
        var nombre = "Andres";
        var edad = 24;
        var salaraio = 1000.20;

        //string format
        var mensaje = String.format("nombre: %s, Edad: %d, Salario $%.2f",nombre, edad,salaraio);
        System.out.println(mensaje);

        //printf
        System.out.printf("nombre: %s, Edad: %d, Salario $%.2f",nombre, edad,salaraio);
    }
}
