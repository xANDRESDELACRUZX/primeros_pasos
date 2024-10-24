package zona_fit.menu;

import zona_fit.datos.ClienteDAO;
import zona_fit.datos.IClienteDAO;
import zona_fit.dominio.Cliente;

import java.util.List;
import java.util.Scanner;

public class Menu {
    private final Scanner consola = new Scanner(System.in); //in  - input entrda de datos
    //private final ClienteDAO clientedao = new ClienteDAO();
    private final IClienteDAO clientedao = new ClienteDAO();



    public void agregarCliente(){

        System.out.print("Ingresa los nombres del cliente ");
        var nombreCliente = consola.nextLine();//set nombre

        System.out.print("Ingresa los apellidos del cliente ");
        var apellidoCliente = consola.nextLine();//set apellido

        System.out.print("Ingresa la membresia del cliente ");
        var membresia = Integer.parseInt(consola.nextLine());//set membresia

        var cliente = new Cliente(nombreCliente, apellidoCliente, membresia);
        var addCliente = clientedao.agregarCliente(cliente);
        if (addCliente)
            System.out.println("se agrego el usuario correctamente:" + cliente);
        else
            System.out.println("no se agrego el cliente");

    }

    public void modificarCliente(){

        this.listarClientes();

        System.out.print("Ingresa el id del cliente ");
        var idCliente = Integer.parseInt(consola.nextLine());//

        var clienteConsuta = new Cliente(idCliente);
        var clienteFind = clientedao.buscarClienteporID(clienteConsuta);

        if (clienteFind){

        System.out.print("Ingresa los nombres del cliente ");
        var nombreCliente = consola.nextLine();//set nombre

        System.out.print("Ingresa los apellidos del cliente ");
        var apellidoCliente = consola.nextLine();//set apellido

        System.out.print("Ingresa la membresia del cliente ");
        var membresia = Integer.parseInt(consola.nextLine());//set membresia

        var cliente = new Cliente(idCliente,nombreCliente, apellidoCliente, membresia);
        var updateCliente = clientedao.modificarCliente(cliente);

        if (updateCliente)
            System.out.println("se modifico el usuario correctamente:" + cliente);
        else
            System.out.println("no se modifico el cliente");
        }
        else
            System.out.println("cliente no encotrado");
    }

    public void eliminarCliente(){

        this.listarClientes();

        System.out.print("Ingresa el id del cliente ");
        var idCliente = Integer.parseInt(consola.nextLine());//

        var cliente = new Cliente(idCliente);
        var deleteCliente = clientedao.elimarCliente(cliente);

        if (deleteCliente)
            System.out.println("se elimino el usuario correctamente:" + cliente);
        else
            System.out.println("no se elimino el cliente");

    }

    public void listarClientes(){

        var listaCliente = clientedao.listarClientes();
        System.out.println(listaCliente);

    }

    public void listarClientebyid(){

        this.listarClientes();

        System.out.print("Ingresa el id del cliente ");
        var idCliente = Integer.parseInt(consola.nextLine());//

        var cliente = new Cliente(idCliente);
        var clientebyid = clientedao.buscarClienteporID(cliente);
        if (clientebyid)
            System.out.println(cliente);
        else
            System.out.println("no se encuentra cliente con ese id " + cliente.getIdCliente());

    }

    public void menu(){
        var salir = false;

        while (!salir){
            System.out.print("Secciona una opccion\n" +
                    "\t1: listar clientes \n" +
                    "\t2: agregar cliente\n" +
                    "\t3: modificar cliente\n" +
                    "\t4: eliminar cliente\n" +
                    "\t5: buscar cliente\n" +
                    "\t6: salir \n");
            var opccion = Integer.parseInt(consola.nextLine());//

            switch (opccion){
                case 1:
                    this.listarClientes();
                    break;
                case 2:
                    this.agregarCliente();
                    break;
                case 3:
                    this.modificarCliente();
                    break;
                case 4:
                    this.eliminarCliente();
                    break;
                case 5:
                    this.listarClientebyid();
                    break;
                case 6:
                    salir = true;
                    break;
            }
        }

    }
}

