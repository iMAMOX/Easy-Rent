
//create the Customer class

public class Customer {

    //data member of the Customer class
    private String first_name;
    private String last_name;
    private String email;
    private long credit_card;
    private int discount_code;
    private static int total;

    /////////////////////////////////////////////////////////////////////
    // the default constructor of Customer class
    public Customer() {
        first_name = "Undefined Yet!";
        last_name = "Undefined Yet!";
        email = "Undefined Yet!";
        credit_card = -0;
        discount_code = 0;
    }

// another constructor for the Customer class but not the defalut one
    public Customer(String firstName, String lastName, String email, long card, int code) {
        first_name = firstName;
        last_name = lastName;
        this.email = email;
        credit_card = card;
        discount_code = code;
    }
    /////////////////////////////////////////////////////////////////////
    // setter methods of the Customer class

    public void setFirstName(String first_name) {
        this.first_name = first_name;
    }

    public void setLastName(String last_name) {
        this.last_name = last_name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCreditCard(long credit_card) {
        this.credit_card = credit_card;
    }

    /////////////////////////////////////////////////////////////////////
    // getter methods of the Customer class
    public String getFirstName() {
        return first_name;
    }

    public String getLastName() {
        return last_name;
    }

    public String getEmail() {
        return email;
    }

    public long getCreditCard() {
        return credit_card;
    }

    public int getClientCode() {
        return discount_code;
    }
    
    
    public static int getTotal() {
        return total;
    }
    
    //return the all details of the object
    @Override
    public String toString() {
        return "{" + "first name= " + first_name + ", last name= " + last_name + ", email= " + email + ", credit card= " + credit_card + ", discount code= " + discount_code + '}';
    }
    
    
}
