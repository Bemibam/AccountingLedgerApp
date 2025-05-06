📘✨ 𝐅𝐢𝐫𝐬𝐭 𝐂𝐚𝐩𝐬𝐭𝐨𝐧𝐞 𝐏𝐫𝐨𝐣𝐞𝐜𝐭 ✨📘
💰 𝐀𝐜𝐜𝐨𝐮𝐧𝐭𝐢𝐧𝐠 𝐋𝐞𝐝𝐠𝐞𝐫 𝐀𝐩𝐩 💼
📊 Track deposits, payments, and run reports with a clean, user-friendly Java CLI interface ☕


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
<img width="1113" alt="Screenshot 2025-05-05 at 10 38 56 PM" src="https://github.com/user-attachments/assets/2f2df9e6-c1ca-449f-87ee-ff18ead5106c" />
<img width="1097" alt="Screenshot 2025-05-05 at 10 39 30 PM" src="https://github.com/user-attachments/assets/7c12e76e-fd47-46b0-bebf-55646f24405d" />
<img width="1083" alt="Screenshot 2025-05-05 at 10 40 09 PM" src="https://github.com/user-attachments/assets/73653d72-ea65-4dd3-a964-d4debd17fc0c" />
<img width="1103" alt="Screenshot 2025-05-05 at 10 40 29 PM" src="https://github.com/user-attachments/assets/65b0a3c3-f88b-4416-9ba9-7f87f32e81e1" />
<img width="1124" alt="Screenshot 2025-05-05 at 10 41 02 PM" src="https://github.com/user-attachments/assets/eb5282c0-bbb7-4479-b45d-7e006823da77" />
<img width="1104" alt="Screenshot 2025-05-05 at 10 41 34 PM" src="https://github.com/user-attachments/assets/0d674453-051f-47f5-b607-7ef073eb1265" />














