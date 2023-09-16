package modulo.calidad.api.Servicio;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import modulo.calidad.api.DTO.CausaRequest;
import modulo.calidad.api.Entidad.Causas;
import modulo.calidad.api.Entidad.Indicador;
import modulo.calidad.api.Repositorio.CausasRepositorio;
import modulo.calidad.api.Repositorio.IndicadorRepositorio;

@Service
public class CausaImpl implements CausaServicio {
    @Autowired
    private CausasRepositorio causasRepositorio;

    @Autowired
    private IndicadorRepositorio indicadorRepositorio;

    @Override
    public Causas insertarNuevaCausa(CausaRequest causasRequest) {
        Causas causas = new Causas();
        causas.setCausas(causasRequest.getNombreCausa());

        Indicador indicador = indicadorRepositorio.findById(causasRequest.getIndicadorID())
                .orElseThrow(() -> new IllegalArgumentException("Indicador no encontrado"));

        causas.setIndicador(indicador); // Cambiar 'indicador' a 'causas'

        return causasRepositorio.save(causas);
    }

    @Override
    public Causas editarNuevaCausa(Long id, CausaRequest causasRequest) {
        Causas causaExistente = causasRepositorio.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Causa no encontrada"));

        causaExistente.setCausas(causaExistente.getCausas());

        Indicador indicador = indicadorRepositorio.findById(causasRequest.getIndicadorID())
                .orElseThrow(() -> new IllegalArgumentException("Indicador no encontrado"));

        causaExistente.setIndicador(indicador);

        return causasRepositorio.save(causaExistente);
    }

    @Override
    public void borrarCausa(Long id) {
        causasRepositorio.deleteById(id);
    }

    @Override
    public List<Causas> obtenerCausas() {
        return causasRepositorio.findAll();
    }

    /*
    @Override
    public List<Causas> guardarCausas(List<Causas> causasList) {
        List<Causas> causasGuardadas = new ArrayList<>();

        for (Causas causa : causasList) {
            Causas causaGuardada = causasRepositorio.save(causa);
            causasGuardadas.add(causaGuardada);
        }

        return causasGuardadas;
    }
    */
    @Override
    public List<Causas> guardarCausas(List<Causas> causas) {

        return causasRepositorio.saveAll(causas);
    }





}
