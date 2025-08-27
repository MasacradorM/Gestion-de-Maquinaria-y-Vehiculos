package sena.backend.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "pages")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Page {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer pageId;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(nullable = false, length = 250)
    private String description;

    @Column(nullable = false, length = 200)
    private String url;
}

