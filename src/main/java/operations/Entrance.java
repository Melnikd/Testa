package operations;

import core.DriverManager;
import model.MakeUpCredentials;
import org.openqa.selenium.WebDriver;
import pages.makeUP.AccountPage;
import pages.makeUP.WelcomePage;

public class Entrance {
    public static boolean entrance(MakeUpCredentials credentials) {
        try {
            WelcomePage welcomePage = WelcomePage.createWelcomePage();
            welcomePage.clickButtonCabinet()
                    .typefieldInputLogin(credentials)
                    .typefieldInputPassword(credentials)
                    .clickButtonEntrance();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;


    }
}
