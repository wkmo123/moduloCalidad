package modulo.calidad.api.Controlador;

//import org.apache.catalina.connector.Response; 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.stereotype.Controller; 
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import modulo.calidad.api.DTO.ProcesoRequest;
import modulo.calidad.api.Entidad.Proceso;
import modulo.calidad.api.Servicio.ProcesoServicio;

@RestController
// creamos la clase publica procesoController
public class ProcesoController {
  // Despues creamos una variable privada llamda ModuloServicio
  @Autowired
  private ProcesoServicio servicio;


  // En esta parte va todo el crud del formulario
  @GetMapping("/inicio")
  public String mostrarPaginaInicio() {
    return "inicio"; // Esto coincidirá con el nombre de tu archivo "inicio.html" en la carpeta
                     // "templates"
  }

  @PostMapping("/insertar")
  public ResponseEntity<String> insertarProceso(@RequestBody ProcesoRequest procesoRequest) {
    Proceso proceso = servicio.insertarNuevoProceso(procesoRequest);
    return ResponseEntity.ok("Proceso insertado exitosamente con ID:" + proceso.getId());
  }

    @PutMapping("/editar/{id}")
  public ResponseEntity<Proceso> actualizarProceso(@PathVariable Long id, @RequestBody ProcesoRequest procesoRequest) {
    Proceso procesoActualizado = servicio.editarNuevoProceso(id, procesoRequest);
    if (procesoActualizado != null) {
      return ResponseEntity.ok(procesoActualizado);
    } else {
      return ResponseEntity.notFound().build();
    }
  } 

   @DeleteMapping("/borrar/{id}")
   public ResponseEntity<Void> borrarProceso(@PathVariable Long id) {
    servicio.borrarProceso(id);
    return ResponseEntity.noContent().build();

  }

  /*@GetMapping("/recuperar/{id}")
  public Proceso recuperarProceso(@PathVariable Long id) {
    return servicio.recuperarProceso(id);
  } */
  

}

