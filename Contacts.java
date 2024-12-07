import java.util.Objects;

public class Contacts {
     private String name;
    private String number;
    private String IP;

    public Contacts(String name, String number,String IP) {
        this.name = name;
        this.number = number;
        this.IP=IP;
    }


    public String getIP() {
        return IP;
    }


    public void setIP(String iP) {
        IP = iP;
    }


    public void setName(String name) {
        this.name = name;
    }


    public void setNumber(String number) {
        this.number = number;
    }


    public String getName() {
        return name;
    }

   
    public String getNumber() {
        return number;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Contacts contacts= (Contacts) obj;
        return Objects.equals(name,contacts.name);
    } 

}
