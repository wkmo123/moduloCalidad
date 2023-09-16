package modulo.calidad.api.Controlador;

import modulo.calidad.api.DTO.ResultadoRequest;
import modulo.calidad.api.Entidad.Causas;
import modulo.calidad.api.Entidad.Indicador;
import modulo.calidad.api.Entidad.Modulos;
import modulo.calidad.api.Entidad.Proceso;
import modulo.calidad.api.Repositorio.ProcesoRepositorio;
import modulo.calidad.api.Servicio.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Controller
public class FormularioController {
    @Autowired
    private ProcesoServicio procesoServicio;
    @Autowired
    private ResultadoServicio resultadoServicio;
    @Autowired
    private ModuloServicio moduloServicio;
    @Autowired
    private ProcesoRepositorio procesoRepositorio;
    @Autowired
    private IndicadorServicio indicadorServicio;
    @Autowired
    private CausaServicio causaServicio;

    @GetMapping("/")
    public String mostrarPaginaInicio() {
        return "inicio"; // Esto coincidira con el nombre de tu archivo "inicio.html" en la carpeta
        // "templates"
    }

    // ----------------------------------------------------------------
    // Plantilla
    @RequestMapping("/plantilla")
    public String mostrarPlantilla(Model model) {
        List<Modulos> listaModulos = moduloServicio.obtenerModulo();
        List<Causas> listaCausas = causaServicio.obtenerCausas();
        List<Indicador> listaIndicadores = indicadorServicio.obtenerIndicador();
        List<Proceso> listaProcesos = procesoServicio.obtenerProcesos();
        model.addAttribute("procesos", listaProcesos);
        model.addAttribute("modulos", listaModulos);
        model.addAttribute("causas", listaCausas);
        model.addAttribute("indicadores", listaIndicadores);
        model.addAttribute("mostrarformulario1", true);
        model.addAttribute("mostrarformulario2", false);

        // model.addAttribute("proceso", proceso);
        return "plantilla";
    }

    @RequestMapping("/plantilla2")
    public String mostrarPlantilla2(Model model) {
        List<Proceso> listaProcesos = procesoServicio.obtenerProcesos();
        model.addAttribute("procesos", listaProcesos);
        return "plantilla2";
    }

    @PostMapping("/guardar")
    public String guardarDatosPlantilla(
            Model model,
            @RequestParam String nombre_proceso,
            @RequestParam Date fecha,
            @RequestParam Modulos moduloId) {

        Proceso proceso = new Proceso(nombre_proceso, fecha, moduloId);
        procesoRepositorio.save(proceso);

        model.addAttribute("mostrarplantilla2", true);
        model.addAttribute("mostrarplantilla1", true);
        List<Proceso> listaProcesos = procesoServicio.obtenerProcesos();

        if (!listaProcesos.isEmpty()) {

            Proceso ultimoProceso = listaProcesos.get(listaProcesos.size() - 1);
            model.addAttribute("procesos", ultimoProceso);
        }

        
return "plantilla2";
    }

    @PostMapping("/guardar2")
    public String guardarDatosPlantilla2(
            @RequestParam String indicador,
            @RequestParam List<String> causas,
            @RequestParam Proceso procesoId,
            Model model) {

        Indicador indicador2 = new Indicador(indicador, procesoId);
        indicadorServicio.guardar(indicador2);

        Long indicadorId = indicador2.getId();

        Indicador indicador3 = indicadorServicio.cargarPorId(indicadorId);

        List<Causas> causasGuardadas = new ArrayList<>();
        for (String causa : causas) {
            Causas causas2 = new Causas(causa);
            causas2.setIndicador(indicador3);
            causasGuardadas.add(causas2);
        }
        causaServicio.guardarCausas(causasGuardadas);

        return "plantilla";
    }

    // ----------------------------------------------------------------
    // Formulario
    @PostMapping("/guardarForm")
    public String guardarDatosFormulario(
            Modulos modulos,
            @RequestParam Proceso proceso,
            @RequestParam Indicador indicador,
            @RequestParam(defaultValue = "false") Boolean cumplimiento,
            @RequestParam Causas causas,
            Model model) {

        return "formulario";
    }

    // ----------------------------------------------------------------
    // Resultados
    @GetMapping("/resultados")
    public String mostrarDatos(Model model) {
        List<ResultadoRequest> resultados = resultadoServicio.obtenerResultados();
        model.addAttribute("resultados", resultados);
        return "resultados";

    }
    //-------------------------------------------
    //Formulario
    @RequestMapping("/formulario")
    public String mostrarFormulario(Model model) {
        List<Modulos> listaModulos = moduloServicio.obtenerModulo();
        List<Causas> listaCausas = causaServicio.obtenerCausas();
        List<Indicador> listaIndicadores = indicadorServicio.obtenerIndicador();
        List<Proceso> listaProcesos = procesoServicio.obtenerProcesos();
        model.addAttribute("procesos", listaProcesos);
        model.addAttribute("modulos", listaModulos);
        model.addAttribute("causas", listaCausas);
        model.addAttribute("indicadores", listaIndicadores);
    

        // model.addAttribute("proceso", proceso);
        return "formulario";
    }

}
