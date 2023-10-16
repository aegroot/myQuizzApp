package alex.app.myQuizzApp.domain.quizz;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/quiz")
public class QuizController {

    @GetMapping
    public Quiz getQuizById(){

        return null;
    }
    @PatchMapping
    public void updateQuiz(){
        //if user not author nor admin
        //throw 404
    }

    @PostMapping
    public  void createQuiz(){
        /*needs:
        allowedTime
        questions
         */
    }
}
