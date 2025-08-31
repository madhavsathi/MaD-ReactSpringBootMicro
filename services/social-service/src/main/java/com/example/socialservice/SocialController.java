package com.example.socialservice;
import org.springframework.http.ResponseEntity; import org.springframework.web.bind.annotation.*; import java.util.*;
@RestController @RequestMapping("/social")
public class SocialController {
  @GetMapping("/providers") public Map<String,Object> providers(){
    return Map.of("providers", List.of("facebook","instagram","google"),
                  "configured", Map.of("facebook", true, "instagram", true, "google", true));
  }
  public record PostReq(String text, List<String> platforms) {}
  @PostMapping("/post")
  public ResponseEntity<?> post(@RequestBody PostReq req){
    return ResponseEntity.ok(Map.of("status","queued","platforms", req.platforms(), "id", UUID.randomUUID().toString()));
  }
}
