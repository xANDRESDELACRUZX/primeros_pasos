package gm.zona_fit.modelo;

import jakarta.persistence.*;
import lombok.*;



@Entity
@Data // get y set
@NoArgsConstructor //constructor vacio
@AllArgsConstructor //constructor con  todos los argumentos
@ToString
@EqualsAndHashCode

public class Mebresia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombre;

}

