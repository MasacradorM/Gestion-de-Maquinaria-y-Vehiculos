package sena.backend.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "type_machinery")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TypeMachinery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "type_machinery_id")
    private Integer typeMachineryId;

    @Column(name = "type_machinery_name", nullable = false, length = 100)
    private String typeMachineryName;
}
