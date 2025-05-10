package INCOINT.demo.DTO;

public class DepartamentoDTO {

    private String departamentoNombre;
    private int codigoDane;

    public DepartamentoDTO(String departamentoNombre, int codigoDane) {
        this.departamentoNombre = departamentoNombre;
        this.codigoDane = codigoDane;
    }

    public String getDepartamentoNombre() {
        return departamentoNombre;
    }

    public void setDepartamentoNombre(String departamentoNombre) {
        this.departamentoNombre = departamentoNombre;
    }

    public int getCodigoDane() {
        return codigoDane;
    }

    public void setCodigoDane(int codigoDane) {
        this.codigoDane = codigoDane;
    }
}
