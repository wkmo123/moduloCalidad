package modulo.calidad.api.Servicio;

import java.util.List;

import modulo.calidad.api.DTO.ProcesoRequest;
import modulo.calidad.api.Entidad.Proceso;

public interface ProcesoServicio {

    // public DatosModulos guardar
    // Aqui estan la mayoria de metodos que vamos a usar
    public Proceso insertarNuevoProceso(ProcesoRequest procesoRequest);

    public Proceso editarNuevoProceso(Long id, ProcesoRequest procesoRequest);

    public void borrarProceso(Long id);

     List<Proceso> obtenerProcesos();

    List<Proceso> obtenerProcesosporModuloId(Long moduloId);

}
