import model.MakeUpCredentials;
import operations.Entrance;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.ResultReaderUtils;

import java.util.List;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class TestPositive extends BaseTest {


    @Test(dataProvider = "successCredentials")
    public void happyRename(MakeUpCredentials readCredential) {

        assertTrue(Entrance.entrance(readCredential), "With positive data validation passed    " + readCredential.getLogin() + "  " + readCredential.getPassword());
        //assertFalse(Entrance.entrance(readCredential),"Validation failed with positive data    " + readCredential.getLogin() + "  " + readCredential.getPassword());
//        if (Entrance.entrance(readCredential)) {
//            System.out.println("With positive data validation passed " + readCredential.getLogin() + "  " + readCredential.getPassword());//
//        } else {
//            System.out.println("Validation failed with positive data    " + readCredential.getLogin() + "  " + readCredential.getPassword());
//        }
//

    }


    @DataProvider(name = "successCredentials")
    public static Object[] readSuccessCredentials() {
        List<MakeUpCredentials> credentials = ResultReaderUtils.readCredentials("Success.txt");
        return credentials.toArray();
    }



}
