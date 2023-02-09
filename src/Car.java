
//create the Car class
public class Car {

    //data member of the Car class
    private String brand;
    private String carType;
    private int year_of_construction;
    private double car_rate;
    private boolean transmission_Manual;
    private boolean convertible;
    private static int total_car;

    /////////////////////////////////////////////////////////////////////
    // the default constructor of Car class
    public Car() {
        this("Undefined Yet!", 0, 0.0, false, "Undefined Yet!", false);

    }

    // another constructor for the Car class but not the defalut one
    public Car(String brand, int year, double rate, boolean transmission, String type, boolean convertible) {
        this.brand = brand;
        carType = type;
        year_of_construction = year;
        car_rate = rate;
        transmission_Manual = transmission;
        this.convertible = convertible;
        total_car++;

    }
    /////////////////////////////////////////////////////////////////////

    // setter methods of the Car class
    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public void setYearOfConstruction(int year_of_construction) {
        this.year_of_construction = year_of_construction;
    }

    public void setCarRate(double car_rate) {
        this.car_rate = car_rate;
    }

    public void setTransmission(boolean transmission_Manual) {
        this.transmission_Manual = transmission_Manual;
    }

    public void setCcobvertible(boolean convertible) {
        this.convertible = convertible;
    }

    /////////////////////////////////////////////////////////////////////
    // getter methods of the Car class
    public String getBrand() {
        return brand;
    }

    public String getCarType() {
        return carType;
    }

    public int getYearOfConstruction() {
        return year_of_construction;
    }

    public double getCarRate() {
        return car_rate;
    }

    public String getTransmission() {
        
        if (transmission_Manual){return "Manual";}
        else {return "Automatic";}
    }

    public String isConvertible() {
        
         if (convertible){return "Convertible";}
        else {return "Non_convertible";}

    }

    public static int getToatalCar() {
        return total_car;
    }

    /////////////////////////////////////////////////////////////////////
    //return the all details of the object
    @Override
    public String toString() {
        return "Car{" + "Brand = " + brand + ", Car Type = " + carType + ", Year Of Construction = " + year_of_construction + ", Car Rate = " + car_rate + ", Transmission Manual = " + transmission_Manual + ", Convertible = " + convertible + '}';
    }

    //return the information of the car
    public String carInfo() {
        String y="The Car Type: " + brand +" "+ carType + ", Year: "+year_of_construction + ", Transmission: "+ getTransmission();
        String x;
        
        if (isConvertible().equalsIgnoreCase("Convertible")) {x=" And Convertible";}
        else x="";
        
        return y+x;
        
    }

}
