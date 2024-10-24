public class Cadenas {
    public static void main(String[] args) {
        var cadena1 = "hola";
        var cadena2 = new String("mundo");
        var cadena3 = cadena1 + " "+  cadena2;
        /*var cadena4 = """
                hola
                como estas
                """;*/
        var primerCaracter = cadena3.charAt(0);
        var caracter = cadena3.charAt(5);
        var ultimoCaracter = cadena3.charAt(9);
        System.out.println(primerCaracter+"\n"+caracter+"\n"+ultimoCaracter);

        for (int i = 0; i < cadena3.length() ; i++) {
            var item = cadena3.charAt(i);
            System.out.println(item);
        }

    }
}
