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
    @Column(name = "departments_id")
    private Integer departmentsId;

    @Column(name = "departments_name", nullable = false, length = 100)
    private String departmentsName;

    @Column(name = "dane_code", nullable = false)
    private Integer daneCode;
}
