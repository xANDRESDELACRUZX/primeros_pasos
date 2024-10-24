package gm.zona_fit.servicio;

import gm.zona_fit.modelo.User;

import java.util.List;
import java.util.Optional;

public interface IUserService {


    public boolean eliminarCliente(User user);

    public Optional<User> buscarByEmail(String email);

    public List<User> getAllUsers();

}
