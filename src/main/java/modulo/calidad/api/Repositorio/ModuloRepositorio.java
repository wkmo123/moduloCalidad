package modulo.calidad.api.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import modulo.calidad.api.Entidad.Modulos;

public interface ModuloRepositorio  extends JpaRepository<Modulos,Long>{
    
}
