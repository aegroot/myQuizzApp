package alex.app.myQuizzApp.domain.quizz.questionAnswer;

import alex.app.myQuizzApp.domain.quizz.question.Option;
import alex.app.myQuizzApp.domain.quizz.question.Question;
import jakarta.persistence.*;

import java.util.List;
import java.util.Set;

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

   public void setAnswers(boolean[] answers) {
      this.answers = answers;
   }

   public boolean[] getAnswers() {
      return answers;
   }

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

   public boolean evaluate(){
     List<Option> options= question.getAnswers();

     if (answers==null){return  false;}
     else if(answers.length!=options.size())
        throw new RuntimeException("lists must be of same size");


      for (int i = 0; i <answers.length ; i++) {
         if(options.get(i).getIsRight() != answers[i]){return  false;}
      }
      return true;
   }
}
