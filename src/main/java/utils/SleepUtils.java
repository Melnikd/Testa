package utils;

import java.util.concurrent.TimeUnit;

public class SleepUtils {
    public static void sleep(int n) {

        try {
            TimeUnit.SECONDS.sleep(n);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
