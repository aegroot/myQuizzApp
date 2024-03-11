package alex.app.myQuizzApp.controller.dto;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

public class QuizCreationDto {


    private LocalTime allowedTime;

    private List<QuestionCreationDto> questions;


}
