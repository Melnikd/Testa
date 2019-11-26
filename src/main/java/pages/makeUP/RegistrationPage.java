package pages.makeUP;

import model.MakeUpCredentials;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;
import utils.SleepUtils;

public class RegistrationPage extends BasePage {


    @FindBy(xpath = "//input[@id='name']")
    private WebElement fieldName;


    @FindBy(xpath = "//input[@id='surname']")
    private WebElement fieldLastName;


    @FindBy(xpath = "//input[@id='email']")
    private WebElement fieldEmail;


    @FindBy(xpath = "//input[@id='phone']")
    private WebElement fieldPhone;


    @FindBy(xpath = "//input[@id='city']")
    private WebElement fieldCity;


    @FindBy(xpath = "//li[@class='search-value__list_item']")
    private WebElement fieldCitySpecifically;


    @FindBy(xpath = "//input[@id='street']")
    private WebElement fieldStreet;


    @FindBy(xpath = "//li[@class='search-value__list_item']")
    private WebElement fieldStreetSpecifically;


    @FindBy(xpath = "//input[@id='house']")
    private WebElement fieldHouse;


    @FindBy(xpath = "//input[@id='password']")
    private WebElement fieldPassword;


    @FindBy(xpath = "//input[@id='repeat-password']")
    private WebElement fieldRepeatPassword;


    @FindBy(xpath = "//button[@class='button']")
    private WebElement buttonSubmit;

    public RegistrationPage() {
        super("https://makeup.com.ua/register/");
    }

    public static RegistrationPage createRegistrationPage() {
        return new RegistrationPage();
    }

    //////////////////////////////////////////////////
    public RegistrationPage typeFieldname() {
        fieldName.sendKeys("Name");
        return this;
    }

    public RegistrationPage typeFieldLastName() {
        fieldLastName.sendKeys("LastName");
        return this;
    }


    public RegistrationPage typeFieldEmail(MakeUpCredentials generateCredentials) {
        fieldEmail.sendKeys(generateCredentials.
                getLogin());
        return this;
    }

    public RegistrationPage clickFieldPhone() {
        fieldPhone.click();
        return this;
    }

    public RegistrationPage typeFieldPhone(MakeUpCredentials generateCredentials) {
        fieldPhone.sendKeys(generateCredentials.
                getPhoneNumber());
        SleepUtils.sleep(1);
        return this;
    }

    public RegistrationPage typeFieldCity() {
        fieldCity.sendKeys("Киев");
        return this;
    }

    public RegistrationPage clickFieldCitySpecifically() {
        fieldCitySpecifically.click();
        return this;
    }

    public RegistrationPage typeFieldStreet() {
        fieldStreet.sendKeys("Киевская");
        return this;
    }

    public RegistrationPage clickFieldStreetSpecifically() {
        fieldStreetSpecifically.click();
        return this;
    }

    public RegistrationPage typeFieldHouse() {
        fieldHouse.sendKeys("1");
        return this;
    }


    public RegistrationPage typeFieldPassword(MakeUpCredentials generateCredentials) {
        fieldPassword.sendKeys(generateCredentials.getPassword());
        return this;
    }

    public RegistrationPage typeFieldRepeatPassword(MakeUpCredentials generateCredentials) {
        fieldRepeatPassword.sendKeys(generateCredentials.getPassword());
        return this;
    }

    public AccountPage clickButtonSubmit() {
        buttonSubmit.click();
        return AccountPage.createAccountPage();
    }


}
