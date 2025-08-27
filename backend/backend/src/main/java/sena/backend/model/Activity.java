package sena.backend.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "activities")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Activity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer activityId;

    @Column(nullable = false, unique = true, length = 100)
    private String activityName;
}
