package com.example.authservice;
import org.springframework.beans.factory.annotation.Value; import org.springframework.stereotype.Service;
import java.util.Base64; import java.util.Map; import java.util.HashMap;
@Service public class TokenService {
  @Value("${app.jwt.secret:change-me}") String secret;
  public String issue(String email, String role){ var raw = email+":"+role+":"+secret; return "Bearer "+Base64.getEncoder().encodeToString(raw.getBytes()); }
  public Map<String,String> parse(String auth){
    try{ if(auth==null || !auth.startsWith("Bearer ")) return null;
      var raw = new String(Base64.getDecoder().decode(auth.substring(7)));
      var p = raw.split(":"); if(p.length<3) return null;
      var m = new HashMap<String,String>(); m.put("email", p[0]); m.put("role", p[1]); return m;
    }catch(Exception e){ return null; }
  }
}
