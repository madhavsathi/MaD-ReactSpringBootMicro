package com.example.authservice;
import jakarta.persistence.*;
@Entity @Table(name="users")
public class User {
  @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
  @Column(unique=true) private String email; private String password; private String role;
  public User(){}
  public User(String e,String p,String r){email=e;password=p;role=r;}
  public Long getId(){return id;} public String getEmail(){return email;} public String getPassword(){return password;} public String getRole(){return role;}
  public void setEmail(String v){email=v;} public void setPassword(String v){password=v;} public void setRole(String v){role=v;}
}
