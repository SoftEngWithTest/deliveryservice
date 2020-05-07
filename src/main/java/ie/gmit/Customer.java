package ie.gmit;

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
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.address = address;
        this.county = county;
        this.eircode = eircode;
    }

    public String getFirstName() { return firstName; }

    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }

    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }

    public String getAddress() { return address; }

    public void setAddress(String address) { this.address = address; }

    public String getCounty() { return county; }

    public void setCounty(String county) { this.county = county; }

    public String getEircode() { return eircode; }

    public void setEircode(String eircode) { this.eircode = eircode; }
}
