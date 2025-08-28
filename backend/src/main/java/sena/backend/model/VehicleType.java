package sena.backend.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "vehicle_type")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VehicleType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vehicleTypeId", nullable = false)
    private Integer vehicleTypeId;

    @Column(name = "vehicleTypeName", nullable = false, length = 100)
    private String vehicleTypeName;
}
