import core.DriverManager;
import model.MakeUpCredentials;
import operations.CreateAccount;
import operations.GenerateEmail;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.makeUP.AccountPage;
import pages.makeUP.WelcomePage;
import utils.GenerateCredentialsUtils;
import utils.ResultReaderUtils;
import utils.ResultWriterUtils;

import java.util.ArrayList;
import java.util.List;

public class BaseTest {


    @BeforeSuite
    public static void beforeSuite() {


        if (ResultReaderUtils.readCredentials("Success.txt").isEmpty()) {

            List<String> logins = GenerateEmail.generateEmail(2);
            List<MakeUpCredentials> makeUpCredentials = GenerateCredentialsUtils.generateCredentials(logins);
            List<MakeUpCredentials> goodCredentials = new ArrayList<>();
            List<MakeUpCredentials> badCredentials = new ArrayList<>();

            for (MakeUpCredentials credentials : makeUpCredentials) {
                if (CreateAccount.toRegister(credentials)) {
                    goodCredentials.add(credentials);
                    System.out.println("Registered : " + credentials);
                } else {
                    System.out.println("NOT registered : " + credentials);
                    badCredentials.add(credentials);
                }
            }
            ResultWriterUtils.writeToFile("Success.txt", goodCredentials);
            ResultWriterUtils.writeToFile("Failed.txt", badCredentials);

        }
        if (ResultReaderUtils.readCredentials("Failed.txt").isEmpty()) {

            List<String> logins = GenerateEmail.generateEmail(2);
            List<MakeUpCredentials> makeUpCredentials = GenerateCredentialsUtils.generateCredentials(logins);
            List<MakeUpCredentials> badCredentials = new ArrayList<>();

            for (MakeUpCredentials credentials : makeUpCredentials) {
                String wrong = credentials.getLogin() + "@1";

                System.out.println("NOT registered : " + credentials);
                badCredentials.add(new MakeUpCredentials(wrong, credentials.getPassword(), credentials.getPhoneNumber()));
            }
            ResultWriterUtils.writeToFile("Failed.txt", badCredentials);

        }
    }

    @AfterMethod
    public static void afterTest() throws InterruptedException {

        WelcomePage welcomePage = WelcomePage.createWelcomePage();
        if (welcomePage.findButtonCabinetEntrance()) {
            welcomePage.logOut();
        }

    }

    @AfterSuite
    public static void afterTests() {
        DriverManager.quitDriver();
    }
}
