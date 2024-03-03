package alex.app.myQuizzApp.security;

import alex.app.myQuizzApp.security.user.*;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.ZonedDateTime;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class AuthenticationService {

    private final PasswordEncoder passwordEncoder;

    private final AuthTokenRepository authTokenRepository;

    private final UserRepository userRepository;

    private final String secret="2501d9c84ec8d94402749f3fb8234f8bd5212b80137b7670023a862498aad704";

    public static final int EXPIRATION_TIME_MINUTES=60;


    public AuthenticationService(PasswordEncoder passwordEncoder, UserRepository userRepository, AuthTokenRepository authTokenRepository) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
        this.authTokenRepository = authTokenRepository;
    }

    public String login(UserLoginDto dto){
        Optional<User> detailsOptional= userRepository.findByEmail(dto.getUsername());

        String hashedLogin=passwordEncoder.encode(dto.getPassword());

        if (detailsOptional.isEmpty())
            return null;

        User details=detailsOptional.get();

        if(Objects.equals(hashedLogin, details.getPassword())){

            String token=generateToken(dto.getUsername());

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

    public String generateToken(String username) {
       return Jwts.builder().
                setSubject(username)
                .setExpiration(Date.from(ZonedDateTime.now().plusMinutes(EXPIRATION_TIME_MINUTES).toInstant()))
                .signWith(SignatureAlgorithm.HS512,secret)
                .compact();

    }

    public void register(UserRegisterDto userRegisterDto){

        String encryptedPassword=passwordEncoder.encode(userRegisterDto.getPassword());

        User newUser= new User();

        if(usernameCheck(userRegisterDto.getUsername())){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"username already exists");
        }

        else if (emailCheck(userRegisterDto.getEmail())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"email already exists");
        }
        newUser.setEmail(userRegisterDto.getEmail());
        newUser.setUsername(userRegisterDto.getUsername());
        newUser.setPassword(encryptedPassword);

        userRepository.save(newUser);

    }

    private  boolean usernameCheck(String username){
        return userRepository.existsByUsername(username);
    }

    private boolean emailCheck(String email) {
        return userRepository.existsByEmail(email);
    }

    @Override
    public String toString() {
        return "AuthenticationService{" +
                "passwordEncoder=" + passwordEncoder +
                ", authTokenRepository=" + authTokenRepository +
                ", userRepository=" + userRepository +
                ", secret='" + secret + '\'' +
                '}';
    }
}
