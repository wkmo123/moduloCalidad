package modulo.calidad.api.Controlador;

//import org.apache.catalina.connector.Response; 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;

import java.sql.Date;
import java.util.Comparator;
//import org.springframework.stereotype.Controller; 
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestController;

import modulo.calidad.api.DTO.ProcesoRequest;
import modulo.calidad.api.DTO.ResultadoRequest;
import modulo.calidad.api.Entidad.Causas;
import modulo.calidad.api.Entidad.Indicador;
import modulo.calidad.api.Entidad.Modulos;
import modulo.calidad.api.Entidad.Proceso;
import modulo.calidad.api.Repositorio.ProcesoRepositorio;
import modulo.calidad.api.Servicio.CausaServicio;
import modulo.calidad.api.Servicio.IndicadorServicio;
import modulo.calidad.api.Servicio.ModuloServicio;
import modulo.calidad.api.Servicio.ProcesoServicio;
import modulo.calidad.api.Servicio.ResultadoServicio;


// creamos la clase publica procesoController
public class ProcesoController {
  // Despues creamos una variable privada llamda ModuloServicio
  @Autowired
  private ProcesoServicio servicio;

  @Autowired
  private ResultadoServicio Rservicio;

  @Autowired
  private ModuloServicio Mservicio;

  @Autowired
  private ProcesoRepositorio repositorio;

  @Autowired
  private IndicadorServicio iServicio;

  @Autowired
  private CausaServicio Cservicio;

  // En esta parte va todo el crud del formulario

  // --------Apartado Para los metodos de proceso
  // metodo insertar
  @PostMapping("/insertar")
  public ResponseEntity<String> insertarProceso(@RequestBody ProcesoRequest procesoRequest) {
    Proceso proceso = servicio.insertarNuevoProceso(procesoRequest);
    return ResponseEntity.ok("Proceso insertado exitosamente con ID:" + proceso.getId());
  }

  // metodo editar
  @PutMapping("/editar/{id}")
  public ResponseEntity<Proceso> actualizarProceso(@PathVariable Long id, @RequestBody ProcesoRequest procesoRequest) {
    Proceso procesoActualizado = servicio.editarNuevoProceso(id, procesoRequest);
    if (procesoActualizado != null) {
      return ResponseEntity.ok(procesoActualizado);
    } else {
      return ResponseEntity.notFound().build();
    }
  }

  // metodo borrar
  @DeleteMapping("/borrar/{id}")
  public ResponseEntity<Void> borrarProceso(@PathVariable Long id) {
    servicio.borrarProceso(id);
    return ResponseEntity.noContent().build();

  }

  // metodo Resultados





}
