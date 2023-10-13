package alex.app.myQuizzApp.domain.quizz.question.numericQuestion;

import alex.app.myQuizzApp.domain.quizz.question.numericQuestion.NumericQuestion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NumericQuestionRepository extends JpaRepository<NumericQuestion, Long> {
}