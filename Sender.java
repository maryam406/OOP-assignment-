
import java.util.Scanner;

public class Sender {
    public static int countercount = 0;
    public Contacts[][] proContacts;
    public static int index = 0;
    Client c=new Client();
    Server s=new Server();
     
    

    public Sender() {
        proContacts = new Contacts[20][2];
       
        
    }

    public void addcontacts() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Adding the contacts");
        System.out.println("How many contacts u want to add:");
        int num = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < num; i++) {
            System.out.println("Enter the name u want to add:");
            String name = scanner.nextLine();
            System.out.println("Enter the number u want to add:");
            String number = scanner.nextLine();
            System.out.println("Enter the IP of the number:");
            String Ip = scanner.nextLine();
            Contacts contacts = new Contacts(name, number, Ip);
            proContacts[countercount][0] = contacts;
            countercount++;
        }
    }

    public void deletecontact() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Deleting the contact");
        System.out.println("Enter the name of contact u wanted to delete");
        String name = scanner.nextLine();

        for (int i = 0; i < countercount; i++) {
            if (proContacts[i][0].getName().equals(name)) {

                proContacts[i][0] = null;

                System.out.println("The contact has been removed");
                break;
            }
        }

    }

    public void displaycontacts() {
        for (int i = 0; i < countercount; i++) {
            if (proContacts[i][0] != null && proContacts[i][0] != null) {

                System.out.println("Name:" + proContacts[i][0].getName() + "\tNumber:" + proContacts[i][0].getNumber()
                        + "\tIP:" + proContacts[i][0].getIP());
            } else {
                System.out.println("This contact was deleted or is empty.");
            }
        }

    }  
      
    public void sendmessage(){
         Scanner scanner= new Scanner(System.in);
         System.out.println("What u want to be a server or a client:");
         String enter= scanner.nextLine();
         if(enter=="server"){
            s.setupcommunication();
            s.sendmessage();
       }else if(enter=="client"){
          c.setupcommunication();
          c.sendmessage();
       }else{
        System.out.println("Wrong input.Please enter either server or client");
       }

    }
    public void displaymessages(){
        
    }
} 