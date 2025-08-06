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
import java.time.LocalDateTime;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name="maquinas")
public class Maquina {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="maquina_id")
    private int maquinaId;

    @ManyToOne
    @JoinColumn(name="tipo_maquinaria_id", nullable = false)
    private TipoMaquinaria tipoMaquinaria;

    @Column(name="maquina", length = 30, nullable = false)
    private String maquina;

    @Column(name="fecha_registro", nullable = false)
    private LocalDateTime fechaRegistro;

    @Column(name="estatus", nullable = false)
    private boolean estatus;
}
