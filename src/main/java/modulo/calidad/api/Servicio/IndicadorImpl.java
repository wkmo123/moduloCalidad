package modulo.calidad.api.Servicio;

import java.util.List;
import java.util.Optional;

import org.hibernate.query.NativeQuery.ReturnProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import modulo.calidad.api.DTO.IndicadorRequest;
import modulo.calidad.api.Entidad.Indicador;
import modulo.calidad.api.Entidad.Proceso;
import modulo.calidad.api.Repositorio.IndicadorRepositorio;
import modulo.calidad.api.Repositorio.ProcesoRepositorio;

@Service
public class IndicadorImpl implements IndicadorServicio {

    @Autowired
    private IndicadorRepositorio repositorio;

    @Autowired
    private ProcesoRepositorio procesoRepositorio;

    @Override
    public Indicador insertarNuevoIndicador(IndicadorRequest indicadorRequest) {
        Indicador indicador = new Indicador();
        indicador.setIndicador(indicadorRequest.getIndicador());
        indicador.setCumplimiento(indicadorRequest.getCumplimiento());

        Proceso proceso = procesoRepositorio.findById(indicadorRequest.getProcesoId())
                .orElseThrow(() -> new IllegalArgumentException("Modulo no encontrado"));

        indicador.setProceso(proceso);

        return repositorio.save(indicador);
    }

    @Override
    public Indicador editarNuevoIndicador(Long id, IndicadorRequest indicadorRequest) {
        Indicador indicadoExitente = repositorio.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Indicador no encontrado"));

        indicadoExitente.setIndicador(indicadorRequest.getIndicador());
        indicadoExitente.setCumplimiento(indicadorRequest.getCumplimiento());

        Proceso proceso = procesoRepositorio.findById(indicadorRequest.getProcesoId())
                .orElseThrow(() -> new IllegalArgumentException("Modulo no encontrado"));

        indicadoExitente.setProceso(proceso);

        return repositorio.save(indicadoExitente);
    }

    @Override
    public void borrarIndicador(Long id) {
        repositorio.deleteById(id);
    }

    @Override
    public List<Indicador> obtenerIndicador() {
        
        return repositorio.findAll();
    }

    @Override
    public Indicador guardar(Indicador indicador) {
        
        return repositorio.save(indicador);
    }

    @Override
    public Indicador cargarPorId(Long id) {
        Optional<Indicador> indicadorOptional = repositorio.findById(id);
        if (indicadorOptional.isPresent()) {
            return indicadorOptional.get();
        } else {
            // Manejar el caso en el que no se encuentra el indicador con el ID dado
            // Puedes lanzar una excepción o tomar otra acción según tu lógica de negocio.
            return null; // O lanzar una excepción, dependiendo de tu caso de uso.
        }
    }

    @Override
    public List<Indicador> obtenerIndicadorporProcesoId(Long procesoId) {
       
        return repositorio.findByProcesoId(procesoId);
    }

}
