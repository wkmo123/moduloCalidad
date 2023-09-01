package modulo.calidad.api.Servicio;

import modulo.calidad.api.DTO.ProcesoRequest;
import modulo.calidad.api.Entidad.Proceso;



public interface ProcesoServicio{


    
    //public DatosModulos guardar
   //Aqui estan la mayoria de metodos que vamos a usar
    public Proceso insertarNuevoProceso(ProcesoRequest procesoRequest);
    public Proceso obtenerProcesoPorId(Long id);
    public Proceso editarNuevoProceso(Long id,ProcesoRequest procesoRequest);

    public void borrarProceso(Long id);
    //public Proceso recuperaProceso(Long id);
 
}
