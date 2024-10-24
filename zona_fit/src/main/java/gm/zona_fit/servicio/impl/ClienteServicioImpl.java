package gm.zona_fit.servicio.impl;

import gm.zona_fit.modelo.Cliente;
import gm.zona_fit.repositorio.ICliente;
import gm.zona_fit.servicio.IClienteServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service // importate
@Primary
public class ClienteServicioImpl implements IClienteServicio {

    @Autowired
    private ICliente iClienteRepositorio;


    @Override
    public List<Cliente> listarClientes() {
        return iClienteRepositorio.findAll();
    }

    @Override
    public Cliente buscarCliente(Integer idCliente) {

        return iClienteRepositorio.findById(idCliente).orElse(null);
    }

    @Override
    public void agregarCliente(Cliente cliente) {
        iClienteRepositorio.save(cliente);
    }

    @Override
    public boolean eliminarCliente(Cliente cliente) {
        iClienteRepositorio.delete(cliente);
        return false;
    }
}
