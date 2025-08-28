package sena.backend.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "vehicle")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vehicleId", nullable = false)
    private int vehicleId;

    @Column(name = "vehicleName", nullable = false, length = 100)
    private String vehicleName;

    @ManyToOne
    @JoinColumn(name = "vehicleTypeId", nullable = false)
    private VehicleType vehicleTypeId;

    @Column(name = "status", nullable = false)
    private Boolean status;
}
