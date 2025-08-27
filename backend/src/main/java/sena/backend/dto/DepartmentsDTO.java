package sena.backend.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DepartmentsDTO {
    private String departmentsName;
    private Integer daneCode;
}