package sena.backend.model;

import jakarta.persistence.*;
import lombok.*;

@Entity(name = "departments")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Departments {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "departmentsId")
    private Integer departmentsId;

    @Column(name = "departmentsName", nullable = false, length = 100)
    private String departmentsName;

    @Column(name = "daneCode", nullable = false)
    private Integer daneCode;
}
