package modulo.calidad.api.Controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import modulo.calidad.api.DTO.IndicadorRequest;
import modulo.calidad.api.Entidad.Indicador;
import modulo.calidad.api.Servicio.IndicadorServicio;

@RestController
public class IndicadorController {

    @Autowired
    private IndicadorServicio servicioIndicador;

    // --------Apartado Para
    // Indicador---------------------------------------------------------
    @PostMapping("/insertarIndicador")
    public ResponseEntity<String> insertarIndicador(@RequestBody IndicadorRequest indicadorRequest) {
        Indicador indicador = servicioIndicador.insertarNuevoIndicador(indicadorRequest);
        return ResponseEntity.ok("Indicador insertado exitosamente con ID:" + indicador.getId());
    }

    @PutMapping("/editarIndicador/{id}")
    public ResponseEntity<Indicador> actualizarIndicador(@PathVariable Long id,
            @RequestBody IndicadorRequest indicadorRequest) {
        Indicador indicadorActualizado = servicioIndicador.editarNuevoIndicador(id, indicadorRequest);
        if (indicadorActualizado != null) {
            return ResponseEntity.ok(indicadorActualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/borrarIndicador/{id}")
    public ResponseEntity<Void> borrarIndicador(@PathVariable Long id) {
        servicioIndicador.borrarIndicador(id);
        return ResponseEntity.noContent().build();

    }
}
