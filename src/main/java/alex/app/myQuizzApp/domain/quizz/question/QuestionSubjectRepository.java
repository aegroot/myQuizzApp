package alex.app.myQuizzApp.domain.quizz.question;

import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionSubjectRepository extends JpaRepository<QuestionSubject, String> {
}