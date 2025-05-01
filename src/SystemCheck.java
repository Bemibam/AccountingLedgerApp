import java.time.LocalDate;

public class SystemCheck {
    public static void main(String[] args) {
        // Check current date and beginning of the month
        LocalDate now = LocalDate.now();
        LocalDate monthStart = now.minusDays(now.getDayOfMonth() - 1);

        System.out.println("Current date: " + now);
        System.out.println("Month start: " + monthStart);

        long todayEpoch = now.toEpochDay();
        long startEpoch = monthStart.toEpochDay();

        System.out.println("Epoch for today: " + todayEpoch);
        System.out.println("Epoch for month start: " + startEpoch);
    }
}

