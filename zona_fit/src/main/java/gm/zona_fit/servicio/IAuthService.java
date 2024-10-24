package gm.zona_fit.servicio;


import gm.zona_fit.modelo.User;
import gm.zona_fit.validaciones.UserForm;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

import java.util.HashMap;

public interface IAuthService{

    public HashMap<String, String> login(User user) throws Exception;

    public ResponseEntity<?> registrarUser (UserForm userForm, BindingResult result);
}
