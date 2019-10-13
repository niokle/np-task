import java.io.FileNotFoundException;

public class Run {
    public static void main(String[] args) throws FileNotFoundException {
        String path = Run.class.getResource("input.txt").getPath();
        OpenFile openFile = new OpenFile(path);
        ReadFile readFile = new ReadFile(openFile.getFile());
        Logic logic = new Logic(readFile);
        System.out.println("Ilość użytkowników: " + logic.getNoOfUsers());
        System.out.println("Użytkownik: " + logic.getOldestUserWithPhoneNumber());
    }
}
