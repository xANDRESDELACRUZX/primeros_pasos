package sesion_8;

public class NumeroImpares {
    public static void main(String[] args) {

        var i = 1;

        do {
            if( i % 2 == 1 )
                System.out.printf("el numero %d: es impar %n",i);

            i++;
        }while ( i <= 20);
    }
}
