package alex.app.myQuizzApp.dbService;

import alex.app.myQuizzApp.domain.question.QuestionSubject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionSubjectRepository extends JpaRepository<QuestionSubject, String> {
}