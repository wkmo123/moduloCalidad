package modulo.calidad.api.DTO;

import java.sql.Date;



public class ResultadoRequest {
    
    private String modulo;
    private String nombre_proceso;
    private Date fecha_creacion;
    private String indicador;
    private Boolean cumplimiento;
    private String causas;

    public ResultadoRequest(String modulo, String nombre_proceso, Date fecha_creacion, String indicador, Boolean cumplimiento, String causas) {
        this.modulo = modulo;
        this.nombre_proceso = nombre_proceso;
        this.fecha_creacion = fecha_creacion;
        this.indicador = indicador;
        this.cumplimiento = cumplimiento;
        this.causas = causas;
    }

    public ResultadoRequest()
    {
        
    }

    public String getModulo() {
        return this.modulo;
    }

    public void setModulo(String modulo) {
        this.modulo = modulo;
    }

    public String getNombre_proceso() {
        return this.nombre_proceso;
    }

    public void setNombre_proceso(String nombre_proceso) {
        this.nombre_proceso = nombre_proceso;
    }

    public Date getFecha_creacion() {
        return this.fecha_creacion;
    }

    public void setFecha_creacion(Date fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }

    public String getIndicador() {
        return this.indicador;
    }

    public void setIndicador(String indicador) {
        this.indicador = indicador;
    }

    public Boolean getCumplimiento() {
        return this.cumplimiento;
    }

    public void setCumplimiento(Boolean cumplimiento) {
        this.cumplimiento = cumplimiento;
    }

    public String getCausas() {
        return this.causas;
    }

    public void setCausas(String causas) {
        this.causas = causas;
    }

}
