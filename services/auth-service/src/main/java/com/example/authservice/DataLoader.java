package com.example.authservice;
import org.springframework.beans.factory.annotation.Value; import org.springframework.boot.CommandLineRunner; import org.springframework.stereotype.Component;
@Component public class DataLoader implements CommandLineRunner {
  private final UserRepo repo; @Value("${app.admin.email:admin@example.com}") String adminEmail; @Value("${app.admin.password:admin123}") String adminPassword;
  public DataLoader(UserRepo repo){this.repo=repo;}
  public void run(String... args){
    if(repo.findByEmail(adminEmail.toLowerCase()).isEmpty()) repo.save(new User(adminEmail.toLowerCase(), adminPassword, "ADMIN"));
    if(repo.findByEmail("user@example.com").isEmpty()) repo.save(new User("user@example.com","user123","USER"));
  }
}
