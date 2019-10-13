import org.junit.Assert;
import org.junit.Test;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class LogicTest {

    @Test
    public void getNoOfUsers() throws FileNotFoundException {
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
        Logic logic = new Logic(readFile);

        //when
        long noOfUsers = logic.getNoOfUsers();

        //then
        Assert.assertEquals(6, noOfUsers);

        //cleanup
        file.delete();
    }

    @Test
    public void getOldestUserWithPhoneNumber() throws FileNotFoundException {
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
        Logic logic = new Logic(readFile);

        //when
        String oldestUserWithPhoneNumber = logic.getOldestUserWithPhoneNumber();

        //then
        Assert.assertEquals("Adam, Kowalski, 45, +48123456789", oldestUserWithPhoneNumber);

        //cleanup
        file.delete();
    }
}