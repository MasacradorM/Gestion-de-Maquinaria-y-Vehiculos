package INCOINT.demo.DTO;

public class TrayectoDTO {

    private String trayectoNombre;
    private int municipioOrigenId;
    private Integer municipioDestinoId;

    public TrayectoDTO(String trayectoNombre, int municipioOrigenId, Integer municipioDestinoId) {
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

    public int getMunicipioOrigenId() {
        return municipioOrigenId;
    }

    public void setMunicipioOrigenId(int municipioOrigenId) {
        this.municipioOrigenId = municipioOrigenId;
    }

    public Integer getMunicipioDestinoId() {
        return municipioDestinoId;
    }

    public void setMunicipioDestinoId(Integer municipioDestinoId) {
        this.municipioDestinoId = municipioDestinoId;
    }
}
