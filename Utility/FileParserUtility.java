package Main.Utility;

/*
 *  Creation Date: 12/10/2020
 *  Purpose: Utility class for parsing files (will act as the helper to get information from our database)
 * 
 */

/* External Imports */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/* Internal Imports */
import Main.Records.RecordEntry;

public class FileParserUtility {
    
    /* Static/Final Members */
    private String COMMA_DELIMITER = ",";

    /* Data Members */

    /* Constructors */

    /* Accessor Methods */

    /* Mutator Methods */

    /* Logic Methods */

    /* Static Methods */

    public static List<String> getLines(String filename) {
        List<String> records = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {                
                records.add(line);
            }
        } catch (IOException ioe) {
            System.out.println("Couldn\'t open file: " + filename);
        }
        return records;
    }

    public static void writeLine(RecordEntry recordEntry, String filename, boolean append) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename, append))) {
            bw.write(RecordEntry.convertToString(recordEntry));
            bw.newLine();
        } catch(IOException ioe) {
            System.out.println("Failed to open the file!");
        }
    }

    // https://www.baeldung.com/java-csv
    public static String convertToCSV(String[] data) {
        return Stream.of(data)
          .map(FileParserUtility::escapeSpecialCharacters)
          .collect(Collectors.joining(","));
    }

    public static void generateCSVFromData(List<String[]> dataLines, String csvFilename) throws IOException {
        File csvOutputFile = new File(csvFilename);
        try (PrintWriter pw = new PrintWriter(csvOutputFile)) {
            dataLines.stream()
              .map(FileParserUtility::convertToCSV)
              .forEach(pw::println);
        }
        assert(csvOutputFile.exists());
    }

    public static String escapeSpecialCharacters(String data) {
        String escapedData = data.replaceAll("\\R", " ");
        if (data.contains(",") || data.contains("\"") || data.contains("'")) {
            data = data.replace("\"", "\"\"");
            escapedData = "\"" + data + "\"";
        }
        return escapedData;
    }

}
