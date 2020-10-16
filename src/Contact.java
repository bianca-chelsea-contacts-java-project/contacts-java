public class Contact {
    private String name;
    private String phoneNumber;

    public Contact(String name, String phoneNumber){
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
        //return this.name + " | " + this.phoneNumber;
        return this.getName() + " | " + this.getPhoneNumber();
    }



}
