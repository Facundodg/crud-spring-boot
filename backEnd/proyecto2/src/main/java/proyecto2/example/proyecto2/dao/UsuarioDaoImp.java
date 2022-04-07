package proyecto2.example.proyecto2.dao;

import org.springframework.stereotype.Repository;
import proyecto2.example.proyecto2.models.Usuario;

import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional //le permite armar las consultas sql
public class UsuarioDaoImp implements UsuarioDao{

    //CON ESTE METODO HACEMOS LA CONSULTA A LA BASE DE DATOS
    @PersistenceContext
    private EntityManager emtityManager; //nos sirve para hacer la conecxion con la base de datos

    @Override
    @Transactional
    public List<Usuario> getUsuarios() {
        String query = "FROM Usuario"; //VA EL NOMBRE DE LA CLASE NO DE LA TABLA
        return emtityManager.createQuery(query).getResultList();
    }

    @Override
    public void eliminar(Long id) {

        Usuario usuario = emtityManager.find(Usuario.class, id); //buscamos el usuario y luego lo eliminamos
        emtityManager.remove(usuario);

    }

    @Override
    public void registrar(Usuario usuario) {

        emtityManager.merge(usuario);

    }

    //CONSULATA PARA VER SI EL MAIL Y PASSWORD SON CORRECTOS Y TAMBIEN EVITANDO UNA INYECCION DE CODIGO HTML

    public boolean verificarCredenciales(Usuario usuario){

        String query = "FROM Usuario WHERE email = :email AND password = :password"; //VA EL NOMBRE DE LA CLASE NO DE LA TABLA
        List<Usuario> lista = emtityManager.createQuery(query).setParameter("email", usuario.getEmail())
                .setParameter("password",usuario.getPassword())
                .getResultList(); // si encuentra un usuario que cumpla con el email y contraseña la query
        //traera una fila lo que significa que se llenara con el usuario.

        return !lista.isEmpty(); //si la lista NO esta basia es por que el usuario y contraseña son correctos

    }
}
