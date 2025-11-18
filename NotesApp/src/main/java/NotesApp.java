import java.io.*;
import java.util.Scanner;

public class NotesApp {

    private static final String FILE_NAME = "Notes.txt";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n===== NOTES APP =====");
            System.out.println("1. Add Note");
            System.out.println("2. View Notes");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();
            sc.nextLine(); // clear buffer

            switch (choice) {
                case 1:
                    addNote(sc);
                    break;

                case 2:
                    viewNotes();
                    break;

                case 3:
                    System.out.println("Exiting... Goodbye!");
                    return;

                default:
                    System.out.println("Invalid option! Try again.");
            }
        }
    }

    // ✔ Write notes to file
    private static void addNote(Scanner sc) {
        try {
            System.out.print("Enter your note: ");
            String note = sc.nextLine();

            FileWriter fw = new FileWriter(FILE_NAME, true); // append = true
            fw.write(note + "\n");
            fw.close();

            System.out.println("Note saved successfully!");

        } catch (IOException e) {
            System.out.println("Error writing note: " + e.getMessage());
        }
    }

    // ✔ Read notes from file
    private static void viewNotes() {
        try {
            File file = new File(FILE_NAME);
            if (!file.exists()) {
                System.out.println("No notes found!");
                return;
            }

            BufferedReader br = new BufferedReader(new FileReader(FILE_NAME));
            String line;
            System.out.println("\n===== YOUR NOTES =====");
            while ((line = br.readLine()) != null) {
                System.out.println("- " + line);
            }
            br.close();

        } catch (IOException e) {
            System.out.println("Error reading notes: " + e.getMessage());
        }
    }
}
