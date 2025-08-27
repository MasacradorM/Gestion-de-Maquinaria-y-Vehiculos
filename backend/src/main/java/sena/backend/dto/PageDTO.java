package sena.backend.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PageDTO {
    private String name;
    private String description;
    private String url;
}
