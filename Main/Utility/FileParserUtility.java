package Main.Utility;

/*
 *  Creation Date: 12/10/2020
 *  Purpose: Utility class for parsing files (will act as the helper to get information from our database)
 * 
 */

/* External Imports */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/* Internal Imports */

public class FileParserUtility {
    
    /* Static/Final Members */
    private String COMMA_DELIMITER = ",";

    /* Data Members */

    /* Constructors */

    /* Accessor Methods */

    /* Mutator Methods */

    /* Logic Methods */

    /* Static Methods */

    public List<String> getLines(String filename) {
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

    // https://www.baeldung.com/java-csv
    public String convertToCSV(String[] data) {
        return Stream.of(data)
          .map(this::escapeSpecialCharacters)
          .collect(Collectors.joining(","));
    }

    public void givenDataArray_whenConvertToCSV_thenOutputCreated(List<String[]> dataLines, String csvFilename) throws IOException {
        File csvOutputFile = new File(csvFilename);
        try (PrintWriter pw = new PrintWriter(csvOutputFile)) {
            dataLines.stream()
              .map(this::convertToCSV)
              .forEach(pw::println);
        }
        assert(csvOutputFile.exists());
    }

    public String escapeSpecialCharacters(String data) {
        String escapedData = data.replaceAll("\\R", " ");
        if (data.contains(",") || data.contains("\"") || data.contains("'")) {
            data = data.replace("\"", "\"\"");
            escapedData = "\"" + data + "\"";
        }
        return escapedData;
    }

}
