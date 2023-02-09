
//create the Service class

public class Service {

    //data member of the Service class
    private String serviceType;
    private double servicePrice;

    /////////////////////////////////////////////////////////////////////
    // the default constructor of Service class
    public Service() {
        serviceType = "Undefined Yet!";
        servicePrice = -0.0;

    }

// another constructor for the Service class but not the defalut one
    public Service(String type, double price) {
        serviceType = type;
        servicePrice = price;
    }
    /////////////////////////////////////////////////////////////////////
    // setter methods of the Customer class

    public void setType(String serviceType) {
        this.serviceType = serviceType;
    }

    public void setPrice(double servicePrice) {
        this.servicePrice = servicePrice;
    }

    /////////////////////////////////////////////////////////////////////
    // getter methods of the Customer class
    public String getType() {
        return serviceType;
    }

    public double getPrice() {
        return servicePrice;
    }
    
    /////////////////////////////////////////////////////////////////////
    //return the all details of the object
    @Override
    public String toString() {
        return "{" + "service Type = " + serviceType + ", Service Price = " + servicePrice + '}';
    }
    

}
