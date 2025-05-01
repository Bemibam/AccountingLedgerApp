import java.util.Scanner;

public class Menu {


    private static final Scanner input = new Scanner(System.in);
    private static final EntryProcessor entryProcessor = new EntryProcessor();

    public static void showHome() {
        String option;

        do {
            System.out.println("\n===== Home Menu =====");
            System.out.println("D - Add Deposit");
            System.out.println("P - Make Payment");
            System.out.println("L - View Ledger");
            System.out.println("X - Exit");
            System.out.print("Enter your choice: ");

            option = input.nextLine().trim().toUpperCase();

            switch (option) {
                case "D":
                    entryProcessor.recordEntry(true);  // Deposit
                    break;
                case "P":
                    entryProcessor.recordEntry(false); // Payment
                    break;
                case "L":
                    openLedgerMenu();
                    break;
                case "X":
                    System.out.println("Exiting the app. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid input. Please try again.");
            }

        } while (!option.equals("X"));
    }

    private static void openLedgerMenu() {
        String option;

        do {
            System.out.println("\n----- Ledger Menu -----");
            System.out.println("A - Show All Transactions");
            System.out.println("D - Show Only Deposits");
            System.out.println("P - Show Only Payments");
            System.out.println("R - Reports");
            System.out.println("H - Back to Home");
            System.out.print("Your choice: ");

            option = input.nextLine().trim().toUpperCase();

            switch (option) {
                case "A":
                    entryProcessor.showAll();
                    break;
                case "D":
                    entryProcessor.showFiltered(true);
                    break;
                case "P":
                    entryProcessor.showFiltered(false);
                    break;
                case "R":
                    openReportsMenu();
                    break;
                case "H":
                    System.out.println("Returning to home menu...");
                    break;
                default:
                    System.out.println("Invalid option. Try again.");
            }

        } while (!option.equals("H"));
    }

    private static void openReportsMenu() {
        String option;

        do {
            System.out.println("\n----- Reports Menu -----");
            System.out.println("1 - Month To Date");
            System.out.println("2 - Previous Month (coming soon)");
            System.out.println("3 - Year to Date");
            System.out.println("4 - Previous Year");
            System.out.println("5 - Search by Vendor");
            System.out.println("6 - Custom Search");
            System.out.println("0 - Back to Ledger Menu");
            System.out.println("H - Back to Report Menu");
            System.out.print("Select an option: ");

            option = input.nextLine().trim();

            switch (option) {
                case "1":
                    entryProcessor.showRecentEntries(1);
                    break;
                case "2":
                    entryProcessor.showRecentEntries(2);
                    break;
                case "3":
                    entryProcessor.showRecentEntries(3);
                    break;
                case "4":
                    entryProcessor.showRecentEntries(4);
                    break;
                case "5":
                    entryProcessor.searchByVendor();
                    break;
                case "0":
                    System.out.println("Back to Ledger Menu...");
                    break;
                default:
                    System.out.println("Invalid input. Try again.");
            }

        } while (!option.equals("0"));
    }
}



