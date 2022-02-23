public abstract class Contact implements Comparable<Contact>
{

    private String name;
    private String phone;
    private String email;
    private Address address;
    private ContactType type;
    

    private static int count;
    

    public static void decrementCount()
    {
        --count;
    }
   
    public Contact(String name, String phone, String email,  
            String street, String city, String state, String zip,
            ContactType type) throws ContactException
    {
        this.name = name;
        this.email = email;
        this.phone = phone;
        
        // create the inner Address object
        this.address = new Address(street, city, state, zip);
        this.type = type;
        
        ++count;
    }

    public static int getCount()
    {
        return count;
    }

    public static void setCount(int count) {
        Contact.count = count;

    }

    
    public Address getAddress()
    {
        return address;
    }

    public void setAddress(Address address)
    {
        this.address = address;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getPhone()
    {
        return phone;
    }

    public void setPhone(String phone)
    {
        this.phone = phone;
    }
    
    @Override
    public String toString()
    {
        return name + ", " + phone + ", " + email + ", " + 
            address.toString() + ", " + type;
    }
    
    public String toFile()
    {
        return name + "," + phone + "," + email + "," + 
            address.toFile() + "," + type;
    }

    @Override
    public int compareTo(Contact contactObj)
    {
        return this.name.compareTo(contactObj.getName());
    }
    
    private class Address 
    {

        private String street;
        private String city;
        private String state;
        private String zip;


        public Address(String street, String city, String state, String zip) throws ContactException
        {
            this.street = street;
            this.city = city;
            this.state = state;
            this.zip = zip;
            
            // Ensure fields are valid
            validateStreet();
            validateCity();
            validateState();
            validateZip();
        }


        public String getStreet()
        {
            return street;
        }

        public void setStreet(String street)
        {
            this.street = street;
            validateStreet();
        }

        public String getCity()
        {
            return city;
        }

        public void setCity(String city)
        {
            this.city = city;
            validateCity();
        }

        public String getState()
        {
            return state;
        }

        public void setState(String state) throws ContactException
        {
            this.state = state;
            validateState();
        }

        public String getZip()
        {
            return zip;
        }

        public void setZip(String zip)  throws ContactException
        {
            this.zip = zip;
            validateZip();
        }
        

        public String toString()
        {
            return street + ", " + city + ", " + state + ", " + zip;
        }
        

        public String toFile()
        {
            return street + "," + city + "," + state + "," + zip;
        }
        
        
        public void validateStreet()
        {
            // if length longer than 10 characters, truncate it.
            street = street.length() <= 10? street : street.substring(0, 10);
        }
        
        public void validateCity()
        {
            // make the first letter uppercase
            city = city.substring(0, 1).toUpperCase() + city.substring(1);
        }
        
        public void validateState() throws ContactException
        {
            // Makes the state uppercase
            state = state.toUpperCase();
            if(state.length() != 2)
            {
                throw new ContactException("State: Not 2 characters");
            }
        }
        
        public void validateZip() throws ContactException
        {
            // Ensure that the zip code is 5 characters
            if(zip.length() != 5)
            {
                throw new ContactException("Zip: Not 5 characters");
            }
            
            // Ensure that the zip code is comprised of only digits
            for(int index = 0; index < zip.length(); ++index)
            {
                if(!Character.isDigit(zip.charAt(index)))
                {
                    throw new ContactException("Zip: Not all digits");
                }
            }
        }
    }
    
    public static enum ContactType
    {
        BUSINESS, FAMILY, FRIEND
    }


}