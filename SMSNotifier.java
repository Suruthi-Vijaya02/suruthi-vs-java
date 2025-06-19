public class SMSNotifier implements Notifier {
    public void send(String to, String message) {
        System.out.println("Sending SMS to " + to + " with message: " + message);
    }
    
}
