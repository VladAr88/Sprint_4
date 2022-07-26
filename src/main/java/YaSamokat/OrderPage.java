package YaSamokat;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OrderPage {

    private final WebDriver driver;
    private final By nameField = By.xpath(".//input[contains(@class, 'Input_Input__1iN_Z')][contains(@placeholder, 'Имя')]");
    private final By surnameField = By.xpath(".//input[contains(@class, 'Input_Input__1iN_Z')][contains(@placeholder, 'Фамилия')]");
    private final By address = By.xpath(".//input[contains(@class, 'Input_Input__1iN_Z')][contains(@placeholder, 'Адрес')]");
    private final By metroStation = By.xpath(".//input[contains(@class, 'select-search__input')][contains(@placeholder, 'метро')]");
    private final By telephoneNumber = By.xpath(".//input[contains(@class, 'Input_Input__1iN_Z')][contains(@placeholder, 'Телефон')]");
    private final By proceedButton = By.xpath(".//div[@class='Order_NextButton__1_rCA']/button[text()='Далее']");
    private final By chooseStation = By.xpath(".//ul[contains(@class,'select-search__options')]/li");
    private final By calendar = By.xpath(".//div[contains(@class, 'react-datepicker__input-container')]/input[contains(@placeholder, '* Когда привезти самокат')]");
    private final By date = By.xpath(".//div[@class='react-datepicker__month']//div[contains(@class,'react-datepicker__day')]");
    private final By rentPeriod = By.xpath(".//div[@class='Dropdown-placeholder'][text()='* Срок аренды']");
    private final By rentPeriodOption = By.xpath(".//div[@class='Dropdown-root is-open']//div[@class='Dropdown-option']");
    private final By blackPerlColor = By.id("black");
    private final By greyColor = By.id("grey");
    private final By comment = By.xpath(".//input[contains(@class, 'Input_Input__1iN_Z')][contains(@placeholder, 'Комментарий для курьера')]");
    private final By finalizeOrderButton = By.xpath(".//div[@class='Order_Buttons__1xGrp']/button[text()='Заказать']");
    private final By finalizeOrderButtonConfirm = By.xpath(".//div[@class='Order_Buttons__1xGrp']/button[text()='Да']");
    private final By confirmationMessage = By.xpath(".//div[@class='Order_ModalHeader__3FDaJ'][text()='Заказ оформлен']");

    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setNameField(String nameValue) {
        driver.findElement(nameField).click();
        driver.findElement(nameField).sendKeys(nameValue);
    }

    public void setSurnameField(String surnameValue) {
        driver.findElement(surnameField).click();
        driver.findElement(surnameField).sendKeys(surnameValue);
    }

    public void setAddressField(String addressValue) {
        driver.findElement(address).click();
        driver.findElement(address).sendKeys(addressValue);
    }

    public void setMetroField(int index) {
        WebElement element = driver.findElement(metroStation);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        element.click();
        driver.findElements(chooseStation).get(index).click();
    }

    public void setTelephoneNumberField(String telephoneValue) {
        WebElement element = driver.findElement(telephoneNumber);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        element.click();
        element.sendKeys(telephoneValue);
    }

    public void clickNextButton() {
        WebElement element = driver.findElement(proceedButton);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        element.click();
    }

    public void clickCalendar(int index) {
        driver.findElement(calendar).click();
        driver.findElements(date).get(index).click();
    }

    public void clickRentPeriod(int index) {
        driver.findElement(rentPeriod).click();
        driver.findElements(rentPeriodOption).get(index).click();
    }

    public void chooseScooterColor(String color) {
        if (color == "black") {
            driver.findElement(blackPerlColor).click();
        }
        if (color == "grey"){
            driver.findElement(greyColor).click();
        }
    }

    public void putComment(String commentValue) {
        driver.findElement(comment).click();
        driver.findElement(comment).sendKeys(commentValue);
    }

    public void placeOrder() {
        driver.findElement(finalizeOrderButton).click();
    }

    public void placeOrderConfirm() {
        driver.findElement(finalizeOrderButtonConfirm).click();
    }

    public boolean checkConfirmationMessage() {
        return driver.findElement(confirmationMessage).isDisplayed();
    }
}
