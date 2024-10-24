package gm.zona_fit.controller;

import gm.zona_fit.modelo.User;
import gm.zona_fit.servicio.IAuthService;
import gm.zona_fit.servicio.IJWTUtilityService;
import gm.zona_fit.validaciones.UserForm;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private IAuthService authService;
    @Autowired
    private IJWTUtilityService jwtUtilityService;




    @PostMapping("/login")
    private ResponseEntity<HashMap<String,String>> login( User user) throws Exception {
       HashMap<String,String> login = authService.login(user);
       if(login.containsKey("jwt")){
           return new ResponseEntity<>(login, HttpStatus.OK);
       }
       return  new ResponseEntity<>(login, HttpStatus.UNAUTHORIZED);
    }

    @PostMapping("/register")
    private ResponseEntity<?> register (@Valid @ModelAttribute UserForm userForm, BindingResult result){
        return authService.registrarUser(userForm,result);
    }


}
