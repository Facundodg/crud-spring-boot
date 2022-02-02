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
}
