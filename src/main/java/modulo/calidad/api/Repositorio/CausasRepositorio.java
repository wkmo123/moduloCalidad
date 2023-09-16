package modulo.calidad.api.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import modulo.calidad.api.Entidad.Causas;

public interface CausasRepositorio  extends JpaRepository<Causas,Long>{
    
}
