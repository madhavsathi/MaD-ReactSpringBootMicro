package com.example.emailservice;
import org.springframework.web.bind.annotation.*; import java.util.*;
@RestController @RequestMapping("/email")
public class EmailController {
  @GetMapping("/threads")
  public Map<String,Object> threads(){
    List<Map<String,String>> data = new ArrayList<>();
    data.add(Map.of("id","t1","from","customer1@example.com","subject","Kitchen remodel quote","snippet","Hi, can you share pricing..."));
    data.add(Map.of("id","t2","from","lead2@example.com","subject","Countertops inquiry","snippet","Looking for Calacatta..."));
    return Map.of("threads", data);
  }
}
