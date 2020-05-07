package ie.gmit;

/**
 * Customer details class
 */
public class CustomerDetails {
    private String name;
    private String customerId;
    private String address;
    private String phone;
    private String email;


    public CustomerDetails(String name,String customerId,String address,String phone,String email){
        this.name = name;
        this.customerId = customerId;
        this.address = address;
        this.phone = phone;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString(){
        return "Customer name: "+name+"\nCustomer ID: "+customerId+"\nPhone number: "+phone+"\nAddress: "+
                address+"\nEmail: "+email;
    }
}
