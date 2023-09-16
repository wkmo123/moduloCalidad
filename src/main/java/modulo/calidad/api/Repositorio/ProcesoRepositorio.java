package modulo.calidad.api.Repositorio;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import modulo.calidad.api.Entidad.Proceso;

public interface ProcesoRepositorio extends JpaRepository<Proceso,Long> {
     // to-do

     List<Proceso> findByModuloId(Long moduloId);
}
