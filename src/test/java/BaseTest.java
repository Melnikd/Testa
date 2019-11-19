import core.DriverManager;
import model.MakeUpCredentials;
import operations.CreateAccount;
import operations.GenerateEmail;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import pages.makeUP.AccountPage;
import utils.GenerateCredentialsUtils;
import utils.ResultReaderUtils;
import utils.ResultWriterUtils;

import java.util.ArrayList;
import java.util.List;

public class BaseTest {


    @BeforeSuite
    public static void beforeTastes() {
        List<String> logins = GenerateEmail.generateEmail(2);
        List<MakeUpCredentials> makeUpCredentials = GenerateCredentialsUtils.generateCredentials(logins);
        List<MakeUpCredentials> goodCredentials = new ArrayList<>();
        List<MakeUpCredentials> badCredentials = new ArrayList<>();

        if (ResultReaderUtils.readCredentials("Success.txt").isEmpty()) {


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
            for (MakeUpCredentials credentials : makeUpCredentials) {

                String wrong = credentials.getLogin() + "@1";

                System.out.println("NOT registered : " + credentials);
                badCredentials.add(new MakeUpCredentials(wrong,credentials.getPassword(),credentials.getPhoneNumber()));
            }
            ResultWriterUtils.writeToFile("Failed.txt", badCredentials);

        }
    }

    @AfterSuite
    public static void afterTests() {
        DriverManager.quitDriver();
    }
}
