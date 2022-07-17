package YaSamokat;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage {

    private final WebDriver driver;

    public static final String URL = "https://qa-scooter.praktikum-services.ru/";
    private final By orderButtonMainPageTop = By.xpath(".//div[@class='Header_Nav__AGCXC']/button[text()='Заказать']");
    private final By orderButtonMainPageBottom = By.xpath(".//div[@class='Home_FinishButton__1_cWm']/button[text()='Заказать']");
    private final By coockieField = By.id("rcc-confirm-button");
    private final By questionsBlock = By.xpath(".//div[@class='Home_FourPart__1uthg']//div[@class='accordion']//div[@class='accordion__heading']");
    private final By answersBlock = By.xpath(".//div[@class='Home_FourPart__1uthg']//div[@class='accordion']//div[@class='accordion__panel']");
    public MainPage(WebDriver driver){
        this.driver = driver;
    }

    public void removeCoockieButton() {
        driver.findElement(coockieField).click();
    }

    public void clickOrderButtonMainPageTop(String button){
        if (button == "Верхняя"){
        driver.findElement(orderButtonMainPageTop).click();
        }
        if (button == "Нижняя"){
            WebElement element = driver.findElement(orderButtonMainPageBottom);
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
            element.click();
        }
    }

    public void clickOrderButtonMainPageBottom() {
        WebElement element = driver.findElement(orderButtonMainPageBottom);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        element.click();
    }

    public void clickQuestionArrow(int index){
        WebElement element = driver.findElements(questionsBlock).get(index);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        element.click();
    }

    public String getAnswerText(int index) {
        WebElement element = driver.findElements(answersBlock).get(index);
        return element.getText();
    }

    public String getQuestionText(int index) {
        WebElement element = driver.findElements(questionsBlock).get(index);
        return element.getText();
    }
}
