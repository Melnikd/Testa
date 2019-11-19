package operations;

import org.openqa.selenium.WebDriver;
import pages.pageGenerateEmail.GenerateEmailPage;

import java.util.ArrayList;
import java.util.List;

public class GenerateEmail {

    public static List<String> generateEmail( int numberOfUsers) {
        GenerateEmailPage generatePage = GenerateEmailPage.createGeneratePage();
        List<String> list = new ArrayList<String>();


        for (int i = 0; i < numberOfUsers; i++) {
            list.add(generatePage.getMail());
            generatePage.clickButtonToDelete()
                    .clickButtonToRefresh();

        }
        return list;


    }
}


