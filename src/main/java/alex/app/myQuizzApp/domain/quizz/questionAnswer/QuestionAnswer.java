package alex.app.myQuizzApp.domain.quizz.questionAnswer;

import alex.app.myQuizzApp.domain.quizz.question.Question;
import jakarta.persistence.*;


@Entity
public class QuestionAnswer {
   @Id
   @GeneratedValue(strategy = GenerationType.SEQUENCE)
   @Column(name = "id", nullable = false)
   private Long id;

   @ManyToOne
   @JoinColumn(name = "question_id")
   private Question question;



   //has to be equal to question.answers.length
   //set in constructor
   private boolean[]answers;

   public Question getQuestion() {
      return question;
   }

   public void setQuestion(Question question) {
      this.question = question;
   }

   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }
}
