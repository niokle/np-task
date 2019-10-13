import org.junit.Assert;
import org.junit.Test;
import java.io.*;
import java.util.List;

public class ReadFileTest {

    @Test
    public void getNoOfRecords() throws FileNotFoundException {
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
        ReadFile readFile = new ReadFile(file);

        //when
        long noOfRecords = readFile.getNoOfRecords();

        //then
        Assert.assertEquals(6, noOfRecords);

        //cleanup
        file.delete();
    }

    @Test
    public void getRecords() throws FileNotFoundException {
        //given
        File file = new File("test_file");
        PrintWriter pw = new PrintWriter(file);
        pw.println("Adam,Kowalski,1974-09-17,+48123456789");
        pw.close();
        ReadFile readFile = new ReadFile(file);

        //when
        List<String[]> recordsList = readFile.getRecords();

        //then
        Assert.assertEquals(1, recordsList.size());
        Assert.assertEquals("Adam", recordsList.get(0)[0]);
        Assert.assertEquals("Kowalski", recordsList.get(0)[1]);
        Assert.assertEquals("1974-09-17", recordsList.get(0)[2]);
        Assert.assertEquals("+48123456789", recordsList.get(0)[3]);

        //cleanup
        file.delete();
    }
}