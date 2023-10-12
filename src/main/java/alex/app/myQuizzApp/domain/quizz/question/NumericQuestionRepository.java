package alex.app.myQuizzApp.domain.quizz.question;

import org.springframework.data.jpa.repository.JpaRepository;

public interface NumericQuestionRepository extends JpaRepository<NumericQuestion, Long> {
}