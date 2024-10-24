
public class GeneradorEmail {
    public static void main(String[] args) {
        var nombre = " Andres Felipe De La Cruz Vargas";
        var empresa = "Super GIROS";
        var dominio = "com.co";

        var email = new StringBuilder();
        var nombreUsuarioLimpio = nombre.strip().replace(" ", ".").toLowerCase();
        var nombreEmpresaLimpio = empresa.replace(" ", ".").strip().toLowerCase();

        email.append(nombreUsuarioLimpio);//nmbre
        email.append(".");//normalizacion
        email.append("@"); // arroba
        email.append(nombreEmpresaLimpio); // empresa
        email.append(".");//punto
        email.append(dominio);
        System.out.println(email);
    }
}
