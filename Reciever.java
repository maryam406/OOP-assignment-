public class Reciever {
    String name;
    String IP;
    String content;
     private Boolean send;
     private Boolean seen;
    public Reciever(String name,String content){
        this.name=name;
        this.content=content;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public Boolean getSend() {
        return send;
    }
    public void setSend(Boolean send) {
        this.send = send;
    }
    public Boolean getSeen() {
        return seen;
    }
    public void setSeen(Boolean seen) {
        this.seen = seen;
    }
}
