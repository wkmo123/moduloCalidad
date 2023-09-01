package modulo.calidad.api.Controlador;

//import org.apache.catalina.connector.Response; 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.stereotype.Controller; 
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import modulo.calidad.api.DTO.CausasRequest;
import modulo.calidad.api.DTO.IndicadorRequest;
import modulo.calidad.api.DTO.ProcesoRequest;
import modulo.calidad.api.Entidad.Causas;
import modulo.calidad.api.Entidad.Indicador;
import modulo.calidad.api.Entidad.Proceso;
import modulo.calidad.api.Servicio.CausasServicio;
import modulo.calidad.api.Servicio.IndicadorServicio;
import modulo.calidad.api.Servicio.ProcesoServicio;

@RestController
// creamos la clase publica procesoController
public class ProcesoController {
  // Despues creamos una variable privada llamda ModuloServicio
  @Autowired
  private ProcesoServicio servicio;
  @Autowired
  private IndicadorServicio indicadorServicio;
  @Autowired
  private CausasServicio causasServicio;


  // En esta parte va todo el crud del formulario
  @GetMapping("/inicio")
  public String mostrarPaginaInicio() {
    return "inicio"; // Esto coincidirá con el nombre de tu archivo "inicio.html" en la carpeta
                     // "templates"
  }


  @PostMapping("/insertar/proceso")
  public ResponseEntity<String> insertarProceso(@RequestBody ProcesoRequest procesoRequest) {
    Proceso proceso = servicio.insertarNuevoProceso(procesoRequest);
    return ResponseEntity.ok("Proceso insertado exitosamente con ID:" + proceso.getId());
  }

  //Insertar Idicadores
   @PostMapping("/insertar/indicador")//Falta cambiarlo
  public ResponseEntity<String> insertarIndicador(@RequestBody IndicadorRequest indicadorRequest) {
    Indicador indicador = indicadorServicio.insertarNuevoIndicador(indicadorRequest);
    return ResponseEntity.ok("Indicador insertado exitosamente con ID:" + indicador.getId());
  }

  //Insertar Causas
   @PostMapping("/insertar/causas")//No se como cambiarlo
  public ResponseEntity<String> insertarCausas(@RequestBody CausasRequest causasRequest) {
    Causas causa = causasServicio.insertarNuevaCausa(causasRequest);
    return ResponseEntity.ok("Causa insertada exitosamente con ID:" + causa.getId());
  }

  @PutMapping("/editar/proceso/{id}")
  public ResponseEntity<Proceso> actualizarProceso(@PathVariable Long id, @RequestBody ProcesoRequest procesoRequest) {
    Proceso procesoActualizado = servicio.editarNuevoProceso(id, procesoRequest);
    if (procesoActualizado != null) {
      return ResponseEntity.ok(procesoActualizado);
    } else {
      return ResponseEntity.notFound().build();
    }
  } 
  //-------------------------
  //Get

  @GetMapping("/procesos/{id}")
  public ResponseEntity<String> obtenerProcesoPorId(@PathVariable Long id) {
      // Aquí debes implementar la lógica para obtener un proceso por su ID
      Proceso proceso = servicio.obtenerProcesoPorId(id);
      
      if (proceso != null) {
          return ResponseEntity.ok("Proceso encontrado con ID:" + proceso.getId() + ", Nombre: " + proceso.getNombreProceso());
      } else {
          return ResponseEntity.notFound().build();
      }
  }

  @GetMapping("/causas/{id}")
  public ResponseEntity<String> obtenerCausaPorId(@PathVariable Long id) {
      // Aquí debes implementar la lógica para obtener una causa por su ID
      Causas causa = causasServicio.obtenerCausaPorId(id);
      
      if (causa != null) {
          return ResponseEntity.ok("Causa encontrada con ID:" + causa.getId() + ", Descripción: " + causa.getNombreCausa());
      } else {
          return ResponseEntity.notFound().build();
      }
  }
  
//------------------------------------------------
  
  @GetMapping("/indicadores/{id}")
  public ResponseEntity<String> obtenerIndicadorPorId(@PathVariable Long id) {
      // Aquí debes implementar la lógica para obtener un indicador por su ID
      Indicador indicador = indicadorServicio.obtenerIndicadorPorId(id);
      
      if (indicador != null) {
          return ResponseEntity.ok("Indicador encontrado con ID:" + indicador.getId() + ", Nombre: " + indicador.getNombreIndicador());
      } else {
          return ResponseEntity.notFound().build();
      }
  }

  //Actualizar Indicadores  
  @PutMapping("/editar/indicador/{id}")//falta cambiarlo
  public ResponseEntity<Indicador> actualizarIndicador(@PathVariable Long id, @RequestBody IndicadorRequest indicadorRequest) {
    Indicador indicadorActualizado = indicadorServicio.editarNuevoIndicador(id, indicadorRequest);
    if (indicadorActualizado != null) {
      return ResponseEntity.ok(indicadorActualizado);
    } else {
      return ResponseEntity.notFound().build();
    }
  } 

  //Actualizar Causas
  @PutMapping("/editar/causa/{id}")//No se como cambiarlo
  public ResponseEntity<Causas> actualizarCausa(@PathVariable Long id, @RequestBody CausasRequest causasRequest) {
    Causas causaActualizada = causasServicio.editarNuevaCausa(id, causasRequest);
    if (causaActualizada != null) {
      return ResponseEntity.ok(causaActualizada);
    } else {
      return ResponseEntity.notFound().build();
    }
  } 

   @DeleteMapping("/borrar/proceso/{id}")
   public ResponseEntity<Void> borrarProceso(@PathVariable Long id) {
    servicio.borrarProceso(id);
    return ResponseEntity.noContent().build();

  }
  //Borrar Indicador
   @DeleteMapping("/borrar/indicador/{id}")
   public ResponseEntity<Void> borrarIndicador(@PathVariable Long id) {
    indicadorServicio.borrarIndicador(id);
    return ResponseEntity.noContent().build();

  }

  //Borrar Causas
  @DeleteMapping("/borrar/causa/{id}")//Queda pendiente este cambio
   public ResponseEntity<Void> borrarCausa(@PathVariable Long id) {
    causasServicio.borrarCausa(id);
    return ResponseEntity.noContent().build();

  }

  /*@GetMapping("/recuperar/{id}")
  public Proceso recuperarProceso(@PathVariable Long id) {
    return servicio.recuperarProceso(id);
  } */
  

}

