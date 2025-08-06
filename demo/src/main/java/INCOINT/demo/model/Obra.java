package INCOINT.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name="obra")
public class Obra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="obra_id")
    private int obraId;

    @Column(name="obra", length = 100, nullable = false)
    private String obra;

    public Obra() {}

    public Obra(int obraId, String obra) {
        this.obraId = obraId;
        this.obra = obra;
    }

    public int getObraId() {
        return obraId;
    }

    public void setObraId(int obraId) {
        this.obraId = obraId;
    }

    public String getObra() {
        return obra;
    }

    public void setObra(String obra) {
        this.obra = obra;
    }
}
