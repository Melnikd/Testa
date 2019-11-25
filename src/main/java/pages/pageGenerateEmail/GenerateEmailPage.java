package pages.pageGenerateEmail;

import core.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.BasePage;
import utils.SleepUtils;

public class GenerateEmailPage extends BasePage {


    //  driver.get("https://temp-mail.org/ru/");

    @FindBy(xpath = "//input[@id='mail']")
    private WebElement mail;


    @FindBy(xpath = "//button[@id='click-to-delete']")
    private WebElement buttonToDelete;


    @FindBy(xpath = "//a[@id='click-to-refresh']")
    private WebElement buttonToRefresh;

    public GenerateEmailPage() {
        super("https://temp-mail.org/ru/");
    }


    public static GenerateEmailPage createGeneratePage() {

        return new GenerateEmailPage();
    }

    public String getMail() {
        SleepUtils.sleep(5);
        return mail.getAttribute("value");
    }

    public GenerateEmailPage clickButtonToDelete() {
        buttonToDelete.click();
        SleepUtils.sleep(2);
        return this;
    }

    public GenerateEmailPage clickButtonToRefresh() {
        buttonToRefresh.click();
        return this;
    }


}


