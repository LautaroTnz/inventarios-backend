package Lt.Inventarios.Entity.Dto;

import Lt.Inventarios.Auth.User.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmpleadoDTO {
    String username;
    String password;
    String firstname;
    String lastname;
    String country;
    String sector;
    String documento;
    Role role;
}
