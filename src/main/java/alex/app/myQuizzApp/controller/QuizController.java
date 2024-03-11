package alex.app.myQuizzApp.controller;

import alex.app.myQuizzApp.controller.dto.QuestionCreationDto;
import alex.app.myQuizzApp.controller.dto.QuizCreationDto;
import alex.app.myQuizzApp.domain.quizz.Quiz;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/quiz")
public class QuizController {

    @GetMapping("find")
    public Quiz getQuizById(){

        return null;
    }
//    @PatchMapping
//    public void updateQuiz(){
//        //if user not author nor admin
//        //throw 403
//    }

    @PostMapping("create")
    public void createQuiz(@RequestBody QuizCreationDto creationDto) {

    }
//
//    @PostMapping("favorite")
//    public  void favoriteQuiz(){}
//
//    @DeleteMapping("favorite")
//    public void unFavoriteQuiz(){}
}
