package alex.app.myQuizzApp.service;

import alex.app.myQuizzApp.domain.question.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Long> {
}