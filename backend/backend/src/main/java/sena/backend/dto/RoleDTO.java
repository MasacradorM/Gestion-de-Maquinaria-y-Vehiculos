package sena.backend.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RoleDTO {
    private String role;
    private String permissionDescription;
}
