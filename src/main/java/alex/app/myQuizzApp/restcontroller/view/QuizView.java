package alex.app.myQuizzApp.restcontroller.view;

import java.util.ArrayList;
import java.util.List;

public record QuizView (long quizId, List<QuestionView> questions, String description)
{

}

record QuestionView(String question, int order,List<OptionView> options) {

   static QuestionView toView(String questionText, int order, List<String> options){
        List<OptionView>optionViews=new ArrayList<>();

        for(int i=0; i<options.size(); i++){
            optionViews.add(new OptionView(options.get(i),i));
        }

        return  new QuestionView(questionText,order,optionViews);
    }
}

record OptionView(String option, int order){}
