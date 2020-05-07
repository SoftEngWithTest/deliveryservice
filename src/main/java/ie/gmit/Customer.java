package ie.gmit;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Customer {
    private String firstName;
    private String lastName;
    private String email;
    private String address;
    private String county;
    private String eircode;

    public Customer() {
        this.firstName = "";
        this.lastName = "";
        this.email = "";
        this.address = "";
        this.county = "";
        this.eircode = "";
    }

    public Customer(String firstName, String lastName, String email, String address, String county, String eircode) {
        setFirstName(firstName);
        setLastName(lastName);
        setEmail(email);
        setAddress(address);
        setCounty(county);
        setEircode(eircode);
    }

    public String getFirstName() { return firstName; }

    public void setFirstName(String firstName) {
        if(firstName.length() < 2)
            throw new IllegalArgumentException("First name must be at least 2 characters");
        else
            this.firstName = firstName;
    }

    public String getLastName() { return lastName; }

    public void setLastName(String lastName) {
        if(lastName.length() < 2)
            throw new IllegalArgumentException("Last name must be at least 2 characters");
        else
            this.lastName = lastName;
    }

    public String getEmail() { return email; }

    public void setEmail(String email) {
        if(email.length() < 10)
            throw new IllegalArgumentException("Email must be at least 10 characters");
        else
            this.email = email;
    }

    public String getAddress() { return address; }

    public void setAddress(String address) {
        if(address.length() < 5)
            throw new IllegalArgumentException("Address must be at least 5 characters");
        else
            this.address = address;
    }

    public String getCounty() { return county; }

    public void setCounty(String county) {
        if(county.length() < 4)
            throw new IllegalArgumentException("County must be at least 4 characters");
        else
            this.county = county;
    }

    public String getEircode() { return eircode; }

    public void setEircode(String eircode) {
        //Using Regular Expressions to make sure correct Eircode format was used
        //String regex is the correct format and will use this to compare to user entry
        String regex = "\\D\\d\\d\\s\\D\\d\\D\\d";

        Pattern pt = Pattern.compile(regex);
        Matcher m = pt.matcher(eircode);
        boolean result = m.matches();

        if(eircode.length() != 8)
            throw new IllegalArgumentException("Eircode must be 8 characters");
        else if(result == false)
            throw new IllegalArgumentException("Eircode must follow the correct format e.g H78 J9K6");
        else
            this.eircode = eircode;
    }
}
