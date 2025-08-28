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
    @GeneratedValue(name= "pageId",strategy = GenerationType.IDENTITY)
    private Integer pageId;

    @Column(name= "name",nullable = false, length = 100)
    private String name;

    @Column(name= "description",nullable = false, length = 250)
    private String description;

    @Column(name= "url",nullable = false, length = 200)
    private String url;
}

