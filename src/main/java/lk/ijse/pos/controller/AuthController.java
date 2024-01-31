package lk.ijse.pos.controller;

import lk.ijse.pos.dto.LogInDTO;
import lk.ijse.pos.entity.User;
import lk.ijse.pos.repository.UserRepository;
import lk.ijse.pos.security.jwt.JwtUtil;
import lk.ijse.pos.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class AuthController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtUtils;

    @PostMapping("/auth/signup")
    public ResponseEntity<?> postMethodName(@RequestBody User user) {
        if(userRepository.existsByUsername(user.getUsername())){
            return ResponseEntity.badRequest().body("Username already exists");
        }
        if(userRepository.existsByEmail(user.getEmail())){
            return ResponseEntity.badRequest().body("Email already exists");
        }

        User newUser =new User();
        newUser.setUsername(user.getUsername());
        newUser.setEmail(user.getEmail());
        newUser.setPassword(passwordEncoder.encode(user.getPassword()));

        return ResponseEntity.ok(userService.createUser(newUser));
    }

    @PostMapping("/auth/signin")
    public ResponseEntity<?> login(@RequestBody LogInDTO loginDTO) {
        Authentication authentication= authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginDTO.getUsername(), loginDTO.getPassword())
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = jwtUtils.generateJwtToken(authentication);

        return ResponseEntity.ok(jwt);
    }
}
