import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReadFile {
    private Scanner scanner;
    private List<String[]> recordsLines = new ArrayList<>();

    public ReadFile(File file) throws FileNotFoundException {
        scanner = new Scanner(file);
        saveRecords();
    }

    public long getNoOfRecords() {
        return recordsLines.size();
    }

    public List<String[]> getRecords() {
        return recordsLines;
    }

    private void saveRecords() {
        while (scanner.hasNextLine()) {
            recordsLines.add(scanner.nextLine().split(","));
        }
    }
}
