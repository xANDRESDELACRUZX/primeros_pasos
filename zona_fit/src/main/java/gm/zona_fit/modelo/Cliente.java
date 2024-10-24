package gm.zona_fit.modelo;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "clientes") // Especifica el nombre de la tabla
@Data // get y set
@NoArgsConstructor //constructor vacio
@AllArgsConstructor //constructor con  todos los argumentos
@ToString
@EqualsAndHashCode
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombre;
    private String apellido;
    private Integer membresia_id;

}
