package modulo.calidad.api.DTO;

public class CausaRequest {

    private Long indicadorID;
    private String nombreCausa;

    public CausaRequest() {

    }

    public CausaRequest(Long indicadorID, String nombreCausa) {
        this.indicadorID = indicadorID;
        this.nombreCausa = nombreCausa;
    }

    public Long getIndicadorID() {
        return this.indicadorID;
    }

    public void setIndicadorID(Long indicadorID) {
        this.indicadorID = indicadorID;
    }

    public String getNombreCausa() {
        return this.nombreCausa;
    }

    public void setNombreCausa(String nombreCausa) {
        this.nombreCausa = nombreCausa;
    }

}
