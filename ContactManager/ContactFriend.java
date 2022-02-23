public class ContactFriend extends Contact
{
    private int yearMet;


    public ContactFriend(String name, String phone, String email,  
            String street, String city, String state, String zip, 
            ContactType type, int yearMet) throws ContactException
    {
        // Calls the constructor for the superclass; Contact
        super(name, phone, email,  street, city, state, zip, type);
        
        // yearMet is the only field not inherited from Contact
        this.yearMet = yearMet;
    }
    

    @Override
    public String toString()
    {
        return super.toString() + ", " + yearMet;
    }
    
    @Override
    public String toFile()
    {
        return super.toFile() + "," + yearMet;
    }
}
