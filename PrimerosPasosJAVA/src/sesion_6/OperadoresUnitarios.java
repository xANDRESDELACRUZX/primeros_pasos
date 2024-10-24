package sesion_6;

public class OperadoresUnitarios {
    public static void main(String[] args) {

        int a = 5, b = 3, respuesta;

        //suma+
        respuesta = a + b;
        System.out.println("respuesta = " + respuesta);

        //resta
        respuesta = a - b;
        System.out.println("respuesta = " + respuesta);

        //multiplicacion
        respuesta = a * b;
        System.out.println("respuesta = " + respuesta);

        //division
        respuesta = a / b;
        System.out.println("respuesta = " + respuesta);

        //residuo %
        respuesta = a % b;
        System.out.println("respuesta = " + respuesta);


        //operadores unitarios
        respuesta = +a;
        System.out.println("valor = " + respuesta);

        respuesta = -a;
        System.out.println("valor = " + respuesta);

        //operadores de incremento
        respuesta = ++a; // pre incremento se aumenta en esta linea de codigo
        System.out.println("valor = " +  respuesta);

        respuesta = a++; // post incremento se aumenta  la sigiente ves que se use la variable
        System.out.println("valor = " +  respuesta);
        System.out.println("a incrementada por el post = " + a);


        respuesta = --a; // pre decremento
        System.out.println("valor pre = " +  respuesta);

        respuesta = a--; // post decremento
        System.out.println("valor post = " +  respuesta);
        System.out.println("a decrementada por el post = " + a);
        
    }
}
