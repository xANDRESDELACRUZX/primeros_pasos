package sesion_8;

public class SumaAcumulativa {
    public static void main(String[] args) {
        var i = 1;
        var suma = 0;
        while (i<= 5){
            suma += i;
           i++;
        }
        System.out.println(suma);
    }
}
