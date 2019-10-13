import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Logic {
    private ReadFile readFile;

    public Logic(ReadFile readFile) {
        this.readFile = readFile;
    }

    public long getNoOfUsers() {
        return readFile.getNoOfRecords();
    }

    public String getOldestUserWithPhoneNumber() {
        long maxDays = 0;
        long ageYears = 0;
        String[] result = new String[4];
        for (String[] record : readFile.getRecords()) {
            int year = Integer.parseInt(record[2].substring(0, 4));
            int month = Integer.parseInt(record[2].substring(5, 7));
            int day = Integer.parseInt(record[2].substring(8, 10));
            long ageDays = ChronoUnit.DAYS.between(LocalDate.of(year, month, day), LocalDate.now());
            if (ageDays > maxDays && record.length > 3) {
                result = record;
                maxDays = ageDays;
                ageYears = ChronoUnit.YEARS.between(LocalDate.of(year, month, day), LocalDate.now());
            }
        }
        return result[0] + ", " + result[1] + ", " + ageYears + ", " + result[3];
    }
}

