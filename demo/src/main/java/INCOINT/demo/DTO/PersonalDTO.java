package INCOINT.demo.DTO;

import INCOINT.demo.model.Tipo;

public class PersonalDTO {

    private String personalNombre;
    private int identificacion;
    private Tipo tipo;

    public PersonalDTO(String personalNombre, int identificacion, Tipo tipo) {
        this.personalNombre = personalNombre;
        this.identificacion = identificacion;
        this.tipo = tipo;
    }

    public String getPersonalNombre() {
        return personalNombre;
    }

    public void setPersonalNombre(String personalNombre) {
        this.personalNombre = personalNombre;
    }

    public int getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(int identificacion) {
        this.identificacion = identificacion;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }
}

