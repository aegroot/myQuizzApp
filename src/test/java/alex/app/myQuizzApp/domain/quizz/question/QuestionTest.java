package alex.app.myQuizzApp.domain.quizz.question;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class QuestionTest {


    @ParameterizedTest
    @MethodSource("optionsTestProvider")
    public void OptionsTest(List<Option> options, boolean expectation){

        Question q= new Question();
        q.setOptions(options);
        q.setQuestion("what is one plus two");

        assertEquals(Question.isValid(q),expectation);
    }

    static Stream<Arguments> optionsTestProvider(){

        return Stream.of(
                Arguments.of(
                        List.of(
                                new Option("1",false),
                                new Option("bigger than 2",true),
                                new Option("bigger than 4",false),
                                new Option("3",true)
                        ), true

                ),
                Arguments.of(
                List.of(
                        new Option("1",false),
                        new Option("bigger than 4",true),
                        new Option("bigger than 4",false),
                        new Option("3",true)
                ), false),
                Arguments.of(
                        List.of(

                        ), false)
                , Arguments.of(
                        List.of(
                                new Option("bigger than 4",false),
                                new Option("bigger than 4",true),
                                new Option("bigger than 4",false),
                                new Option("3",true)
                        ), false)
                , Arguments.of(
                        List.of(
                                new Option("1",false),
                                new Option("bigger than 3",false),
                                new Option("bigger than 4",false),
                                new Option("3",false)
                        ), false)

        );
    }






}
