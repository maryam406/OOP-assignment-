import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {

        Sender send = new Sender();
    
        Scanner scanner = new Scanner(System.in);
        String choice;
        boolean running = true;
        do {
            System.out.println("Menu");
            System.out.println("Choose the function u want to do");
            System.out.println("1.Add to Contacts");
            System.out.println("2.Display Contacts");
            System.out.println("3.Delete a contact");
            System.out.println("4.Send message");
            System.out.println("5.Displaying Sendmessages");
            System.out.println("6.Displaying Recieved messages");
            System.out.println("7.Display all messages");
            System.out.println("8.Display messages in arranged way ");
            System.out.println("9.Delete your message");
            System.out.println("10.Exit the program");
            System.out.println("Enter the number of your function u want to do(1-10):");
            choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.println("You selected to add to contacts.");
                    send.addcontacts();
                    break;
                case "2":
                    System.out.println("You selected to display contacts.");
                    send.displaycontacts();
                    break;

                case "3":
                    System.out.println("You selected to delete contacts.");
                    send.deletecontact();
                    break;
                case "4":
                    System.out.println("Sending message");
                    c.setupcommunication();
                    c.sendmessage();
                    break;
                
                case "5":
                    System.out.println("Displaying messages send by u ");
                    c.Displaymessagessend();
                    break;
                
                case "6":
                    System.out.println("Printing messages recieved by u");
                    c.Displayrecievemessages();
                    break;
                case "7":
                    System.out.println("You have selected to display all messages");
                    c.DisplayAllmessages();
                    break;
                case"8":
                   System.out.println("You have selected to display the messages in a sorted way");
                   c.arraysort();
                   break;
                case "9":
                System.out.println("You selected to delete message");
                c.deletemessage();
               break;

                case "10":
                    System.out.println("Exiting the program");
                    running = false;
                    break;

                default:
                    System.out.println("Invalid choice! Please select a number between 1 and 7.");
            }

        } while (running);
        scanner.close();
    }

}
