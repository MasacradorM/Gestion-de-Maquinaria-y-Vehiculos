package sena.backend.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "roles")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Role {

    @Id
    @GeneratedValue(name= "roleId",strategy = GenerationType.IDENTITY)
    private Integer roleId;

    @Column(name= "role",nullable = false, unique = true, length = 100)
    private String role;

    @Column(name= "permissionDescription",nullable = false, length = 250)
    private String permissionDescription;
}

