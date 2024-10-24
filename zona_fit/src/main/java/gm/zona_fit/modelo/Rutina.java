package gm.zona_fit.modelo;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data // get y set
@NoArgsConstructor //constructor vacio
@AllArgsConstructor //constructor con  todos los argumentos
@ToString
@EqualsAndHashCode

public class Rutina {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombre;
    private Integer dia_semana;
    private Integer cliente_id;
    private Integer ejercicio_id;
    /*@Type(type = "json")
    @Column(columnDefinition = "ejercicios")
    private Map<String, Object> ejercicios;*/
}

