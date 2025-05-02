import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class EntryProcessor {


    private final Scanner input = new Scanner(System.in);
    private final String FILE = "transactions.csv";

    // Handles both deposits and payments
    public void recordEntry(boolean isDeposit) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE, true))) {
            String option;

            do {
                // Get today's date and time
                String date = LocalDate.now().toString();
                String time = LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));

                System.out.println("\n--- " + (isDeposit ? "Add Deposit" : "Make Payment") + " ---");
                System.out.print("Description: ");
                String description = input.nextLine().trim();

                System.out.print("Vendor: ");
                String vendor = input.nextLine().trim();

                System.out.print("Amount: ");
                double amount = input.nextDouble();
                input.nextLine(); // clear buffer
                if (!isDeposit) {
                    amount *= -1;
                }

                // Create and save transaction
                String line = String.format("%s|%s|%s|%s|%.2f\n", date, time, description, vendor, amount);
                writer.write(line);
                writer.flush();

                System.out.print("\nAdd another? (X to return, anything else to continue): ");
                option = input.nextLine().trim().toUpperCase();

            } while (!option.equals("X"));

        } catch (IOException e) {
            System.out.println(" Couldn't write to file: " + e.getMessage());
        }
    }

    // Shows all transactions
    public void showAll() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("️ Couldn't read file: " + e.getMessage());
        }
    }

    // Shows only deposits or only payments
    public void showFiltered(boolean showDeposits) {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE))) {
            String line;
            reader.readLine();// Used to skip the header
            while ((line = reader.readLine()) != null) {
                if (line.isBlank()) continue;
                String[] parts = line.split("\\|");
                double amount = Double.parseDouble(parts[4]);

                if ((showDeposits && amount > 0) || (!showDeposits && amount < 0)) {
                    System.out.println(line);
                }
            }
        } catch (IOException e) {
            System.out.println(" Couldn't read file: " + e.getMessage());
        }
    }

    // Simple version of date-based reporting
    public void showRecentEntries(int reportType) {
        LocalDate today = LocalDate.now();

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE))) {
            String line;
            reader.readLine();
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\|");
                if (parts.length < 5) continue;

                LocalDate entryDate = LocalDate.parse(parts[0]);

                switch (reportType) {
                    case 1 -> {
                        // Month to date
                        if (entryDate.getMonth() == today.getMonth() && entryDate.getYear() == today.getYear()) {
                            System.out.println(line);
                        }
                    }
                    case 2 -> {

                        LocalDate previousMonth = today.minusMonths(1);

                        if (entryDate.getMonth() == previousMonth.getMonth() && entryDate.getYear() == previousMonth.getYear()) {
                            System.out.println(line);
                        }
                    }

                    // Placeholder for previous month
                    // System.out.println(" Previous month report not added yet.");
                    case 3 -> {
                        LocalDate janFirst = today.withDayOfYear(1);
                        if ((entryDate.isEqual(janFirst) || entryDate.isAfter(janFirst)) &&
                                entryDate.isBefore(today.plusDays(1))) {
                            System.out.println(line);
                        }
                    }

                    case 4 -> {
                        // 4) Previous Year
                        int lastYear = today.getYear() - 1;
                        if (entryDate.getYear() == lastYear) {
                            System.out.println(line);
                        }
                    }
                    default -> System.out.println(" Unknown report type.");
                }
            }

        } catch (IOException e) {
            System.out.println("️ Couldn't load transactions: " + e.getMessage());
        }
    }

    // 5) Search by Vendor
    public void searchByVendor() {
        System.out.print("Enter vendor name to search: ");
        String vendorSearch = input.nextLine().trim().toLowerCase();

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE))) {
            String line;
            reader.readLine(); // Skip header

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\|");
                if (parts.length >= 5 && parts[3].toLowerCase().contains(vendorSearch)) {
                    System.out.println(line);
                }
            }

        } catch (IOException e) {
            System.out.println("Error reading transactions: " + e.getMessage());
        }
    }

    // 6) Custom Search – lets the user filter by any field
    public void customSearch() {
        System.out.println("\n--- Custom Search ---");

        // Prompt user for optional filter values
        System.out.print("Start Date (yyyy-mm-dd): ");
        String start = input.nextLine().trim();
        System.out.print("End Date (yyyy-mm-dd): ");
        String end = input.nextLine().trim();
        System.out.print("Description: ");
        String desc = input.nextLine().trim().toLowerCase();
        System.out.print("Vendor: ");
        String vendor = input.nextLine().trim().toLowerCase();
        System.out.print("Amount: ");
        String amt = input.nextLine().trim();

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE))) {
            reader.readLine(); // Skip header
            String line;

            while ((line = reader.readLine()) != null) {
                String[] p = line.split("\\|"); // p = parts
                if (p.length < 5) continue;

                // Grab and normalize values
                LocalDate date = LocalDate.parse(p[0]);
                String d = p[2].toLowerCase();
                String v = p[3].toLowerCase();
                double a = Double.parseDouble(p[4]);

                boolean input = true;

                // Apply filters only if input was provided
                if (!start.isEmpty() && date.isBefore(LocalDate.parse(start))) input = false;
                if (!end.isEmpty() && date.isAfter(LocalDate.parse(end))) input = false;
                if (!desc.isEmpty() && !d.contains(desc)) input = false;
                if (!vendor.isEmpty() && !v.contains(vendor)) input = false;
                if (!amt.isEmpty()) {
                    try {
                        if (a != Double.parseDouble(amt)) input = false;
                    } catch (NumberFormatException e) {
                        input = false;
                    }
                }

                // Show result if all conditions match
                if (input) System.out.println(line);
            }

        } catch (IOException e) {
            System.out.println("Error reading transactions: " + e.getMessage());
        }
    }
}