package INCOINT.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name="departamentos")
public class Departamento {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="departamento_id")
    private int departamentoId;

    @Column(name="departamento_nombre", length = 50, nullable = false)
    private String departamentoNombre;

    @Column(name="codigo_dane", nullable = false)
    private int codigoDane;

    public Departamento() {}

    public Departamento(int departamentoId, String departamentoNombre, int codigoDane) {
        this.departamentoId = departamentoId;
        this.departamentoNombre = departamentoNombre;
        this.codigoDane = codigoDane;
    }

    public int getDepartamentoId() {
        return departamentoId;
    }

    public void setDepartamentoId(int departamentoId) {
        this.departamentoId = departamentoId;
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
