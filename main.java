import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Choose notification type:");
        System.out.println("1. Email");
        System.out.println("2. SMS");
        System.out.print("Enter choice (1 or 2): ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // consume leftover newline

        System.out.print("Enter recipient (email or phone): ");
        String to = scanner.nextLine();

        System.out.print("Enter message: ");
        String message = scanner.nextLine();

        Notifier notifier;

        if (choice == 1) {
            notifier = new EmailNotifier();
        } else if (choice == 2) {
            notifier = new SMSNotifier();
        } else {
            System.out.println("Invalid choice.");
            scanner.close();
            return;
        }

        notifier.send(to, message);
        scanner.close();
    }
}

