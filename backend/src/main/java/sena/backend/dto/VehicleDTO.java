package sena.backend.dto;

import lombok.*;
import sena.backend.model.VehicleType;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class VehicleDTO {
    private String vehicleName;
    private VehicleType vehicleTypeId;
}
