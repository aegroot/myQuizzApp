package alex.app.myQuizzApp.domain.quizz.question;


import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/question")
public class QuestionController {

    /*
    needs methods for superuser
    delete question > no questions asked
    add question > does not need approval
    revert question > revert approved question from user

    findAll > get all questions
    findApprovedByUser > get a users approved questions
    findByUser > get all users questions

     */

    @PostMapping("personal")
    public void createYourQuestion(){
        /*
        everyone can create a question
        in order to make it official(other normal users can see it)
        it has to be approved from higher-up(ni)
        automatically added to list of your own questions
         */
    }

    @DeleteMapping("personal")
    public  void deleteYourQuestion(){
        /*
        check if question is yours, else throw
            check if question has been approved, else continue;
                delete question from your list
            delete the question
         */
    }
}
