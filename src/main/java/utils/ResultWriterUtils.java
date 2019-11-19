package utils;

import model.MakeUpCredentials;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class ResultWriterUtils {
    public static void writeToFile(String fileName, List<MakeUpCredentials> result) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName,true))) {
            for (MakeUpCredentials makeUpCredentials : result) {
                writer.write(makeUpCredentials.toString());
                writer.newLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}