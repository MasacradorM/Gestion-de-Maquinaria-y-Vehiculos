package sena.backend.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "machines")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Machines {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "machine_id")
    private Integer machineId;

    @Column(nullable = false, length = 50)
    private String plate;

    @ManyToOne
    @JoinColumn(name = "type_machinery_id", nullable = false)
    private TypeMachinery typeMachinery;

    @Column(nullable = false)
    private Boolean status;
}
