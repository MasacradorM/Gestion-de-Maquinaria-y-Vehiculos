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
    @Column(name = "machineId", nullable = false)
    private Integer machineId;

    @Column(nullable = false, length = 50)
    private String plate;

    @ManyToOne
    @JoinColumn(name = "typeMachineryId", nullable = false)
    private TypeMachinery typeMachinery;

    @Column(name= "status",nullable = false)
    private Boolean status;
}
