package alex.app.myQuizzApp.restcontroller;

import alex.app.myQuizzApp.dbService.QuizService;
import alex.app.myQuizzApp.restcontroller.dto.QuizCreationDto;
import alex.app.myQuizzApp.domain.quizz.Quiz;
import alex.app.myQuizzApp.restcontroller.view.QuizView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/quiz")
public class QuizController {

    @Autowired
    QuizService quizService;

    @GetMapping("find")
    public ResponseEntity<QuizView>  getQuizById(){
        return null;
    }

//    @PatchMapping
//    public void updateQuiz(){
//        //if user not author nor admin
//        //throw 403
//    }

    @PostMapping("create")
    public void createQuiz(@RequestBody QuizCreationDto creationDto) {

        quizService.create(creationDto.convertToQuiz());


    }

}
