package INCOINT.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
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
}
