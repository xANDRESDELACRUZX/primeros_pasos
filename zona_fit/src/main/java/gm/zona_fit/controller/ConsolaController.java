package gm.zona_fit.controller;

import gm.zona_fit.ZonaFitApplication;
import gm.zona_fit.modelo.Cliente;
import gm.zona_fit.servicio.IClienteServicio;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;


import java.util.Scanner;
@Controller  // Asegúrate de que Spring gestione esta clase
public class ConsolaController  {


    private final IClienteServicio iClienteServicio;
    @Autowired  // Inyección de dependencias a través del constructor
    public ConsolaController(IClienteServicio iClienteServicio) {
        this.iClienteServicio = iClienteServicio;
    }

    private final Scanner consola = new Scanner(System.in); //in  - input entrda de datos
    private  static  final Logger logger =
            LoggerFactory.getLogger(ZonaFitApplication.class);


    public void zonaFit(){
        var consola = new Scanner(System.in);
        var salir = false;

        while(!salir){
            var opcion = mostrarMenu();
            salir = ejecujaropcines(opcion);//,consola);
        }
    }

    public int mostrarMenu(){
        System.out.print("Secciona una opccion\n" +
                "\t1: listar clientes \n" +
                "\t2: agregar cliente\n" +
                "\t3: modificar cliente\n" +
                "\t4: eliminar cliente\n" +
                "\t5: buscar cliente\n" +
                "\t6: salir \n");
        return Integer.parseInt(consola.nextLine());
    }

    public  boolean  ejecujaropcines(int opccion){
        Cliente cliente = pedirInputs(opccion);
        switch (opccion) {
            case 1:
                listarClientes();
                break;
            case 2:
            case 3:

                if (opccion == 3 && cliente.getId() != null){
                    var clienteConsulta = iClienteServicio.buscarCliente(cliente.getId());
                    if (clienteConsulta != null){
                        iClienteServicio.agregarCliente(cliente);
                        logger.info("se modifico el cliente");
                    }else
                        logger.info("no se modifico el cliente");
                } else if (opccion == 2 && cliente.getId() == null) {
                    iClienteServicio.agregarCliente(cliente);
                    logger.info("se se agrego  el cliente");

                }else
                    logger.info("no se encontro el id"+ cliente.getId());
                break;
            case 4:
                var id = cliente.getId();
                var clienteConsulta = iClienteServicio.buscarCliente(id);

                if (clienteConsulta != null){
                    iClienteServicio.eliminarCliente(cliente);
                    logger.info("cliente eliminado");
                }else
                    logger.info("cliente no encontrado" +cliente.getId());

                break;
            case 5:
                var clienteByID = this.iClienteServicio.buscarCliente(cliente.getId());
                if (clienteByID != null)
                    System.out.println(clienteByID);
                else
                    System.out.println("no se encontro el cliente "+ cliente.getId());
                break;
            case 6:
                return true;
            default:
                // Maneja el caso por defecto si es necesario
                System.out.println("Opción no válida.");
                break;
        }
        return false;
    }

    public Cliente pedirInputs(int opccion ){
        var cliente = new Cliente();
        switch (opccion) {
            case 2:
            case 3:
                if (opccion == 3) {
                    System.out.print("Ingresa el id del cliente ");
                    var idClienteADDUPD = Integer.parseInt(consola.nextLine());//
                    cliente.setId(idClienteADDUPD);
                }
                System.out.print("Ingresa los nombres del cliente ");
                var nombreCliente = consola.nextLine();//set nombre

                System.out.print("Ingresa los apellidos del cliente ");
                var apellidoCliente = consola.nextLine();//set apellido

                System.out.print("Ingresa la membresia del cliente ");
                var membresia = Integer.parseInt(consola.nextLine());//set membresia

                cliente.setNombre(nombreCliente);
                cliente.setApellido(apellidoCliente);
                cliente.setMembresia_id(membresia);
                break;

            case 4:
            case 5:
                listarClientes();
                System.out.println();
                System.out.print("Ingresa el id del cliente ");
                var idCliente = Integer.parseInt(consola.nextLine());//
                cliente.setId(idCliente);
                break;
        }
        return cliente;
    }

    public void  listarClientes(){
        var listaCliente = this.iClienteServicio.listarClientes();
        listaCliente.forEach(System.out::println);
    }
}
