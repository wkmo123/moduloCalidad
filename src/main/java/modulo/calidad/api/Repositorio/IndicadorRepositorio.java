package modulo.calidad.api.Repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import modulo.calidad.api.Entidad.Indicador;

public interface IndicadorRepositorio extends JpaRepository<Indicador,Long> {
    
    List<Indicador> findByProcesoId(Long indicadorId);
}
