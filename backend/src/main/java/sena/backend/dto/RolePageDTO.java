package sena.backend.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RolePageDTO {
    private Integer roleId;
    private Integer pageId;
}
