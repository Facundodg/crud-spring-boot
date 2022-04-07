package proyecto2.example.proyecto2.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity // indicandole que es una entidad que hace referencia a la base de datos
@Table(name = "usuarios") //con esta linea sabe que tiene que ir a esa tabla
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter @Column(name = "id")
    private Long id;
    @Getter @Setter @Column(name = "nombre")
    private String nombre;
    @Getter @Setter @Column(name = "apellido")
    private String apellido;
    @Getter @Setter @Column(name = "email")
    private String email;
    @Getter @Setter @Column(name = "telefono")
    private String telefono;
    @Getter @Setter @Column(name = "password")
    private String password;

}
