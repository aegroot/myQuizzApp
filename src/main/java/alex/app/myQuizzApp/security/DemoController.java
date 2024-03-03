package alex.app.myQuizzApp.security;


import alex.app.myQuizzApp.security.user.UserLoginDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@CrossOrigin
@RestController
@RequestMapping("/api/v1/test")
public class DemoController {

    @GetMapping("example")
    public String giveExample(){
        return "there you go!";
    }

    @PostMapping("postmen")
    public ResponseEntity<Void> postTest(){
        System.out.println("posted");
        return ResponseEntity.ok().build();
    }
}
