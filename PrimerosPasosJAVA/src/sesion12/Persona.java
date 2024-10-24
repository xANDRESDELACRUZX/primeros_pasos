package sesion12;

public class Persona {
    private String nombre;
    private String apellido;
    private String email;
    private int telefonio;

    public Persona(String nombre, String apellido){
        this.nombre = nombre;
        this.apellido = apellido;

    }

    void motrarPersona(){
        System.out.println("nombre " + this.nombre);
        System.out.println("apellido " + this. apellido);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getTelefonio() {
        return telefonio;
    }

    public void setTelefonio(int telefonio) {
        this.telefonio = telefonio;
    }
}
