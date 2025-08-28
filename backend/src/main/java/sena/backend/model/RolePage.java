package sena.backend.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "role_page")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RolePage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer rolePageId;

    @ManyToOne
    @JoinColumn(name = "role_id", nullable = false)
    private Role role;

    @ManyToOne
    @JoinColumn(name = "page_id", nullable = false)
    private Page page;
}
