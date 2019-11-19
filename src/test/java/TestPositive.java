import model.MakeUpCredentials;
import operations.Entrance;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.ResultReaderUtils;

import java.util.List;

public class TestPositive extends BaseTest {


    @Test(dataProvider = "successCredentials")
    public void happyRename(MakeUpCredentials readCredential) {

        if (Entrance.entrance(readCredential)) {
            System.out.println("With positive data validation passed " + readCredential.getLogin() + "  " + readCredential.getPassword());//
        } else {
            System.out.println("Validation failed with positive data    " + readCredential.getLogin() + "  " + readCredential.getPassword());
        }


    }



    @DataProvider(name = "successCredentials")
    public static Object[] readSuccessCredentials() {
        List<MakeUpCredentials> credentials = ResultReaderUtils.readCredentials("Success.txt");
        return credentials.toArray();
    }



}
