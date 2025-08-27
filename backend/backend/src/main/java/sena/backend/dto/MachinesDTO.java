package sena.backend.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MachinesDTO {
    private String plate;
    private Integer typeMachineryId;
}
