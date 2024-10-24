import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CopyContent {
    public static void main(String[] args) {
        System.out.println(getCopyContent("File.txt","FileCopy.txt"));
        System.out.println(getCopyContent("nonExistentFile.txt","FileCopy.txt"));
        System.out.println(getCopyContent("File.txt","<.txt"));
    }

    public static String getCopyContent(String inputFileName, String outputFileName) {
        try {
            FileReader reader = new FileReader(inputFileName);
            FileWriter writer = new FileWriter(outputFileName); 
            int i;
            while ((i = reader.read()) != -1) {
                writer.write((char)i);
            }
            reader.close();
            writer.close();
            return("Successfully written");
        } catch (FileNotFoundException e1) {
            return(e1.getMessage());
        } catch (IOException e2) {
            return(e2.getMessage());
        } 
    }
}
