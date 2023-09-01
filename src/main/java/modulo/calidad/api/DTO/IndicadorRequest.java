package modulo.calidad.api.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class IndicadorRequest {

    private Long procesoID;
    private String nombreIndicador;

    private Boolean cumplimiento;
    
}
