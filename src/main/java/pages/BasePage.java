package pages;

import core.DriverManager;
import org.openqa.selenium.support.PageFactory;


public class BasePage {

    public BasePage(String url) {
        DriverManager.getDriver().get(url);
        PageFactory.initElements(DriverManager.getDriver(), this);

    }
}
