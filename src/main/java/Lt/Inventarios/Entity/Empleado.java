package Lt.Inventarios.Entity;

import Lt.Inventarios.Auth.User.User;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@Data
public class Empleado extends User {

    @Column(nullable = false)
    private String sector;

    @Column(nullable = false)
    private String documento;
}
