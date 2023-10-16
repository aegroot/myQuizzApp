package alex.app.myQuizzApp.domain.quizz.quizAttempt;


import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/quizAttempt")
public class QuizAttemptController {



    @GetMapping("begin")
    public void beginQuiz(){}

    @PostMapping("submitAnswer")
    public void submitAnswer(){}

    @PatchMapping("pause")
    public void pauseQuiz(){}

    @PatchMapping("end")
    public  void endQuiz(){}

}
