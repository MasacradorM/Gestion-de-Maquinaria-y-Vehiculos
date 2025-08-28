package sena.backend.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "municipalities")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Municipalities {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "municipalitiesId")
    private Integer municipalitiesId;

    @Column(name = "municipalitiesName", nullable = false, length = 100)
    private String municipalitiesName;

    @Column(name = "daneCode", nullable = false)
    private Integer daneCode;

    @ManyToOne
    @JoinColumn(name = "departmentsId", nullable = false)
    private Departments department;
}
