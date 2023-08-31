package modulo.calidad.api.Entidad;

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
@Table(name = "Indicador")
public class Indicador {
    @Id
    // la clase genera el valor la cual contiene la estrategia que genera el tipo de
    // identidad que tiene el valor
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // luego hacemos una variable privada
    private Long id;

    @ManyToOne
    @JoinColumn(name = "proceso_id")
    private Proceso proceso;

    private Boolean cumplimiento;

}
