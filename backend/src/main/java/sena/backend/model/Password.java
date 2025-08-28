package sena.backend.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "password")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Password {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "passwordId", nullable = false)
    private Integer passwordId;

    @Column(name = "password", nullable = false, length = 150)
    private String password;

    @Column(name = "status", nullable = false)
    private boolean status;
}
