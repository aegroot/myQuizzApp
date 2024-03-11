package alex.app.myQuizzApp.controller.dto;

import alex.app.myQuizzApp.domain.question.Option;
import alex.app.myQuizzApp.domain.question.Question;

import java.util.List;

public class QuestionCreationDto {

    private String questionText;

    private List<OptionDto> options;

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