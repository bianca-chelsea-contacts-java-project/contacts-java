package contacts;

public class Contacts1 {
    private String name;
    private String phoneNumber;

    public Contacts1(String name, String phoneNumber){
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public String getName(){
        return this.name;
    }

    public void setPhoneNumber(String newNumber){
        this.phoneNumber = newNumber;
    }

    public void setName(String newName){
        this.name = newName;
    }

    public String userNameNumber () {
        return this.getName() + " | " + this.getPhoneNumber() + " | ";
    }

    //This is meant as a formatting the string with the automatic sizing
//    public void userNameNumber () {
//        System.out.printf("%-10s | %-12s |", this.getName(), this.getPhoneNumber());
//    }

}
