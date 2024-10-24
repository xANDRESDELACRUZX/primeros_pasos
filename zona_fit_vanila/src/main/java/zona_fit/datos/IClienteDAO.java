package  zona_fit.datos;

import zona_fit.dominio.Cliente;

import java.util.List;

public interface IClienteDAO {

    //listar todos
    List<Cliente> listarClientes();
    //listar por id
    boolean buscarClienteporID(Cliente cliente);
    //agregar
    boolean agregarCliente(Cliente cliente);

    //modificar
    boolean modificarCliente(Cliente cliente);

    //eliminar
    boolean elimarCliente(Cliente cliente);


}