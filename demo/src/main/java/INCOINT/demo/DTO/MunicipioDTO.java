package INCOINT.demo.DTO;

import INCOINT.demo.model.Departamento;

public class MunicipioDTO {

    private Departamento departamentoId;
    private String municipioNombre;
    private int codigoDane;

    public MunicipioDTO(Departamento departamentoId, String municipioNombre, int codigoDane) {
        this.departamentoId = departamentoId;
        this.municipioNombre = municipioNombre;
        this.codigoDane = codigoDane;
    }

    public Departamento getDepartamentoId() {
        return departamentoId;
    }

    public void setDepartamentoId(Departamento departamentoId) {
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
