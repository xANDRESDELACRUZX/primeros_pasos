package sesion_10;

public class matrices {
    public static void main(String[] args) {

        //definir la matriz

        //int[][] matriz =  new int[2][3];
        var matriz = new int[2][3];

        //modificar valores
        matriz[0][0] = 123;
        matriz[0][1] = 12366777;
        matriz[0][2] = 123556767;
        matriz[1][0] = 12234233;
        matriz[1][1] = 12343243;
        matriz[1][2] = 124234;

        //imprimir matriz
        for (int i = 0; i <  matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {

            System.out.printf("valor %d, posicion en el arreglo [%d][%d] %n",matriz[i][j],i,j);
            }
        }


    }
}
