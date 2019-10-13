import java.io.File;
import java.io.FileNotFoundException;

public class OpenFile {
    private File file;

    public OpenFile(String filePath) throws FileNotFoundException {
        file = new File(filePath);
    }
    public File getFile() {
        return file;
    }
}
