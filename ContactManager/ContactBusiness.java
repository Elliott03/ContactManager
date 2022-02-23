public class ContactBusiness extends Contact
{

    private String company;


    public ContactBusiness(String name, String phone, String email,  
            String street, String city, String state, String zip, 
            Contact.ContactType type, String company) throws ContactException
    {
        // Calls the constructor for the superclass; Contact
        super(name, phone, email,  street, city, state, zip, type);
        
        // Company is the only field not inherited from Contact
        this.company = company;
    }
    

    @Override
    public String toString()
    {
        return super.toString() + ", " + company;
    }
    
    @Override
    public String toFile()
    {
        return super.toFile() + "," + company;
    }
}
