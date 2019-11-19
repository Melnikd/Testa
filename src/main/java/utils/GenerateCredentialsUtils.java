package utils;

import model.MakeUpCredentials;
import operations.GenerateEmail;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static core.DriverManager.getDriver;

public class GenerateCredentialsUtils {
    private static final Random RND = new Random();

    public static List<MakeUpCredentials> generateCredentials(List<String> logins) {

        List<MakeUpCredentials> result = new ArrayList<>();
        for (String login : logins) {
            MakeUpCredentials credentials = new MakeUpCredentials(login,
                    GenerateCredentialsUtils.createRandomPassword(8),
                    GenerateCredentialsUtils.generateRandomMobilePhone());
            result.add(credentials);
            System.out.println("Object created : " + credentials.toString());
        }
        return result;

    }


    private static String createRandomPassword(int n) {
        int num_of_chars = n;
        Integer a;
        String num = "";
        for (int i = 0; i < num_of_chars; i++) {
            a = RND.nextInt(10);
            num += a;
        }

        return num;
    }

    private static String generateRandomMobilePhone() {
        return "99" + createRandomPassword(7);

    }


}
