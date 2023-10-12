package alex.app.myQuizzApp.domain.quizz;

import alex.app.myQuizzApp.domain.quizz.question.Question;

public class QuestionAnswer {
   private Question question;

   //has to be equal to question.answers.length
   //set in constructor
   private boolean[]answers;
}
