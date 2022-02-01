package proyecto2.example.proyecto2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//le indica al proyecto que usara el frameword de spring
@SpringBootApplication  //las anotaciones le indican en su mayoria una funcionalidad a lo que tienen abajo, se pueden usar para las funciones tambien
public class Proyecto2Application {

	public static void main(String[] args) {
		SpringApplication.run(Proyecto2Application.class, args);
	}

}
