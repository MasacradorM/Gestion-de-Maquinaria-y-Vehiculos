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
    @GeneratedValue(name= "activityId",strategy = GenerationType.IDENTITY)
    private Integer activityId;

    @Column(name= "activityName",nullable = false, unique = true, length = 100)
    private String activityName;
}
