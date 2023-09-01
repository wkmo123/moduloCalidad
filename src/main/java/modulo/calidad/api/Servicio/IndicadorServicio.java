package modulo.calidad.api.Servicio;

import modulo.calidad.api.DTO.IndicadorRequest;
import modulo.calidad.api.Entidad.Indicador;


public interface IndicadorServicio {
    
    public Indicador insertarNuevoIndicador(IndicadorRequest indicadorRequest);
    public Indicador obtenerIndicadorPorId(Long id);
    public Indicador editarNuevoIndicador(Long id,IndicadorRequest indicadorRequest);
    public void borrarIndicador(Long id);

}
