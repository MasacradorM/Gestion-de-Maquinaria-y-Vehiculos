package INCOINT.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;

@Entity(name="municipios")
public class Municipio {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="municipio_id")
    private int municipioId;

    @ManyToOne
    @JoinColumn(name="departamento_id", nullable = false)
    private Departamento departamento;

    @Column(name="municipio_nombre", length = 50, nullable = false)
    private String municipioNombre;

    @Column(name="codigo_dane", nullable = false)
    private int codigoDane;

    public Municipio() {}

    public Municipio(int municipioId, Departamento departamento, String municipioNombre, int codigoDane) {
        this.municipioId = municipioId;
        this.departamento = departamento;
        this.municipioNombre = municipioNombre;
        this.codigoDane = codigoDane;
    }

    public int getMunicipioId() {
        return municipioId;
    }

    public void setMunicipioId(int municipioId) {
        this.municipioId = municipioId;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
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
