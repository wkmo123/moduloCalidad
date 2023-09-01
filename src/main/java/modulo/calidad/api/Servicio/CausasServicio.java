package modulo.calidad.api.Servicio;

import modulo.calidad.api.DTO.CausasRequest;
import modulo.calidad.api.Entidad.Causas;

public interface CausasServicio {
    
    public Causas insertarNuevaCausa(CausasRequest causasRequest);
    public Causas obtenerCausaPorId(Long id);
    public Causas editarNuevaCausa(Long id,CausasRequest causasRequest);
    public void borrarCausa(Long id);

}
