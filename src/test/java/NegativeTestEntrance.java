import model.MakeUpCredentials;
import operations.Entrance;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.ResultReaderUtils;

import java.util.List;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class NegativeTestEntrance extends BaseTest {
    @Test(dataProvider = "unsuccessfulCredentials")
    public void sadRename(MakeUpCredentials readCredential) {
        //assertTrue((Entrance.entrance(readCredential)),"With negative data validation passed  " + readCredential);
        assertFalse((Entrance.entrance(readCredential)),"Validation failed with negative data  " + readCredential);
//        if (Entrance.entrance(readCredential)) {
//            System.out.println("With negative data validation passed  " + readCredential);
//        } else {
//            System.out.println("Validation failed with negative data  " + readCredential);
//        }

    }
    @DataProvider(name = "unsuccessfulCredentials")
    public static Object[] readUnsuccessfulCredentials() {
        List<MakeUpCredentials> credentials = ResultReaderUtils.readCredentials("Failed.txt");
        return credentials.toArray();
    }
}
