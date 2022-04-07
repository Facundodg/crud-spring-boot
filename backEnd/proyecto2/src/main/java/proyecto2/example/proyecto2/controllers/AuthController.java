package proyecto2.example.proyecto2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import proyecto2.example.proyecto2.dao.UsuarioDao;
import proyecto2.example.proyecto2.models.Usuario;

@RestController
public class AuthController {

    @Autowired
    private UsuarioDao usuarioDao;

    @RequestMapping(value = "api/login", method = RequestMethod.POST) // esta anotacion indica la url para ingresar a esta funcion
    public String login(@RequestBody Usuario usuario){

        //@RequestBody = convierte el json a un usuario
        //estoy traeria un jason con todos los datos de nuestro usuario
        if(usuarioDao.verificarCredenciales(usuario)){

            return "OK";

        }

        return "FAIL";
    }
}
