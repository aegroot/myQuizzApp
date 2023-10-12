package alex.app.myQuizzApp.domain.quizz;

import alex.app.myQuizzApp.domain.quizz.question.Question;

import java.util.Set;

public class Quiz {
    private String description;

    //set subjects from questions
    //option to restrict questions on subject(s)?
    Set<Question> questions;
}
