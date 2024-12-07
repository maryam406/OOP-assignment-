import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Server {
    String name;
    public Message[] messages;
    public Reciever[] recieve;
    private static final int Server_PORT = 1098;
    private ServerSocket serverSocket; // ServerSocket for server to listen on
    private Socket socket;
    private DataInputStream input;
    private DataOutputStream output;
    public static int index = 0;
    public static int serial = 0;
    public static int id = 0;

    public Server() {
        messages = new Message[20];
        recieve = new Reciever[20];
    }

    public void setupcommunication() {
        try {
            System.out.println("Attempting to bind to IP: " +  " on port: " + Server_PORT);
            serverSocket = new ServerSocket(Server_PORT);
            System.out.println("Server listening on " +  ":" + Server_PORT);

            // Accept the first client that connects
            socket = serverSocket.accept();
            System.out.println("Client connected: " + socket.getInetAddress());

            input = new DataInputStream(socket.getInputStream());
            output = new DataOutputStream(socket.getOutputStream());

        } catch (IOException e) {
            System.err.println("Error during server setup: " + e.getMessage());
            e.printStackTrace();
        }
    }


    public void sendmessage() {
        try {
            while (true) {
                // Receiving message
                String recievemessage = input.readUTF();
                if (recievemessage != null) {
                    System.out.println("Server received: " + recievemessage);
                }
                if (recievemessage.equalsIgnoreCase("bye")) {
                    break;
                }
                if (serial < recieve.length) {
                    Reciever r = new Reciever("Client", recievemessage);
                    recieve[serial] = r;
                    serial++;
                }

                // Sending message
                try {
                    Scanner sc = new Scanner(System.in);
                    System.out.println("Enter the message you want to send to the client:");
                    String clientmessage = sc.nextLine();
                    output.writeUTF(clientmessage);
                    output.flush();
                    if (clientmessage.equalsIgnoreCase("bye")) {
                        break; // Exit if the user types "bye"
                    }
                    if (index < messages.length) {
                        Message m = new Message("Server", id + 1, "Client", clientmessage, true, true);
                        messages[index] = m;
                        index++;
                        id++;
                    }
                } catch (IOException e) {
                    System.err.println("Error while sending message: " + e.getMessage());
                }
            }

        } catch (IOException e) {
            System.err.println("Error while receiving or sending message: " + e.getMessage());
        } finally {
            try {
                // Close the streams and socket after communication ends
                input.close();
                output.close();
                socket.close();
                serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void Displaymessagessend() {
        if (index == 0) {
            System.out.println("No messages sent yet.");
        } else {
            for (int i = 0; i < index; i++) {
                if (messages[i] != null) {
                    System.out.println(messages[i].getContent());

                }
            }
        }
    }

    public void Displayrecievemessages() {
        if (serial == 0) {
            System.out.println("No messages received yet.");
        } else {
            for (int i = 0; i < serial; i++) {
                if (recieve[i] != null) {
                    System.out.println("Message: " + recieve[i].getContent());
                }
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
