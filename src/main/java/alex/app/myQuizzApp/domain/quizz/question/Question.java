package alex.app.myQuizzApp.domain.quizz.question;

import java.util.Map;
import java.util.Set;

public class Question {

    private QuestionType questionType;
    private String question;
    private Set<QuestionSubject> questionSubject;
    private Set<Map.Entry<String,Boolean>> answers;

    public Set<Map.Entry<String, Boolean>> getAnswers() {
        return answers;
    }
}
