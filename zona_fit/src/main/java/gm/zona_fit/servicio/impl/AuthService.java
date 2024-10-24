package gm.zona_fit.servicio.impl;

import gm.zona_fit.modelo.User;
import gm.zona_fit.repositorio.IUserRepositorio;
import gm.zona_fit.servicio.IAuthService;
import gm.zona_fit.servicio.IJWTUtilityService;
import gm.zona_fit.servicio.IUserService;
import gm.zona_fit.validaciones.UserForm;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
@Service
public class AuthService implements IAuthService {

    @Autowired
    private IUserRepositorio userRepositorio;

    @Autowired
    private IJWTUtilityService jwtUtilityService;

    //@Autowired //validaror en un futri
    //private IUserService userService;

    @Override
    public HashMap<String, String> login(User user) throws Exception {
        try {
            HashMap<String, String> jwt = new HashMap<>();
            Optional<User> userFind  = userRepositorio.finByEmail(user.getEmail());

              if(userFind.isEmpty()){
                  jwt.put("error","usuario no encontrado");
                  return  jwt;
              }

              if (verificarPassword(user.getPassword(), userFind.get().getPassword())){
                  jwt.put("jwt", jwtUtilityService.generateJWT(userFind.get().getId()));
              }else
                  jwt.put("error","error en la autenticacion");

            return jwt;
        }catch (Exception e){
            throw new Exception(e.toString());
        }

    }
    private  boolean verificarPassword (String userLoginPassword, String password){
        BCryptPasswordEncoder encoder =  new BCryptPasswordEncoder();
        return  encoder.matches(userLoginPassword,password);
    }
    @Override
    public ResponseEntity<?> registrarUser (@Valid @ModelAttribute UserForm userForm, BindingResult result){

        if (result.hasErrors()) {
            // Mapa para almacenar errores
            Map<String, String> errores = new HashMap<>();

            // Recorrer los errores y añadirlos al mapa
            result.getFieldErrors().forEach(error ->
                    errores.put(error.getField(), error.getDefaultMessage())
            );
            return ResponseEntity.badRequest().body(errores);
        }

        //validar si existe el usuario
        List<User> getAllUsers = userRepositorio.findAll();

        for (User existingUser : getAllUsers){
         if (existingUser.getEmail().equals(userForm.getEmail())){
             return ResponseEntity.badRequest().body("el correo ya existes");
         }
        }


        //llenar el modelo user
        var user = new User();
        user.setNombres(userForm.getNombres());
        user.setApellidos(userForm.getApellidos());
        user.setEmail(userForm.getEmail());
        user.setPassword(userForm.getPassword());


        //encriptar pasword
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);
        user.setPassword(encoder.encode(user.getPassword()));

        //guardar user
        userRepositorio.save(user);
        return ResponseEntity.ok("usuario creado correctamente");
    }

}
