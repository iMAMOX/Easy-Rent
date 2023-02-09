/*
Name : MESHAL ALI OKAIRY
ID : 2237836
Section : F1
*/

import java.util.Date;
import java.util.Random;
//create the Customer class

public class Reservation {

    //data member of the Customer class
     
    private String reservation_code;
    private String pick_up_location;
    private String drop_of_location;
    private Date pick_up_date;
    private Date drop_of_date;
    private Long date_of_reservation;
    private Customer customer;
    private Car car;
    private Service additional_services;
    /////////////////////////////////////////////////////////////////////
    // the default constructor of Customer class

    public Reservation() {
        reservation_code = "Undefined Yet!";
        pick_up_location = "Undefined Yet!";
        drop_of_location = "Undefined Yet!";
        pick_up_date = new Date();
        drop_of_date = new Date();
        date_of_reservation = 0L;
        car = new Car();

    }

    // another constructor for the Customer class but not the defalut one
    public Reservation(String pick_up_location, String drop_of_location, Date pick_up_date, Date drop_of_date, Customer customer, Car car) {
        this.pick_up_location = pick_up_location;
        this.drop_of_location = drop_of_location;
        this.pick_up_date = pick_up_date;
        this.drop_of_date = drop_of_date;
        this.customer = customer;
        this.car = car;
    }

    /////////////////////////////////////////////////////////////////////
    // setter methods of the Customer class
    public void setReservationCode(String reservation_code) {
        this.reservation_code = reservation_code;
    }

    public void setPickUpLocation(String pick_up_location) {
        this.pick_up_location = pick_up_location;
    }

    public void setDropOfLocation(String drop_of_location) {
        this.drop_of_location = drop_of_location;
    }

    public void setPick_up(int pick_up_year,int pick_up_month,int pick_up_day) {
        pick_up_date = new Date(pick_up_year-1900, pick_up_month-1, pick_up_day);
    }

    public void setDrop_of(int pick_up_year,int pick_up_month,int pick_up_day) {
        drop_of_date = new Date(pick_up_year-1900, pick_up_month-1, pick_up_day);
    }

    public void setDate_of_reservation(Long date_of_reservation) {
        this.date_of_reservation = date_of_reservation;
    }
    
    

    public void setCar(Car another) {
        car = another;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    

    public void setAdditional_services(Service additional_services) {
        this.additional_services = additional_services;
    }
    
    

        /////////////////////////////////////////////////////////////////////

    // getter methods of the Customer class

    public String getReservation_code() {
        Random code = new Random();
        reservation_code = " "+customer.getFirstName().charAt(0)+ customer.getLastName().charAt(0)
                +"_"+ code.nextInt(1000)+"_"+car.getYearOfConstruction();//create and return the Reservation Refrence
        return reservation_code;
    }

    public String getPick_up_location() {
        return pick_up_location;
    }

    public String getDrop_of_location() {
        return drop_of_location;
    }

    public Date getPick_up_date() {
        return pick_up_date;
    }

    public Date getDrop_of_date() {
        return drop_of_date;
    }

    public Long getDate_of_reservation() {
        return date_of_reservation;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Car getCar() {
        return car;
    }

    public Service getService() {
        return additional_services;
    }

    

    //return the all details of the object
    @Override
    public String toString() {
        return "Reservation{" + "reservation_code=" + reservation_code + ", pick_up_location=" + pick_up_location + ", drop_of_location=" + drop_of_location + ", pick_up_date=" + pick_up_date + ", drop_of_date=" + drop_of_date + ", date_of_reservation=" + date_of_reservation + ", customer=" + customer + ", car=" + car + ", additional_services=" + additional_services + '}';
    }

    
    
    
    
    
    
    
    
}
