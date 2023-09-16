package modulo.calidad.api.Servicio;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import modulo.calidad.api.DTO.ResultadoRequest;

@Service
public class ResultadoServicio {

    private final JdbcTemplate jdbcTemplate;

    public ResultadoServicio(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    
    public List<ResultadoRequest> obtenerResultados() {
        String sql = "SELECT m.modulo, p.nombre_proceso, p.fecha, i.indicador, i.cumplimiento, c.causas FROM modulos m "
                +
                "INNER JOIN proceso p ON m.id = p.modulo_id " +
                "INNER JOIN indicador i ON p.id = i.proceso_id " +
                "LEFT JOIN causas c ON i.id = c.indicador_id";
        List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);
        List<ResultadoRequest> resultados = new ArrayList<>();

        for (Map<String, Object> row : rows) {
            ResultadoRequest resultadoDTO = new ResultadoRequest();
            resultadoDTO.setModulo((String) row.get("modulo"));
            resultadoDTO.setNombre_proceso((String) row.get("nombre_proceso"));
            resultadoDTO.setFecha_creacion((java.sql.Date) row.get("fecha"));
            resultadoDTO.setIndicador((String) row.get("indicador"));
            resultadoDTO.setCumplimiento((Boolean) row.get("cumplimiento"));
            resultadoDTO.setCausas((String) row.get("causas"));
            resultados.add(resultadoDTO);
        }
        return resultados;
    }

}
