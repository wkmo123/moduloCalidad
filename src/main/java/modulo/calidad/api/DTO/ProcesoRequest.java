package modulo.calidad.api.DTO;

import java.sql.Date;


//aqui se crea la clase publica procesoRequest 
public class ProcesoRequest {
    // se inicializan las variables privadas
    private Long moduloID;
    private String nombreProceso;
    private Date fecha;

    // Constructor

    public ProcesoRequest() {

    }

    public ProcesoRequest(Long moduloID, String nombreProceso, Date fecha) {
        this.moduloID = moduloID;
        this.nombreProceso = nombreProceso;
        this.fecha = fecha;
    }

    // Getter y Setter para moduloID
    public Long getModuloID() {
        return moduloID;
    }

    public void setModuloID(Long moduloID) {
        this.moduloID = moduloID;
    }

    // Getter y Setter para nombreProceso
    public String getNombreProceso() {
        return nombreProceso;
    }

    public void setNombreProceso(String nombreProceso) {
        this.nombreProceso = nombreProceso;
    }

    // Getter y Setter para fecha
    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

}
