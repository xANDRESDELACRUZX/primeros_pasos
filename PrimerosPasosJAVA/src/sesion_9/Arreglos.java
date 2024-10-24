package sesion_9;

public class Arreglos {
    public static void main(String[] args) {

        //arreglo
        int[] enteros;

        //ijnicializar el  entero
        enteros = new int[5];

        //declarar e inicializar el arreglo
        int[] numeros = new int[2]; //declaron con el tipo de arreglo
        var numeros2 = new int[2]; //declaron con var

        //modificar el valor
        enteros[0] = 12;
        enteros[1] = 13;
        enteros[2] = 14;
        enteros[3] = 15;
        enteros[4] = 16;

        for (int i = 0; i < enteros.length ; i++) {
        System.out.printf("valor %d, posicion en el arreglo %d %n",enteros[i],i);
        }
        System.out.println("otro arreglo");
        //quemasr los datos en un arreglo
        //int[] numeros3 = {100,565,555,5,55,55989898,6666}; //con el tipo de dato
        var numeros3 = new int[]{100,565,555,5,55,55989898,6666}; // con var

        for (int i = 0; i < numeros3.length ; i++) {
            System.out.printf("valor %d, posicion en el arreglo %d %n",numeros3[i],i);
        }
    }
}
