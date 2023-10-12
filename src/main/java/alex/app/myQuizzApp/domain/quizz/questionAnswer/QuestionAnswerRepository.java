package alex.app.myQuizzApp.domain.quizz.questionAnswer;

import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionAnswerRepository extends JpaRepository<QuestionAnswer, Long> {
}