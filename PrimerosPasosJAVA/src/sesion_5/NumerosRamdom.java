package sesion_5;

import java.util.Random;

public class NumerosRamdom
{
    public static void main(String[] args) {
        var ramdom = new Random();

        //genrar numeros random
        var guid = ramdom.nextInt(10 + 1);
        System.out.println(guid);

        //generar un numero ramdon  flotante  entre 0,1 y 1.0
        var guidFlotante = ramdom.nextFloat();
        System.out.println(guidFlotante);

    }
}
