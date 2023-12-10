package alex.app.myQuizzApp.security;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/test")
public class DemoController {

    @GetMapping("example")
    public String giveExample(){
        return "there you go!";
    }
}
