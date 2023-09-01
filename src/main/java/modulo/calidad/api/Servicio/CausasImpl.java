package modulo.calidad.api.Servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import modulo.calidad.api.DTO.CausasRequest;
import modulo.calidad.api.Entidad.Causas;
import modulo.calidad.api.Entidad.Indicador;
import modulo.calidad.api.Repositorio.CausasRepositorio;
import modulo.calidad.api.Repositorio.IndicadorRepositorio;

@Service
public class CausasImpl implements CausasServicio{
    
    @Autowired
    private CausasRepositorio causasRepositorio;

    @Autowired
    private IndicadorRepositorio indicadorRepositorio;


    public Causas insertarNuevaCausa(CausasRequest causasRequest) {
        Causas causas = new Causas();
        causas.setNombreCausa(causasRequest.getNombreCausa());
    
        Indicador indicador = indicadorRepositorio.findById(causasRequest.getIndicadorID())
                .orElseThrow(() -> new IllegalArgumentException("Indicador no encontrado"));
    
        causas.setIndicador(indicador); // Cambiar 'indicador' a 'causas'
    
        return causasRepositorio.save(causas);
    }

    //--------------------------------
    @Override
    public Causas obtenerCausaPorId(Long id) {
        return causasRepositorio.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Causa no encontrada"));
    }
    //-------------------------------------

    // Creamos una funcion llamada editarProceso la cual requiere el id 
    @Override
    public Causas editarNuevaCausa(Long id, CausasRequest causasRequest) {
        Causas causaExistente = causasRepositorio.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Causa no encontrada"));

        causaExistente.setNombreCausa(causaExistente.getNombreCausa());
        

        Indicador indicador = indicadorRepositorio.findById(causasRequest.getIndicadorID())
                .orElseThrow(() -> new IllegalArgumentException("Indicador no encontrado"));

        causaExistente.setIndicador(indicador);

        return causasRepositorio.save(causaExistente);
    }

    @Override
    public void borrarCausa(Long id) {
        causasRepositorio.deleteById(id);
    }


}
