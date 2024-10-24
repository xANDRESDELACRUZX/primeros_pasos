package gm.zona_fit.controller;


import gm.zona_fit.modelo.Cliente;

import gm.zona_fit.servicio.IClienteServicio;
import gm.zona_fit.validaciones.ClienteForm;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/")
public class ApiController {
    private final IClienteServicio iClienteServicio;
    
    @Autowired  // Inyección de dependencias a través del constructor
    public ApiController(IClienteServicio iClienteServicio) {
        this.iClienteServicio = iClienteServicio;
    }
    @GetMapping("/zonafit")
    public String prueba(){
        return "Secciona una opccion\n" +
                "\t1: listar clientes \n" +
                "\t2: agregar cliente\n" +
                "\t3: modificar cliente\n" +
                "\t4: eliminar cliente\n" +
                "\t5: buscar cliente\n" +
                "\t6: salir \n";
    }

    @GetMapping("/clientes")
    public List<Cliente> listarClientes(){
        try {
            return this.iClienteServicio.listarClientes();
        }catch (Exception e){
         manejoError(e);
         return null;
        }
    }
    @GetMapping("/cliente/{id}")
    public String buscarClienteByID (@PathVariable int id){
        var cliente = iClienteServicio.buscarCliente(id);
            if (cliente != null )
                return cliente.toString();
        return "cliente no encontrodo " + id;
    }
    @PostMapping("/saveCliente")
    public ResponseEntity<?> agregarCliente(@Valid @ModelAttribute ClienteForm clienteForm, BindingResult result) {

        if (result.hasErrors()) {
            // Mapa para almacenar errores
            Map<String, String> errores = new HashMap<>();

            // Recorrer los errores y añadirlos al mapa
            result.getFieldErrors().forEach(error ->
                    errores.put(error.getField(), error.getDefaultMessage())
            );
            return ResponseEntity.badRequest().body(errores);
        }

        Cliente cliente = new Cliente();
        cliente.setNombre(clienteForm.getNombre());
        cliente.setApellido(clienteForm.getApellido());
        cliente.setMembresia_id(clienteForm.getMembresia_id());

        //modificar
        if (clienteForm.getId() != null) {
            var clienteByID = iClienteServicio.buscarCliente(clienteForm.getId());
            if (clienteByID != null) {
                cliente.setId(clienteForm.getId());
                iClienteServicio.agregarCliente(cliente);
                return ResponseEntity.ok("cliente modificado correctamente");
            } else
                return ResponseEntity.ok("cliente no encontrado");
         // agregar
        }else if (clienteForm.getId() == null)
        iClienteServicio.agregarCliente(cliente);

        return ResponseEntity.ok("cliente agregado");
    }

    @PostMapping("/deleteCliente/{id}")
    public String deleteCliente (@PathVariable int id){
        var cliente = iClienteServicio.buscarCliente(id);
        if(cliente != null){
         iClienteServicio.eliminarCliente(cliente);
         return "Cliente eliminado";
        }
        return "cliente no encontrado " + id;
    }


    public void manejoError(Exception e){
        e.getMessage();
    }
}
