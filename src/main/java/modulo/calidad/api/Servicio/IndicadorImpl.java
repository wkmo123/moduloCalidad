package modulo.calidad.api.Servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import modulo.calidad.api.DTO.IndicadorRequest;
import modulo.calidad.api.Entidad.Causas;
import modulo.calidad.api.Entidad.Indicador;
import modulo.calidad.api.Entidad.Modulos;
import modulo.calidad.api.Entidad.Proceso;
import modulo.calidad.api.Repositorio.IndicadorRepositorio;
import modulo.calidad.api.Repositorio.ProcesoRepositorio;

@Service
public class IndicadorImpl implements IndicadorServicio{
    
    @Autowired
    private IndicadorRepositorio indicadorRepositorio;

    @Autowired
    private ProcesoRepositorio procesoRepositorio;

    @Override
    public Indicador insertarNuevoIndicador(IndicadorRequest indicadorRequest) {
        Indicador indicador = new Indicador();//No se si falten parametros
        indicador.setNombreIndicador(indicadorRequest.getNombreIndicador());
        //indicador.setCumplimiento(indicadorRequest.getCumplimiento());--> este es del boolean

        Proceso proceso = procesoRepositorio.findById(indicadorRequest.getProcesoID())
                .orElseThrow(() -> new IllegalArgumentException("Modulo no encontrado"));

        indicador.setProceso(proceso);

        return indicadorRepositorio.save(indicador);
    }

    //---------------------------------------------------------
    @Override
    public Indicador obtenerIndicadorPorId(Long id) {
        return indicadorRepositorio.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Indicador no encontrado"));
    }
    //----------------------------------------------------------


    @Override
    public Indicador editarNuevoIndicador(Long id, IndicadorRequest indicadorRequest) {
        Indicador indicadorExistente = indicadorRepositorio.findById(id)
        .orElseThrow(() -> new IllegalArgumentException("Indicador no encontrado"));

        indicadorExistente.setNombreIndicador(indicadorRequest.getNombreIndicador());

        Proceso proceso = procesoRepositorio.findById(indicadorRequest.getProcesoID())
                .orElseThrow(() -> new IllegalArgumentException("Proceso no encontrado"));

        indicadorExistente.setProceso(proceso);

        return indicadorRepositorio.save(indicadorExistente);
    }

    @Override
    public void borrarIndicador(Long id) {
        indicadorRepositorio.deleteById(id); 
    }

   
    
}
