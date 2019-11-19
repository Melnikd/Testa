package operations;

import core.DriverManager;
import model.MakeUpCredentials;
import org.openqa.selenium.WebDriver;
import pages.makeUP.AccountPage;
import pages.makeUP.RegistrationPage;
import pages.makeUP.WelcomePage;
import utils.GenerateCredentialsUtils;
import utils.ResultWriterUtils;

import java.util.ArrayList;
import java.util.List;

public class CreateAccount {


    public static boolean toRegister(MakeUpCredentials generateCredentials) {

        try {
            WelcomePage welcomePage = WelcomePage.createWelcomePage();
            RegistrationPage registrationPage;
            AccountPage accountPage;
            welcomePage.clickButtonCabinet();
            registrationPage = welcomePage.clickButtonRegistration();
            registrationPage.typeFieldname()
                    .typeFieldLastName()
                    .typeFieldEmail(generateCredentials)
                    .clickFieldPhone()
                    .typeFieldPhone(generateCredentials)
                    .typeFieldCity()
                    .clickFieldCitySpecifically()
                    .typeFieldStreet()
                    .clickFieldStreetSpecifically()
                    .typeFieldHouse()
                    .typeFieldPassword(generateCredentials)
                    .typeFieldRepeatPassword(generateCredentials);
            accountPage = registrationPage.clickButtonSubmit();
            accountPage.clickFieldCabinet()
                    .clickFieldlogout();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }


}