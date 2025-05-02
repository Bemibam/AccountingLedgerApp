Accounting Ledger App
This is a simple and user-friendly command-line application built with Java. It helps you keep track of your finances by letting you record deposits, payments, and other transactions. Everything is saved in a file called transactions.csv, so you don’t lose data.

 What It’s Made With
Java (core language)

BufferedReader/Writer for reading and writing to files

LocalDate and LocalTime for automatic timestamps

Switch expressions for clean and easy-to-read menus

CSV format to store your transactions



Key Features:

✔️ Add Transactions
Quickly add a deposit or a payment with a description, vendor, and amount.

✔️ Ledger View
See all your past transactions — the newest at the top.

✔️ Filter Options
Only want to see deposits? Or just payments? Easy.

✔️ Reports
Generate helpful summaries:

Month-To-Date

Previous Month

Year-To-Date

Previous Year

Search by Vendor

Custom Search: Choose any combination of date, vendor, description, or amount.

✔️ Data Persistence
All entries are saved to a file called transactions.csv, so your data is never lost between runs.


💡 Interesting Code That Made Things Easier
Instead of using long if-else chains or traditional switch-case blocks, I used arrow-based switch expressions, which are cleaner and easier to read:
switch (option) {
    case "D" -> entryProcessor.recordEntry(true);
    case "P" -> entryProcessor.recordEntry(false);
}





=====================================================================================================================================================
ScreenShot Added
<img width="1350" alt="Screenshot 2025-05-01 at 4 38 29 PM" src="https://github.com/user-attachments/assets/72c44acc-db04-4f3b-b782-a17679e9be9a" />
<img width="1340" alt="Screenshot 2025-05-01 at 4 39 34 PM" src="https://github.com/user-attachments/assets/01573d8a-cbc2-4f6c-b6d1-42c2f5b8af67" />
<img width="1146" alt="Screenshot 2025-05-01 at 4 39 11 PM" src="https://github.com/user-attachments/assets/a0bd571f-2e98-44c9-a78f-f1852f253040" />
<img width="1298" alt="Screenshot 2025-05-01 at 4 48 24 PM" src="https://github.com/user-attachments/assets/0af0e644-50a6-4dd0-8a3f-01977340781a" />





