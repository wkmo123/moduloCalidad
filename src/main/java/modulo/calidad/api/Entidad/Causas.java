package modulo.calidad.api.Entidad;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "Causas")
public class Causas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String causas;

    
    @ManyToOne
    @JoinColumn(name = "indicador_id")
    private Indicador indicador;

    public Causas(String causas) {
        this.causas = causas;
    }

    public Causas(String causas, Indicador indicador) {
        this.causas = causas;
        this.indicador = indicador;
    }

    public Causas(List<String> causas2) {
        this.causas = String.join(", ", causas2);
    }

   

}

