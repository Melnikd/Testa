package pages.makeUP;

import core.DriverManager;
import model.MakeUpCredentials;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WelcomePage {
    /**
     * <summary>page for text<summary>
     */



    @FindBy(xpath = "//input[@name='user_login']")
    private WebElement fieldInputLogin;

    @FindBy(xpath = "//input[@name='user_pw']")
    private WebElement fieldInputPassword;


    @FindBy(xpath = "//div[@data-popup-handler='auth']")
    private WebElement buttonCabinet;


    @FindBy(xpath = "//a[@href='/register/']")
    private WebElement buttonRegistration;

    public static WelcomePage createWelcomePage() {
        DriverManager.getDriver().get("https://makeup.com.ua/");
        WelcomePage welcomePage = PageFactory.initElements(DriverManager.getDriver(), WelcomePage.class);
        return welcomePage;
    }

    public WelcomePage typefieldInputLogin(MakeUpCredentials credentials){
        fieldInputLogin.sendKeys(credentials.getLogin());
        return this;
    }

    public WelcomePage typefieldInputPassword(MakeUpCredentials credentials){
        fieldInputPassword.sendKeys(credentials.getPassword());
        return this;
    }


    public WelcomePage clickButtonCabinet() {
        buttonCabinet.click();
        return this;
    }

    public RegistrationPage clickButtonRegistration() {
        buttonRegistration.click();
        return RegistrationPage.createRegistrationPage();
    }


}
