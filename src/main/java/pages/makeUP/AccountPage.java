package pages.makeUP;

import core.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPage {


    @FindBy(xpath = "//a[@href='/user/']")
    private WebElement fieldCabinet;

    @FindBy(xpath = "//a[@href='/user/logout/']")
    private WebElement fieldlogout;

    public static AccountPage createAccounrPage() {
        return PageFactory.initElements(DriverManager.getDriver(), AccountPage.class);
    }


    public AccountPage clickFieldCabinet() {
        fieldCabinet.click();
        return this;
    }

    public WelcomePage clickFieldlogout() {
        fieldlogout.click();
        return  WelcomePage.createWelcomePage();
    }

}
