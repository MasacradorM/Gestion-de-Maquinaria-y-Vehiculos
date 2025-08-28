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
    @Column(name = "typeMachineryId")
    private Integer typeMachineryId;

    @Column(name = "typeMachineryName", nullable = false, length = 100)
    private String typeMachineryName;
}
