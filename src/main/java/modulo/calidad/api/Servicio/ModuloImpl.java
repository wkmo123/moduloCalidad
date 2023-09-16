package modulo.calidad.api.Servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import modulo.calidad.api.Entidad.Modulos;
import modulo.calidad.api.Repositorio.ModuloRepositorio;

@Service
public class ModuloImpl implements ModuloServicio {

    @Autowired
    private ModuloRepositorio repositorio;

    @Override
    public List<Modulos> obtenerModulo() {
        
        return repositorio.findAll();
    }
    
}
