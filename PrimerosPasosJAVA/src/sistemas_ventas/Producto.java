package sistemas_ventas;

public class Producto {
    private int idProducto;
    private  String nombre;
    private  int precio;
    private static int contadorProducto = 0;

    public Producto(String nombre, int precio){
        this.idProducto = ++Producto.contadorProducto;
        this.nombre = nombre;
        this.precio = precio;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public static int getContadorProducto() {
        return contadorProducto;
    }

    public static void setContadorProducto(int contadorProducto) {
        Producto.contadorProducto = contadorProducto;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "idProducto=" + idProducto +
                ", nombre='" + nombre + '\'' +
                ", precio=" + precio +
                '}';
    }
}
