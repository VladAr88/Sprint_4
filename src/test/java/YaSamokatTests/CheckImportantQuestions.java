package YaSamokatTests;

import YaSamokat.MainPage;
import YaSamokat.Resources;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class CheckImportantQuestions extends BaseUITest{

    private final String index;
    private final String question;
    private final String answer;

    public CheckImportantQuestions(String index, String question, String answer) {
        this.index = index;
        this.question = question;
        this.answer = answer;
    }

    @Parameterized.Parameters // добавили аннотацию
    public static Object[][] getQuestionsAnswersData() {
        Resources resources = new Resources();
        return new Object[][] {
                { "0", resources.question1, resources.answer1},
                { "1", resources.question2, resources.answer2},
                { "2", resources.question3, resources.answer3},
                { "3", resources.question4, resources.answer4},
                { "4", resources.question5, resources.answer5},
                { "5", resources.question6, resources.answer6},
                { "6", resources.question7, resources.answer7},
                { "7", resources.question8, resources.answer8},
        };
    }

    @Test
    public void questionTest(){
        driver.get(MainPage.URL);
        int i = Integer.parseInt(index);
        MainPage mainPage = new MainPage(driver);
        mainPage.removeCoockieButton();
        mainPage.clickQuestionArrow(i);
        assertEquals(question, mainPage.getQuestionText(i));
        assertEquals(answer, mainPage.getAnswerText(i));
    }
}
