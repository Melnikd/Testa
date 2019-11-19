//import model.MakeUpCredentials;
//import operations.GenerateEmail;
//import pages.makeUP.AccountPage;
//import pages.makeUP.RegistrationPage;
//import pages.makeUP.WelcomePage;
//import core.DriverManager;
//import org.openqa.selenium.WebDriver;
//import utils.ResultWriterUtils;
//import utils.ResultReaderUtils;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import static utils.GenerateCredentialsUtils.generateCredentials;
//
//public class Main {
//    public static void main(String[] args) {
//
//
//
////        List<String> list = GenerateLogin.generateLogin(driver, 3);
////        for (String s : list) {
////            System.out.println(s);
////
////        }
//
//        //  List<MakeUpCredentials> makeUpCredentials = GenerateLogin.generateLogin(driver,2);
//
//        List<String> logins = GenerateEmail.generateEmail( 2);
//
//        List<MakeUpCredentials> makeUpCredentials = generateCredentials(logins);
//
//        for (MakeUpCredentials generateCredential : makeUpCredentials) {
//            System.out.println("Object created : " + generateCredential.toString());
//        }
//
//        List<MakeUpCredentials> goodCredentials = new ArrayList<>();
//        List<MakeUpCredentials> badCredentials = new ArrayList<>();
//
//
//        for (MakeUpCredentials credentials : makeUpCredentials) {
//            if (test(credentials)) {
//                goodCredentials.add(credentials);
//                System.out.println("Registered : " + credentials);
//            } else {
//                System.out.println("NOT registered : " + credentials);
//                badCredentials.add(credentials);
//            }
//        }
//        ResultWriterUtils.writeToFile("Success.txt", goodCredentials);
//        ResultWriterUtils.writeToFile("Failed.txt", badCredentials);
//
//        for (MakeUpCredentials readCredential : ResultReaderUtils.readCredentials("Success.txt")) {
//            if (entrance(readCredential)) {
//                System.out.println("With positive data validation passed  " + readCredential.getLogin() + "  " + readCredential.getPassword());//
//            } else {
//                System.out.println("Validation failed with positive data  " + readCredential.getLogin() + "  " + readCredential.getPassword());
//            }
//        }
//
//
//        DriverManager.quitDriver();
//    }
//
//    public static boolean test(MakeUpCredentials generateCredentials) {
//        WebDriver driver = DriverManager.getDriver();
//
//        WelcomePage welcomePage = WelcomePage.createWelcomePage();
//        RegistrationPage registrationPage;
//        AccountPage accountPage;
//        welcomePage.clickButtonCabinet();
//        registrationPage = welcomePage.clickButtonRegistration();
//        registrationPage.typeFieldname()
//                .typeFieldLastName()
//                .typeFieldEmail(generateCredentials)
//                .clickFieldPhone()
//                .typeFieldPhone(generateCredentials)
//                .typeFieldCity()
//                .clickFieldCitySpecifically()
//                .typeFieldStreet()
//                .clickFieldStreetSpecifically()
//                .typeFieldHouse()
//                .typeFieldPassword(generateCredentials)
//                .typeFieldRepeatPassword(generateCredentials);
//        accountPage = registrationPage.clickButtonSubmit();
//        accountPage.clickFieldCabinet()
//                .clickFieldlogout();
//        return true;
//    }
//
//    public static boolean entrance(MakeUpCredentials credentials) {
//        WebDriver driver = DriverManager.getDriver();
//        WelcomePage welcomePage = WelcomePage.createWelcomePage();
//        AccountPage accountPage;
//        welcomePage.clickButtonCabinet()
//                .typefieldInputLogin(credentials)
//                .typefieldInputPassword(credentials)
//                .clickButtonCabinet();
//        return true;
//
//
//    }
//
//
//}
