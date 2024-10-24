package sistemas_ventas;

public class PruebaVenta {
    public static void main(String[] args) {
        var producto_1 = new Producto("pizza" , 1000);
        System.out.println(producto_1);
        var producto_2 = new Producto("telefono" , 2000);


        //orden
         var orden = new Orden();

         orden.agregarProducto(producto_1);
         orden.agregarProducto(producto_2);
         orden.mostrarOrden();
    }
}
