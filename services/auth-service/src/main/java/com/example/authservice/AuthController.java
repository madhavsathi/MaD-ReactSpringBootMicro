package com.example.authservice;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.constraints.NotBlank;
import java.util.Map;
@RestController @RequestMapping("/auth")
public class AuthController {
  private final UserRepo repo; private final TokenService tokens;
  public AuthController(UserRepo repo, TokenService tokens){this.repo=repo; this.tokens=tokens;}
  public record LoginReq(@NotBlank String email, @NotBlank String password) {}
  @PostMapping("/login")
  public ResponseEntity<?> login(@RequestBody LoginReq req){
    var u = repo.findByEmail(req.email().toLowerCase()).orElse(null);
    if(u==null || !u.getPassword().equals(req.password())) return ResponseEntity.status(401).body(Map.of("error","invalid_credentials"));
    String token = tokens.issue(u.getEmail(), u.getRole());
    return ResponseEntity.ok(Map.of("token", token, "role", u.getRole(), "email", u.getEmail()));
  }
  @GetMapping("/me")
  public ResponseEntity<?> me(@RequestHeader(value="Authorization", required=false) String auth){
    var payload = tokens.parse(auth); if(payload==null) return ResponseEntity.status(401).build(); return ResponseEntity.ok(payload);
  }
}
