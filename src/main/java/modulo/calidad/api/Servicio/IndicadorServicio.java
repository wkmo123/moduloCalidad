package modulo.calidad.api.Servicio;

import java.util.List;

import modulo.calidad.api.DTO.IndicadorRequest;
import modulo.calidad.api.Entidad.Indicador;

public interface IndicadorServicio {


    public Indicador insertarNuevoIndicador(IndicadorRequest indicadorRequest);

    public Indicador editarNuevoIndicador(Long id, IndicadorRequest indicadorRequest);

    public void borrarIndicador(Long id);

    List<Indicador>obtenerIndicador();
    
    public Indicador guardar(Indicador indicador);

    public Indicador cargarPorId(Long id);
}
