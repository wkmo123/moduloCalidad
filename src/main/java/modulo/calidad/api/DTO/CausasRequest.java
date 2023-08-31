package modulo.calidad.api.DTO;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CausasRequest {

    private Long indicadorID;
    private String nombreCausa;


    
}
