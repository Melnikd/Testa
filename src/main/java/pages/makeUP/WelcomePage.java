package pages.makeUP;

import model.MakeUpCredentials;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

public class WelcomePage extends BasePage {
    /**
     * <summary>page for text<summary>
     */


    @FindBy(xpath = "//input[@name='user_login']")
    private WebElement fieldInputLogin;

    @FindBy(xpath = "//input[@name='user_pw']")
    private WebElement fieldInputPassword;


    @FindBy(xpath = "//a[@href='/user/']")
    private WebElement buttonCabinetEntrance;

    @FindBy(xpath = "//div[@data-popup-handler='auth']")
    private WebElement buttonCabinet;


    @FindBy(xpath = "//a[@href='/register/']")
    private WebElement buttonRegistration;

    // @FindBy(xpath = "//button[@type='submit']")
    @FindBy(xpath = "//*[contains(text(), 'Войти')]")
    private WebElement buttonEntrance;

    private WelcomePage() {
        super("https://makeup.com.ua/");
    }
    // <button type="submit" formnovalidate="" class="button full-width">Войти</button>

    public static WelcomePage createWelcomePage() {

        return new WelcomePage();
    }

    public WelcomePage typefieldInputLogin(MakeUpCredentials credentials) {
        fieldInputLogin.sendKeys(credentials.getLogin());
        return this;
    }

    public WelcomePage typefieldInputPassword(MakeUpCredentials credentials) {
        fieldInputPassword.sendKeys(credentials.getPassword());
        return this;
    }


    public WelcomePage clickButtonCabinet() {
        buttonCabinet.click();
        return this;
    }

    public AccountPage clickButtonEntrance() {
        buttonEntrance.click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return AccountPage.createAccountPage();
    }

    public AccountPage clickButtonCabinetEntrance() {
        buttonCabinetEntrance.click();
        return AccountPage.createAccountPage();
    }

    public RegistrationPage clickButtonRegistration() {
        buttonRegistration.click();
        return RegistrationPage.createRegistrationPage();
    }

    public boolean logOut() {

        WelcomePage welcomePage = new WelcomePage();
        welcomePage.clickButtonCabinetEntrance()
                .clickFieldCabinet()
                .clickFieldlogout();
        return true;

    }

    public boolean findButtonCabinetEntrance() {
        try {
            buttonCabinetEntrance.isDisplayed();
            return true;
        } catch (Exception ex) {
            return false;
        }

    }


}
