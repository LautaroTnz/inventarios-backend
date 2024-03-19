package Lt.Inventarios.Auth.Service;

import Lt.Inventarios.Auth.Dto.AuthResponse;
import Lt.Inventarios.Auth.Entity.Enum.Role;
import Lt.Inventarios.Auth.Entity.User;
import Lt.Inventarios.Auth.Dto.LoginRequest;
import Lt.Inventarios.Auth.Dto.RegisterRequest;
import Lt.Inventarios.Auth.Repository.UserRepository;
import Lt.Inventarios.Jwt.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;

    public AuthResponse login(LoginRequest request) {
        return null;
    }

    public AuthResponse register(RegisterRequest request) {
        User user = User.builder()
                .username(request.getUsername())
                .password(passwordEncoder.encode( request.getPassword()))
                .firstname(request.getFirstname())
                .lastname(request.getLastname())
                .country(request.getCountry())
                .role(Role.USER)
                .build();
        userRepository.save(user);

        return AuthResponse.builder()
                .token(jwtService.getToken(user))
                .build();

    }
}
