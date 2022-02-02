package proyecto2.example.proyecto2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import proyecto2.example.proyecto2.dao.UsuarioDao;
import proyecto2.example.proyecto2.models.Usuario;

import java.util.ArrayList;
import java.util.List;

@RestController // esta anotacion le indicamos que esta clase va a ser un controlador
public class UsuarioController {


    @Autowired //lo que hace es que UsuarioDaoImp cree un objeto y lo guarde en esta variable

    //----------------INGRESAR USUARIO----------------------

    private UsuarioDao usuarioDao; //INYECCION DE DEPENDENCIAS
    //si usamos autowired en otras partes del proyecto ese objeto se comparte en memoria y puede generar un conflicto
    @RequestMapping(value = "api/usuario/{id}", method = RequestMethod.GET) // esta anotacion indica la url para ingresar a esta funcion
    public Usuario getUsuario(@PathVariable Long id){

        //estoy traeria un jason con todos los datos de nuestro usuario

        Usuario usuario = new Usuario();

        usuario.setId(id);
        usuario.setNombre("Facundo");
        usuario.setApellido("Diaz");
        usuario.setEmail("facundo_dg10@hotmail.com");
        usuario.setTelefono("3232132");

        return usuario;
    }

    //----------------INGRESAR USUARIOS----------------------


    @RequestMapping(value = "api/usuarios", method = RequestMethod.GET) // esta anotacion indica la url para ingresar a esta funcion
    public List<Usuario> getUsuarios(){

        //estoy traeria un jason con todos los datos de nuestro usuario
        return usuarioDao.getUsuarios();

    }

    //----------------ELIMINAR USUARIOS----------------------

    @RequestMapping(value = "api/usuario/{id}", method = RequestMethod.DELETE)
    public void eliminar(@PathVariable Long id){

    usuarioDao.eliminar(id);

    }

    //----------------AGREGAR USUARIOS----------------------

    @RequestMapping(value = "api/usuarios", method = RequestMethod.POST) // esta anotacion indica la url para ingresar a esta funcion
    public void registrarUsuario(@RequestBody Usuario usuario){

        //@RequestBody = convierte el json a un usuario
        //estoy traeria un jason con todos los datos de nuestro usuario
         usuarioDao.registrar(usuario);

    }


}
