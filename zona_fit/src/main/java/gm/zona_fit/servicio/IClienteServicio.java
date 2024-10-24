package gm.zona_fit.servicio;

import gm.zona_fit.modelo.Cliente;

import java.util.List;

public interface IClienteServicio {

    public List<Cliente> listarClientes();

    public Cliente buscarCliente(Integer idCliente);

    public void agregarCliente(Cliente cliente);

    public boolean eliminarCliente(Cliente cliente);
}