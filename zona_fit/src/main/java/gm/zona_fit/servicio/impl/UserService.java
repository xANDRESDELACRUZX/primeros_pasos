package gm.zona_fit.servicio.impl;

import gm.zona_fit.modelo.User;
import gm.zona_fit.repositorio.IUserRepositorio;
import gm.zona_fit.servicio.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service // importate
public class UserService implements IUserService {

    @Autowired
    private IUserRepositorio userRepositorio;
    public void agregarCliente(User user) {
        userRepositorio.save(user);
    }

    @Override
    public boolean eliminarCliente(User user) {
        userRepositorio.delete(user);
        return false;
    }

    @Override
    public Optional<User> buscarByEmail(String email){
        return userRepositorio.finByEmail(email);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepositorio.findAll();
    }
}
