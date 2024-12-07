import java.security.cert.CRLSelector;
import java.time.LocalDateTime;

public class Message {
    private String sender="Maryam";
    private String reciever;
    private String content;
    private int messageid;
    private  boolean send;
    private boolean seen;
    private String name;
    LocalDateTime time;
    private static int counter=0;

    
       //constructor
    Message(String sender, int messageid ,String reciever, String content, boolean send, boolean seen) {
        this.sender = sender;
        this.reciever = reciever;
        this.content = content;
        this.messageid=messageid;
        this.send = send;
        this.seen=seen;
        this.time = LocalDateTime.now();
    }
      //constructor
    
    
    
    // setters 
    public void setReciever(String reciever) {
       this.reciever = reciever;
    }

    public String getSender() {
        return sender;
    }
    public void setSender(String sender) {
        this.sender = sender;
    }
    public void setContent(String content) {
        this.content = content;
    }

    public void setSend(boolean send) {
        this.send = send;
    }
      
    //Getters

    public String getReciever() {
        return reciever;
    }
    public String getContent() {
        return content;
    }
    public int getMessageid() {
        return messageid;
    }
    public boolean isSend() {
        return send;

    }
    public boolean isSeen() {
        return seen;
    }
    public void setSeen(boolean seen) {
        this.seen = seen;
    }
    public LocalDateTime getTime() {
        return time; // Added getter for time
    }
    // to string function
    @Override
    public String toString(){
        return String.format("Sender:%s\nReciever:%s\nContent:%s\nMessageid:%s\nSeen:%bSent:%bSentat:%s",sender,reciever,content,messageid,seen,send,time);

    }
    
    
 
}

