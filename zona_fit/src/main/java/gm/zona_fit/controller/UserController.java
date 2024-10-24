package gm.zona_fit.controller;

import gm.zona_fit.modelo.User;
import gm.zona_fit.servicio.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private IUserService userService;

    @GetMapping("/getall")
    private ResponseEntity<List<User>> getAllUser(){
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }
    /*@GetMapping("/getall")
    private List<User> getAllUser(){
        return userService.getAllUsers();
    }*/

}
