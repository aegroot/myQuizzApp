package alex.app.myQuizzApp.dbService;

import alex.app.myQuizzApp.domain.quizz.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizRepository extends JpaRepository<Quiz, Long> {


}