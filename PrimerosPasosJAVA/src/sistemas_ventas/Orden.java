package sistemas_ventas;

public class Orden {

    private final int idOrden;
    Producto[] producto;
    private int contadorProductos;
    private static final int MAX_PRUDUCTOS = 10;
    private static  int contadorOrdenes;

    //constructor
    public Orden(){
        this.idOrden = ++Orden.contadorOrdenes;
        this.producto = new Producto[Orden.MAX_PRUDUCTOS];

    }
    //crear producto
    public  void agregarProducto(Producto producto){

        this.producto[this.contadorProductos++] = producto;
    }
    //calcular total orden
    public int calcularTotal(){

        int total = 0;
        for (int i = 0; i < this.contadorProductos; i++) {
            var producto = this.producto[i];
            total += producto.getPrecio();

        }
        return total ;
    }
    //imprimir  facturas

    public  void mostrarOrden(){
        var totalOrden = this.calcularTotal();
        System.out.println("el id de la orden es: "+this.idOrden+ "\n");
        System.out.println("\tel total de la la venta es: "+totalOrden+ "\n");
        for (int i = 0; i < this.contadorProductos; i++) {
            var producto = this.producto[this.contadorProductos];
            System.out.println("\t\t "+this.producto[i]);

        }
    }
}
