public class ContactFamily extends Contact
{

    private String relationship;


    public ContactFamily(String name, String phone, String email,  
            String street, String city, String state, String zip, 
            Contact.ContactType type, String relationship) throws ContactException
    {
        // Calls the constructor for the superclass; Contact
        super(name, phone, email,  street, city, state, zip, type);
        
        // Relationship is the only field not inherited from Contact
        this.relationship = relationship;
    }
    

    @Override
    public String toString()
    {
        return super.toString() + ", " + relationship;
    }
    
    @Override
    public String toFile()
    {
        return super.toFile() + "," + relationship;
    }
}