package modulo.calidad.api.DTO;


public class IndicadorRequest {

    private Long procesoId;
    private String indicador;
    private Boolean cumplimiento;


    public IndicadorRequest(){

    }

     public IndicadorRequest(Long procesoId, String indicador, Boolean cumplimiento) {
        this.procesoId = procesoId;
        this.indicador = indicador;
        this.cumplimiento = cumplimiento;
    }


    public Long getProcesoId() {
        return this.procesoId;
    }

    public void setProcesoId(Long procesoId) {
        this.procesoId = procesoId;
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


}
