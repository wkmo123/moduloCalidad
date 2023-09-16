package modulo.calidad.api.Servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import modulo.calidad.api.DTO.ProcesoRequest;
import modulo.calidad.api.Entidad.Modulos;
import modulo.calidad.api.Entidad.Proceso;
import modulo.calidad.api.Repositorio.ModuloRepositorio;
import modulo.calidad.api.Repositorio.ProcesoRepositorio;

@Service
public class ProcesoImpl implements ProcesoServicio {

    @Autowired
    private ProcesoRepositorio repositorio;

    @Autowired
    private ModuloRepositorio moduloRepositorio;



    // aqui creamos funcion insertarNuevo proceso la cual tiene dos requerimientos
    // llamados procesoRequest
    @Override
    public Proceso insertarNuevoProceso(ProcesoRequest procesoRequest) {
        Proceso proceso = new Proceso();
        proceso.setNombreProceso(procesoRequest.getNombreProceso());
        proceso.setFecha(procesoRequest.getFecha());

        Modulos modulos = moduloRepositorio.findById(procesoRequest.getModuloID())
                .orElseThrow(() -> new IllegalArgumentException("Modulo no encontrado"));

        proceso.setModulo(modulos);

        return repositorio.save(proceso);
    }

    // Creamos una funcion llamada editarProceso la cual requiere el id 
    @Override
    public Proceso editarNuevoProceso(Long id, ProcesoRequest procesoRequest) {
        Proceso procesoExistente = repositorio.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Proceso no encontrado"));

        procesoExistente.setNombreProceso(procesoRequest.getNombreProceso());
        procesoExistente.setFecha(procesoRequest.getFecha());

        Modulos modulos = moduloRepositorio.findById(procesoRequest.getModuloID())
                .orElseThrow(() -> new IllegalArgumentException("Modulo no encontrado"));

        procesoExistente.setModulo(modulos);

        return repositorio.save(procesoExistente);
    }

    @Override
    public void borrarProceso(Long id) {
        repositorio.deleteById(id);
    }

    @Override
    public List<Proceso> obtenerProcesos() {
        
        return repositorio.findAll();
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