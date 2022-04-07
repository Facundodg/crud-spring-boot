package proyecto2.example.proyecto2.dao;

import proyecto2.example.proyecto2.models.Usuario;

import java.util.List;

public interface UsuarioDao {

    List<Usuario> getUsuarios();

    void eliminar(Long id);

    void registrar(Usuario usuario);

    boolean verificarCredenciales(Usuario usuario);
}
