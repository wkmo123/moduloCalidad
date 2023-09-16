package modulo.calidad.api.Servicio;

import java.util.List;

import modulo.calidad.api.DTO.CausaRequest;
import modulo.calidad.api.Entidad.Causas;
import modulo.calidad.api.Entidad.Modulos;

public interface CausaServicio {
    public Causas insertarNuevaCausa(CausaRequest causasRequest);

    public Causas editarNuevaCausa(Long id, CausaRequest causasRequest);

    public void borrarCausa(Long id);

    List<Causas> obtenerCausas();

    public  List<Causas> guardarCausas(List<Causas> causas);

}
