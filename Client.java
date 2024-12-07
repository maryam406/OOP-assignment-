import java.io.*;
import java.net.*;
import java.util.Arrays;
import java.util.Scanner;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Client {
    String name;
    public Message[] messages;
    public Reciever[] recieve;
    private static final int Server_PORT = 1098;
    private static final String SERVER_IP = "10.135.17.76";
    private Socket socket;
    private DataInputStream input;
    private DataOutputStream output;
    public static int index = 0;
    public static int serial = 0;
    public static int id=0;

            public Client() {
                messages = new Message[20];
                recieve=new Reciever[20];  }

            public void setupcommunication(){
                try {
                    socket = new Socket(SERVER_IP, Server_PORT);
                    System.out.println("Connected to Server");
                    input = new DataInputStream(socket.getInputStream());
                    output = new DataOutputStream(socket.getOutputStream());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            

           public void sendmessage(){
            try{
            while(true){
                Scanner sc=new Scanner(System.in);
                System.out.println("Enter the message u want to send:");
                String clientmessage = sc.nextLine();
                output.writeUTF(clientmessage);
                output.flush();
                if (clientmessage.equalsIgnoreCase("bye")) {
                    break; // Exit if the user types "bye"
                }
                if(index<messages.length){
                    Message m=new Message("Maryam", id+1, "Abeera", clientmessage, true, true);
                    messages[index]=m; 

                   index++;
                   id++;}
                //Recieving message
                try {
                    String recievemessage = input.readUTF();
                    if (recievemessage != null) {
                        System.out.println("Server: " + recievemessage);
                    }
                    if (recievemessage.equalsIgnoreCase("bye")) {
                        break;
                    }
                    if(serial<recieve.length){
                        Reciever r=new Reciever("Abeera", recievemessage);
                        recieve[serial]=r;
                        serial++;
                    }
                } catch (IOException e) {
                    System.err.println("Error receiving message: " + e.getMessage());
                }
               

                  
            }}catch (IOException e) {
            System.err.println("Error sending message: " + e.getMessage());

        }

    }
    public void Displaymessagessend(){
           if(index==0){
             System.out.println("Cant print messages");
           }
           System.out.println("Name of Sender:Maryam");
           for(int i=0;i<index;i++){                                                                                                               
            if(messages[i]!=null){
              System.out.println(messages[i].getContent());
           }
        }
    }
    public void Displayrecievemessages(){
        if(serial==0){
            System.out.println("Cant Print Messages");
         }
         System.out.println("Name of Sender:Abeera ");
         for(int i=0;i<serial;i++){
            if(recieve[i]!=null){
              System.out.println(recieve[i].getContent());
           }
        }
    }

     public void deletemessage(){
        String  mymessage;
        Scanner s=new Scanner(System.in);
        System.out.println("Enter the message u want to delete:");
        mymessage=s.nextLine();
        for(int i=0;i<index;i++){
            if(messages[i]!=null && messages[i].getContent().equalsIgnoreCase(mymessage)){
                messages[i].setContent(null);
                System.out.println("Message Deleted");
    }
        }

     }
     public void DisplayAllmessages(){
        if(serial==0){
            System.out.println("Cant Print Messages");
         }
         if(index==0){
            System.out.println("Cant print messages");
          }
          for(int i=0;i<serial;i++){
            if(recieve[i]!=null){
              System.out.println(recieve[i].getContent());
            }}
            for(int j=0;j<index;j++){
            if(messages[j]!=null){
                System.out.println(messages[j].getContent());
             }

     }
    }
     public void arraysort(){
        for (int i = 0; i < index - 1; i++) {
            for (int j = 0; j < index - 1; j++) {
                if (messages[j].getTime().compareTo(messages[j + 1].getTime()) < 0) {
                    Message temp = messages[j];
                    messages[j] = messages[j + 1];
                    messages[j + 1] = temp;
                }
            }

        }
        for (int i = 0; i < index; i++) {
            if (messages[i] != null) {
                System.out.println(messages[i].getContent());
            } else {
                System.out.println("there are no messages.please send some messages");

            }
        }

     }

    }


         


