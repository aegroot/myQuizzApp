package alex.app.myQuizzApp.domain.quizz.question.multipleChoiceQuestion;


import alex.app.myQuizzApp.domain.quizz.question.Question;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@DiscriminatorValue("multiple_choice")
public class MultipleChoiceQuestion extends Question {

    @OneToMany
    private Set<Option> answers;
}

