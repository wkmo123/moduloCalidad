package modulo.calidad.api.Controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import modulo.calidad.api.DTO.CausaRequest;
import modulo.calidad.api.Entidad.Causas;
import modulo.calidad.api.Servicio.CausaServicio;

@RestController
public class CausasController {

    @Autowired
    private CausaServicio causaServicio;

    // --------Apartado Para
    // causas---------------------------------------------------------
    @PostMapping("/insertarCausa") // No se como cambiarlo
    public ResponseEntity<String> insertarCausas(@RequestBody CausaRequest causasRequest) {
        Causas causa = causaServicio.insertarNuevaCausa(causasRequest);
        return ResponseEntity.ok("Causa insertada exitosamente con ID:" + causa.getId());
    }

    // Actualizar Causas
    @PutMapping("/editarCausa/{id}") // No se como cambiarlo
    public ResponseEntity<Causas> actualizarCausa(@PathVariable Long id, @RequestBody CausaRequest causasRequest) {
        Causas causaActualizada = causaServicio.editarNuevaCausa(id, causasRequest);
        if (causaActualizada != null) {
            return ResponseEntity.ok(causaActualizada);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/borrarCausa/{id}")
    public ResponseEntity<Void> borrarCausa(@PathVariable Long id) {
        causaServicio.borrarCausa(id);
        return ResponseEntity.noContent().build();

    }

}
