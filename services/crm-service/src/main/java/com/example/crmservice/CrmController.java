package com.example.crmservice;
import org.springframework.web.bind.annotation.*; import java.util.*;
@RestController @RequestMapping("/crm")
public class CrmController {
  @GetMapping("/contacts")
  public Map<String,Object> contacts(){
    return Map.of("contacts", List.of(
      Map.of("name","John Doe","email","john@example.com","phone","+1-555-0101"),
      Map.of("name","Jane Smith","email","jane@example.com","phone","+1-555-0102")
    ));
  }
  @GetMapping("/communications")
  public Map<String,Object> comms(){
    return Map.of("communications", List.of(
      Map.of("contact","John Doe","channel","Email","summary","Asked about backsplash options"),
      Map.of("contact","Jane Smith","channel","WhatsApp","summary","Sent photos of kitchen layout")
    ));
  }
  @PostMapping("/zoho/sync")
  public Map<String,Object> zohoSync(){ return Map.of("status","ok","synced", 12); }
}
