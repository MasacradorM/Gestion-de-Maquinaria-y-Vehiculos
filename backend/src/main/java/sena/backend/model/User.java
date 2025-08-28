package sena.backend.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;

    @Column(nullable = false, length = 100, unique = true)
    private String userName;

    @Column(nullable = false, length = 255)
    private String password;

    @Column(nullable = false, unique = true)
    private String emailId;

    @Column(nullable = false)
    private Long phone;

    @Column(nullable = false, unique = true)
    private Long identification;

    @Column(nullable = false)
    private Integer modificationTime;

    @Column(nullable = false)
    private Boolean status;
}

