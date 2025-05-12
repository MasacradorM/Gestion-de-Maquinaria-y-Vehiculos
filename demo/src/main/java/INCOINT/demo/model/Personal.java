package INCOINT.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name="personal")
public class Personal {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="personal_id")
    private int personalId;

    @Column(name="personal_nombre", length = 50, nullable = false)
    private String personalNombre;

    @Column(name="identificacion", nullable = false)
    private int identificacion;

    @Column(name="tipo", nullable = false)
    private Tipo tipo;

    public Personal() {}

    public Personal(int personalId, String personalNombre, int identificacion, Tipo tipo) {
        this.personalId = personalId;
        this.personalNombre = personalNombre;
        this.identificacion = identificacion;
        this.tipo = tipo;
    }

    public int getPersonalId() {
        return personalId;
    }

    public void setPersonalId(int personalId) {
        this.personalId = personalId;
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
