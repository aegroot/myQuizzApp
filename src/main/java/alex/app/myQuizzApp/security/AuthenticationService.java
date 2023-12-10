package alex.app.myQuizzApp.security;

import alex.app.myQuizzApp.security.user.*;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;


public class AuthenticationService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    public static final int EXPIRATION_TIME_MINUTES=60;

   UserRepository myUserDetailsService;

    @Value("${jwt.secret}")
    private String secret;

    AuthTokenRepository authTokenRepository;

    public String login(UserLoginDto dto){
        Optional<User> detailsOptional= myUserDetailsService.findByEmail(dto.getUsername());

        String hashedLogin=passwordEncoder.encode(dto.getPassword());

        if (detailsOptional.isEmpty())
            return null;

        User details=detailsOptional.get();

        if(Objects.equals(hashedLogin, details.getPassword())){

            String token=Jwts.builder().
                    setSubject(dto.getUsername())
                    .signWith(SignatureAlgorithm.HS512,secret)
                    .setExpiration(Date.from(ZonedDateTime.now().plusMinutes(EXPIRATION_TIME_MINUTES).toInstant()))
                    .compact();

            authTokenRepository.save(new AuthToken(token,details));



            return token;
        }
        else  return null;
    }

    public void revokeUserTokens(long userId){
        List<AuthToken> tokens=authTokenRepository.findByUser_Id(userId);

        tokens.forEach(token-> {token.setRevoked(true); token.setExpired(true); });

        authTokenRepository.saveAll(tokens);
    }

    public void register(){}
}
