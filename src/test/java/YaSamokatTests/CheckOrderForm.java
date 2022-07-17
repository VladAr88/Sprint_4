package YaSamokatTests;

import YaSamokat.MainPage;
import YaSamokat.OrderPage;
import YaSamokat.Resources;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class CheckOrderForm extends BaseUITest {

    private final String button;
    private final String name;
    private final String surname;
    private final String address;
    private final String telephoneNumber;
    private final String metro;
    private final String calendar;
    private final String rentPeriod;
    private final String scooterColor;
    private final String comment;

    public CheckOrderForm(String button,String name, String surname, String address, String telephoneNumber, String metro,
                          String calendar, String rentPeriod, String scooterColor, String comment) {
        this.button = button;
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.telephoneNumber = telephoneNumber;
        this.metro = metro;
        this.calendar = calendar;
        this.rentPeriod = rentPeriod;
        this.scooterColor = scooterColor;
        this.comment = comment;
    }

    @Parameterized.Parameters // добавили аннотацию
    public static Object[][] scooterOrderDataData() {
        Resources resources = new Resources();
        return new Object[][] {
                { "Верхняя","Владимир", "Аранович","тестовый адрес", "89063174272", "1", "3", "3","black","тестовый комментарий"},
                { "Нижняя","Юлия", "Аранович","тестовый адрес", "89053888261", "2", "5", "1","grey","тестовый комментарий 2"},
        };
    }

    @Test
    public void checkOrderButtonTopClick() {

        driver.get(MainPage.URL);

        MainPage mainPage = new MainPage(driver);
        mainPage.removeCoockieButton();
        mainPage.clickOrderButtonMainPageTop(button);

        OrderPage orderPage = new OrderPage(driver);

        orderPage.setNameField(name);
        orderPage.setSurnameField(surname);
        orderPage.setAddressField(address);
        orderPage.setTelephoneNumberField(telephoneNumber);
        orderPage.setMetroField(Integer.parseInt(metro));

        orderPage.clickNextButton();

        orderPage.clickCalendar(Integer.parseInt(calendar));
        orderPage.clickRentPeriod(Integer.parseInt(rentPeriod));
        orderPage.chooseScooterColor(scooterColor);
        orderPage.putComment(comment);

        orderPage.placeOrder();
        orderPage.placeOrderConfirm();

        assertTrue("Заказ не был оформлен",orderPage.checkConfirmationMessage());
    }
}


