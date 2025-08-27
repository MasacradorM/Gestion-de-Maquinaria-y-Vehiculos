package sena.backend.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MunicipalitiesDTO {
    private String municipalitiesName;
    private Integer daneCode;
    private Integer departmentsId; // Se maneja como ID para simplificar la conversión
}
