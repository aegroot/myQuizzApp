package alex.app.myQuizzApp.domain.quizz.question;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MultipleChoiceQuestionRepository extends JpaRepository<MultipleChoiceQuestion, Long> {
}