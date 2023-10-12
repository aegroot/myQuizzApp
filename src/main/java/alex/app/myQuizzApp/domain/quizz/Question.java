package alex.app.myQuizzApp.domain.quizz;

import java.util.Map;
import java.util.Set;

public class Question {

    String question;

    Set<Map.Entry<String,Boolean>> answers;

    public Set<Map.Entry<String, Boolean>> getAnswers() {
        return answers;
    }
}
