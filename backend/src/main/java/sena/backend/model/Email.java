package sena.backend.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "emails")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Email {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer emailId;

    @Column(nullable = false, unique = true, length = 150)
    private String email;

    @Column(nullable = false)
    private boolean status;
}
