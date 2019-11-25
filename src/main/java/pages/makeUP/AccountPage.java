package pages.makeUP;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

public class AccountPage extends BasePage {


    @FindBy(xpath = "//a[@href='/user/']")
    private WebElement fieldCabinet;

    @FindBy(xpath = "//a[@href='/user/logout/']")
    private WebElement fieldlogout;

    public AccountPage() {
        super("//makeup.com.ua/user/");
    }

    public static AccountPage createAccounrPage() {
        return new AccountPage();
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
