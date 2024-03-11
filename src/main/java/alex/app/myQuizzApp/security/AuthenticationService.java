package alex.app.myQuizzApp.security;

import alex.app.myQuizzApp.security.user.*;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class AuthenticationService {

    private final PasswordEncoder passwordEncoder;

    private final AuthTokenRepository authTokenRepository;

    private final AuthenticationManager authenticationManager;

    private final UserRepository userRepository;

    private final String secret="2501d9c84ec8d94402749f3fb8234f8bd5212b80137b7670023a862498aad704";

    public static final int EXPIRATION_TIME_MINUTES=60;

    public AuthenticationService(PasswordEncoder passwordEncoder, UserRepository userRepository, AuthTokenRepository authTokenRepository, AuthenticationManager authenticationManager) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
        this.authTokenRepository = authTokenRepository;
        this.authenticationManager = authenticationManager;
    }

    public String login(UserLoginDto dto){


        Optional<User> detailsOptional= userRepository.findByUsername(dto.getUsername());
        User details=detailsOptional.orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));

//        passwords match raw and encoded
//        System.out.println(passwordEncoder.matches(dto.getPassword(),details.getPassword()));

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(details,dto.getPassword()
                ));

        System.out.println("managed auth");

        String token=generateToken(dto.getUsername());

        authTokenRepository.save(new AuthToken(token,details));

        return token;
    }

    public void revokeUserTokens(long userId){
        List<AuthToken> tokens=authTokenRepository.findByUser_Id(userId);

        tokens.forEach(token-> {token.setRevoked(true); token.setExpired(true); });

        authTokenRepository.saveAll(tokens);
    }

    public String generateToken(String username) {
       return Jwts.builder().
                setSubject(username)
               .claim("username",username)
                .setExpiration(Date.from(ZonedDateTime.now().plusMinutes(EXPIRATION_TIME_MINUTES).toInstant()))
                .compact();
    }

    public void register(UserRegisterDto userRegisterDto){

        User newUser= new User();

        if(usernameCheck(userRegisterDto.getUsername())){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"already exists");
        }

        else if (emailCheck(userRegisterDto.getEmail())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"already exists");
        }
        String encryptedPassword=passwordEncoder.encode(userRegisterDto.getPassword());

        newUser.setEmail(userRegisterDto.getEmail());
        newUser.setUsername(userRegisterDto.getUsername());
        newUser.setPassword(encryptedPassword);
        newUser.setRole(UserRole.USER);

        System.out.println(newUser.getPassword());

        userRepository.save(newUser);

        System.out.println (userRepository.findAll());

        System.out.println(userRepository.count());
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
