package modulo.calidad.api.Servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import modulo.calidad.api.DTO.CausasRequest;
import modulo.calidad.api.DTO.ProcesoRequest;
import modulo.calidad.api.Entidad.Causas;
import modulo.calidad.api.Entidad.Indicador;
import modulo.calidad.api.Entidad.Modulos;
import modulo.calidad.api.Entidad.Proceso;
import modulo.calidad.api.Repositorio.CausasRepositorio;
import modulo.calidad.api.Repositorio.IndicadorRepositorio;
import modulo.calidad.api.Repositorio.ModuloRepositorio;
import modulo.calidad.api.Repositorio.ProcesoRepositorio;

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

    /*
     * @Override
     * public Proceso recuperaProceso(Long id) {
     * // Aqui se recuperaria el proceso correspondiente de la base de datos
     * repositorio.returnByID(id);
     * return proceso;
     * }
     */

}
