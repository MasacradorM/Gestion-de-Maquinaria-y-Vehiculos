package sena.backend.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserRegisterDTO {
    private String userName;
    private String password;
    private String emailId;
    private Long phone;
    private Long identification;
    private Integer modificationTime;
}
