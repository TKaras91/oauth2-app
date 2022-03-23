package pl.tkaras.oauth2app.api;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.tkaras.oauth2app.api.entity.User;

import java.util.Date;

@RestController
public class LoginApi {

    @PostMapping("/logIn")
    public String get(@RequestBody User user){

       long currentTimeMillis = System.currentTimeMillis();

        return Jwts.builder()
                .setSubject(user.getLogin())
                .claim("RULES", "USER")
                .setIssuedAt(new Date(currentTimeMillis))
                .setExpiration(new Date(currentTimeMillis + 20000))
                .signWith(SignatureAlgorithm.HS512, user.getPassword())
                .compact();
    }
}
