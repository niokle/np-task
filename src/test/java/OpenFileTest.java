import org.junit.Assert;
import org.junit.Test;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class OpenFileTest {
    @Test
    public void getFileIfExist() throws FileNotFoundException {
        //given
        File file = new File("test_file");
        PrintWriter pw = new PrintWriter(file);
        pw.println("Adam,Kowalski,1974-09-17,+48123456789");
        pw.println("Bartosz,Nowak,1978-03-12,+48987654321");
        pw.println("Cezary,Tez,1981-06-02,+44123456789");
        pw.println("Adam,Zaorski,1974-09-16,");
        pw.println("Bartosz,Wax,1978-03-11,");
        pw.println("Cezary,Los,1981-06-01,");
        pw.close();
        String path = file.getPath();
        OpenFile openFile = new OpenFile(path);

        //when
        File file2 = openFile.getFile();

        //then
        Assert.assertTrue(file2.exists());

        //cleanup
        file.delete();
    }

    @Test
    public void getFileIfNotExist() throws FileNotFoundException {
        //given
        String path = "";
        OpenFile openFile = new OpenFile(path);

        //when
        File file = openFile.getFile();

        //then
        Assert.assertFalse(file.exists());
    }
}