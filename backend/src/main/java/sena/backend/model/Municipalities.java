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
    @Column(name = "municipalities_id")
    private Integer municipalitiesId;

    @Column(name = "municipalities_name", nullable = false, length = 100)
    private String municipalitiesName;

    @Column(name = "dane_code", nullable = false)
    private Integer daneCode;

    // Relación con Departments
    @ManyToOne
    @JoinColumn(name = "departments_id", nullable = false)
    private Departments department;
}
