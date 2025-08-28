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
    @GeneratedValue(name= "workId"strategy = GenerationType.IDENTITY)
    private Integer workId;

    @Column(name= "work",nullable = false, unique = true, length = 100)
    private String work;
}
