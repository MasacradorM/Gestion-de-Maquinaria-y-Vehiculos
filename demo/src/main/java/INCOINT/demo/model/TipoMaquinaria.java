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
@Entity(name="tipo_maquinaria")
public class TipoMaquinaria {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="tipo_maquinaria_id")
    private int tipoMaquinariaId;

    @Column(name="tipo_maquinaria", length = 40, nullable = false)
    private String tipoMaquinaria;

}
