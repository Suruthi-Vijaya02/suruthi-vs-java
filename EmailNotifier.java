public class EmailNotifier implements Notifier {
     public void send(String to, String message) {
        System.out.println("Sending Email to " + to + " with message: " + message);
    }
}
