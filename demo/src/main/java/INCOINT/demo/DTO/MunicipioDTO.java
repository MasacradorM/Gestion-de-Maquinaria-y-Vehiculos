package INCOINT.demo.DTO;

public class MunicipioDTO {

    private int departamentoId;
    private String municipioNombre;
    private int codigoDane;

    public MunicipioDTO(int departamentoId, String municipioNombre, int codigoDane) {
        this.departamentoId = departamentoId;
        this.municipioNombre = municipioNombre;
        this.codigoDane = codigoDane;
    }

    public int getDepartamentoId() {
        return departamentoId;
    }

    public void setDepartamentoId(int departamentoId) {
        this.departamentoId = departamentoId;
    }

    public String getMunicipioNombre() {
        return municipioNombre;
    }

    public void setMunicipioNombre(String municipioNombre) {
        this.municipioNombre = municipioNombre;
    }

    public int getCodigoDane() {
        return codigoDane;
    }

    public void setCodigoDane(int codigoDane) {
        this.codigoDane = codigoDane;
    }
}
