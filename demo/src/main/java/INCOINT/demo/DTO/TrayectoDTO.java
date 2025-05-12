package INCOINT.demo.DTO;

import INCOINT.demo.model.Municipio;

public class TrayectoDTO {

    private String trayectoNombre;
    private Municipio municipioOrigenId;
    private Municipio municipioDestinoId;

    public TrayectoDTO(String trayectoNombre, Municipio municipioOrigenId, Municipio municipioDestinoId) {
        this.trayectoNombre = trayectoNombre;
        this.municipioOrigenId = municipioOrigenId;
        this.municipioDestinoId = municipioDestinoId;
    }

    public String getTrayectoNombre() {
        return trayectoNombre;
    }

    public void setTrayectoNombre(String trayectoNombre) {
        this.trayectoNombre = trayectoNombre;
    }

    public Municipio getMunicipioOrigenId() {
        return municipioOrigenId;
    }

    public void setMunicipioOrigenId(Municipio municipioOrigenId) {
        this.municipioOrigenId = municipioOrigenId;
    }

    public Municipio getMunicipioDestinoId() {
        return municipioDestinoId;
    }

    public void setMunicipioDestinoId(Municipio municipioDestinoId) {
        this.municipioDestinoId = municipioDestinoId;
    }
}
