package proyecto2.example.proyecto2.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import proyecto2.example.proyecto2.models.Usuario;

import java.util.ArrayList;
import java.util.List;

@RestController // esta anotacion le indicamos que esta clase va a ser un controlador
public class UsuarioController {

    @RequestMapping(value = "usuario/{id}") // esta anotacion indica la url para ingresar a esta funcion
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

    @RequestMapping(value = "usuarios") // esta anotacion indica la url para ingresar a esta funcion
    public List<Usuario> getUsuarios(){

        //estoy traeria un jason con todos los datos de nuestro usuario

        List<Usuario> usu = new ArrayList<>();

        Usuario usuario = new Usuario();

        usuario.setId(12L);
        usuario.setNombre("Facundo");
        usuario.setApellido("Diaz");
        usuario.setEmail("facundo_dg10@hotmail.com");
        usuario.setTelefono("3232132");

        Usuario usuario2 = new Usuario();

        usuario2.setId(13L);
        usuario2.setNombre("Mariela");
        usuario2.setApellido("Bertinati");
        usuario2.setEmail("Mar_123@hotmail.com");
        usuario2.setTelefono("312321");

        Usuario usuario3 = new Usuario();

        usuario3.setId(14L);
        usuario3.setNombre("Diego");
        usuario3.setApellido("Ruiz");
        usuario3.setEmail("D_Ruiz10@hotmail.com");
        usuario3.setTelefono("4352332");

        usu.add(usuario);
        usu.add(usuario2);
        usu.add(usuario3);

        return usu;
    }



}
