package INCOINT.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.JoinColumn;
@Data
@AllArgsConstructor
@NoArgsConstructor
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

}
