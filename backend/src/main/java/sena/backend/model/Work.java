package sena.backend.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "works")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Work {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer workId;

    @Column(nullable = false, unique = true, length = 100)
    private String work;
}
