package alex.app.myQuizzApp.restcontroller.dto;

import alex.app.myQuizzApp.domain.question.Option;
import alex.app.myQuizzApp.domain.question.Question;
import alex.app.myQuizzApp.domain.quizz.Quiz;

import java.time.LocalTime;
import java.util.List;

public class QuizCreationDto  {

    private String description;

    private LocalTime allowedTime;

    private List<QuestionCreationDto> questionCreationDtoList;

    public Quiz convertToQuiz(){

        List<Question> questions= questionCreationDtoList.stream().map(QuestionCreationDto::toQuestion).toList();

        return new Quiz(description,allowedTime,questions);
    }
}

record QuestionCreationDto(String questionText,  List<OptionDto> options) {

    public Question toQuestion(){
        Question question= new Question();
        question.setQuestion(questionText);
        question.setOptions(options.stream().map(OptionDto::toOption).toList());
        return question;
    }

}

record OptionDto(String description, boolean answer){

    public Option toOption(){return new Option(this.description,this.answer);}
}
