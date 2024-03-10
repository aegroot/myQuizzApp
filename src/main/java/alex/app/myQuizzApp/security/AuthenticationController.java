package alex.app.myQuizzApp.security;


import alex.app.myQuizzApp.security.user.UserLoginDto;
import alex.app.myQuizzApp.security.user.UserRegisterDto;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;


@CrossOrigin
@RestController
@RequestMapping("/api/v1/auth")
public class AuthenticationController {

    private  final AuthenticationService authenticationService;

    public AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping("register")
    public ResponseEntity<String> registerUser(@RequestBody UserRegisterDto dto){

        try{authenticationService.register(dto);

            return new ResponseEntity<>(HttpStatusCode.valueOf(200));}
        catch (ResponseStatusException r){
            return new ResponseEntity<>(r.getMessage(), r.getStatusCode());
        }
    }

    @PostMapping("login")
    public ResponseEntity<String>loginUser(@RequestBody UserLoginDto dto){

        try{

          String token =  authenticationService.login(dto);
            return new ResponseEntity<>(token, HttpStatusCode.valueOf(200));
        }
        catch (ResponseStatusException res){

            return new ResponseEntity<>(res.getMessage(),HttpStatusCode.valueOf(403));
        }


    }
}
