package modulo.calidad.api.Entidad;

import java.sql.Date;

//import jakarta.persistence.Column; tampoco es usada por el momento
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Proceso")
//creamos la clase publica que se llama Proceso
public class Proceso {
    //entonces hacemos los diferentes valores que contiene la clase
    @Id
    //la clase genera el valor la cual contiene la estrategia que genera el tipo de identidad que tiene el valor
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //luego hacemos una variable privada 
    private Long id;

    @ManyToOne
    @JoinColumn(name = "modulo_id")
    private Modulos modulo;

    private String nombreProceso;
    private Date fecha;

}
