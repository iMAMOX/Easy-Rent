
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;



public class EasyRent {

    public static void main(String[] args) throws FileNotFoundException {
        File file1 = new File("inputCar.txt");
        File file2 = new File("Reservationinput.txt");
        PrintWriter pw1 = new PrintWriter("CarsInfo.txt");
        PrintWriter pw2 = new PrintWriter("ReservationStatus.txt");
        PrintWriter pw3 = new PrintWriter("AnalysisReport.txt");
        Scanner in1 = new Scanner(file1);
        Scanner in2 = new Scanner(file2);
        /////////////////////////////////////////////////////////////////////
        //check if both files are exists or not
        if (!file1.exists() ) {
            System.out.println("The input Car File is missing !!");
            System.exit(0);
        }
        if (!file2.exists() ) {
            System.out.println("The Reservation input File is missing !!");
            System.exit(0);
        }
        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //fill the array with data from the input Car file 
        String[] types = new String[in1.nextInt()];
        for (int i = 0; i < types.length; i++) {
            types[i] = in1.next();
        }
        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //create the arrays
        Car[] cars = new Car[in1.nextInt()];
        Service[] services = new Service[in1.nextInt()];
        Reservation[] reservations = new Reservation[in2.nextInt()];
        Customer[] customers = new Customer[reservations.length];
        int analysis [] [] = new int [services.length] [types.length];
        
        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //Start 
        String command = in1.next();

        do {
            if (command.equalsIgnoreCase("AddCar")) {
                addcar(cars, in1);
            } else if (command.equalsIgnoreCase("AddService")) {
                Addservice(services, in1);
            }

            command = in1.next();

        } while (!command.equalsIgnoreCase("Quit"));
        in1.close();

        command = in2.next();
        int x = 0;
        do {
            if (command.equalsIgnoreCase("Reserve")) {
                Reservation(cars, reservations, in2, customers, services,x);
                x++;


            }
            command = in2.next();
        } while (!command.equalsIgnoreCase("Quit"));
        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        
        
        
        carsinfo(cars,pw1);
        ReservationStatus(reservations, pw2,customers);
        AnalysisReport(analysis, reservations, types, pw3, services);

        System.out.println("Done.\nCheck The Project Folder.");

    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //fill the Car array with data from the input Car file 
    public static Car[] addcar(Car[] cars, Scanner in1) {
        int count = 0;
        for (int i = 0; i < cars.length; i++) {
                //read the details from the input Car file
                cars[i] = new Car(in1.next(), in1.nextInt(), in1.nextDouble(), in1.nextBoolean(), in1.next(), in1.nextBoolean());
                count++;
                if(count == cars.length)
                    break;
                
                if (in1.next().equalsIgnoreCase("AddCar")){}
                
                
            
        }
        return cars;
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //fill the services array with data from the input Car file 
    public static void Addservice(Service[] services, Scanner in1) {
        int count = 0;
        for (int i = 0; i < services.length; i++) {
            services[i] = new Service(in1.next(), in1.nextInt());
            count++;
            
            if(count == services.length)
                    break;
            
            if (in1.next().equalsIgnoreCase("AddService")) {}
                
        }
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public static void Reservation(Car[] cars, Reservation[] reservations, Scanner in2, Customer[] customers,Service[] services,int i) {
        
        
            reservations[i]= new Reservation();
            
            Car customerCar = checkCar(cars,in2);
            reservations[i].setCar(customerCar);
            
            if (customerCar==null){
                reservations[i]=null;
                return;
            }
        
            reservations[i].setPickUpLocation(in2.next());
            reservations[i].setDropOfLocation(in2.next());
            reservations[i].setPick_up(in2.nextInt(),in2.nextInt(),in2.nextInt());
            reservations[i].setDrop_of(in2.nextInt(),in2.nextInt(),in2.nextInt());
            reservations[i].setDate_of_reservation((reservations[i].getDrop_of_date().getTime()-reservations[i].getPick_up_date().getTime())/86400000);
            customers[i]=new Customer(in2.next(), in2.next(), in2.next(), in2.nextLong(), in2.nextInt());
            reservations[i].setCustomer(customers[i]);
            reservations[i].setAdditional_services(additionalservices(services, in2)); 
       
    }
    
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //check if there is available car with the wish of the customer 
    //the method will return either a car from database or null if there is no suitable car 
    public static Car checkCar(Car [] cars, Scanner in2) {
        String Type=in2.next();
        String Transmission =in2.next();
        String Convertible =in2.next();
        
        for (int i = 0; i < cars.length; i++) {
            if ((Type.equalsIgnoreCase(cars[i].getCarType()))&&(Transmission.equalsIgnoreCase(cars[i].getTransmission()))&&(Convertible.equalsIgnoreCase(cars[i].isConvertible()))){
                
                return cars[i];
                }
        }
       return null; 
    }
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //check if there is any additional services requird by the customer or not 
    //if there is any additional services the program will store it in the database
    public static Service additionalservices(Service[]services,Scanner in2) {
        String additional_service = in2.next();
        
        if(!additional_service.equalsIgnoreCase("submit")){
            in2.next();
            for (int i = 0; i < services.length; i++) {
                if(services[i].getType().equalsIgnoreCase(additional_service)){
                    return services[i];}
            }
        }
        return null;
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //print the Car information File from the database
    public static void carsinfo(Car [] cars, PrintWriter pw1){
        pw1.println("--------------- Welcome to Car Renting  Data Base ---------------\n\n\n\n\n");
        for (int i = 0;i<cars.length;i++){
            pw1.print(cars[i].carInfo()+"\n");
            pw1.println("------------------------------------------------------\n\n");
            
        }
        pw1.close();
        pw1.flush();
        
    }
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //print each Reservation Status in the file
    public static void ReservationStatus(Reservation[] reservations,PrintWriter pw2,Customer[] customers){
        ;
        pw2.println("--------------- Welcome to Car Renting  Management System ---------------\n\n\n\n\n");
        pw2.println("--------------- Display All System Procedures ---------------\n\n\n\n\n");
        SimpleDateFormat date = new SimpleDateFormat("d-M-y");
        for (int i = 0; i < reservations.length; i++) {
            if(!(reservations[i]==null)){
                pw2.println("DONE: The reservation is completed\n");
                pw2.println("******Reservation Refrence number : "+reservations[i].getReservation_code()+"\n");
                pw2.println("******Customer information : Customer Name: "+reservations[i].getCustomer().getFirstName()+" "+customers[i].getLastName()+", Email: "+customers[i].getEmail()+", Code: "+customers[i].getClientCode()+"\n");
                pw2.print("******Pick up location : "+reservations[i].getPick_up_location());
                pw2.println(" ******Drop of location : "+reservations[i].getDrop_of_location()+"\n");
                pw2.print("******Pick up date : "+ date.format(reservations[i].getPick_up_date()));
                pw2.println(" ******Drop of date : "+date.format(reservations[i].getDrop_of_date())+"\n");
                pw2.println("******Car information : The car Type: "+ reservations[i].getCar().getBrand()+" "+reservations[i].getCar().getCarType()+", Year: "+reservations[i].getCar().getYearOfConstruction()+", Transmission: "+reservations[i].getCar().getTransmission()+" "+reservations[i].getCar().isConvertible()+"\n");
                pw2.println("******Additional services : Service "+reservations[i].getService().getType()+"\n");
                pw2.println("--------------- Invoice Details ---------------\n");
                pw2.println("Number of reserved days: "+reservations[i].getDate_of_reservation()+"\n");
                
                //calculate the Intial Price (Car Rate * number of reserved  days)
                double IntialTotal = (reservations[i].getCar().getCarRate()*reservations[i].getDate_of_reservation());
                //check if the ordered car type is Luxury the price will be increased by 10%
                if (reservations[i].getCar().getCarType().equalsIgnoreCase("Luxury")){
                    IntialTotal = IntialTotal *1.1;
                }
                //calculate the Intial Price + the additional services (if there is any additional services) 
               double ServicesPrice = IntialTotal+reservations[i].getService().getPrice();
               double finalPrice = ServicesPrice;
                pw2.println("Intial Total: "+IntialTotal+"\n");
                pw2.println("--------------- Additional Services Price ---------------\n");
                pw2.println("Total After additional Services  : "+ServicesPrice+"\n");
                pw2.println("--------------- Final Payment after Discount ---------------\n");
                //check the first digit of the customer code to give the customer a discount
                //if first digit is (9,8,7) discount by 20% 
                //if first digit is (6,5,4) discount by 15%
                //if first digit is (3,2,1) discount by 10% 
                if ((reservations[i].getCustomer().getClientCode()/100==9)||(reservations[i].getCustomer().getClientCode()/100==8)||(reservations[i].getCustomer().getClientCode()/100==7)){
                    finalPrice = finalPrice-(finalPrice*0.20);
                }
                else if ((reservations[i].getCustomer().getClientCode()/100==6)||(reservations[i].getCustomer().getClientCode()/100==5)||(reservations[i].getCustomer().getClientCode()/100==4)){
                    finalPrice = finalPrice-(finalPrice*0.15);
                }
                else if ((reservations[i].getCustomer().getClientCode()/100==3)||(reservations[i].getCustomer().getClientCode()/100==2)||(reservations[i].getCustomer().getClientCode()/100==1)){
                    finalPrice = finalPrice-(finalPrice*0.10);
                }
                    
                pw2.println(" Final Total  : "+finalPrice+"\n\n\n\n\n");
                
            }
            else{
                pw2.println("SORRY: The reservation is NOT completed \nThere is no available Car\n\n\n\n\n");

                
            }
                
            
        }
        pw2.close();
        pw2.flush();
        
        
    }
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //print the Analysis Report in the file 
    public static void AnalysisReport(int [][]analysis, Reservation[]reservations,String []types,PrintWriter pw3,Service[]services){
        
        pw3.println("-------------- Analysis Report ---------------\n\n\n");
        pw3.print("             CarType");
        for (int i = 0; i < types.length; i++) {
            pw3.print("      \t"+types[i]);
            
        }
        pw3.println("\n");
        pw3.println("        Services \n");
        pw3.println("        -----------------------------------------------------\n");
        //invoke a method to fill the array
        AnalysisArr(analysis,reservations, types, services);
        
        
        for (int i = 0; i < analysis.length; i++) {
            pw3.print("\t"+services[i].getType()+"\t\t");
            
            for (int j = 0; j < analysis[i].length; j++) {
                pw3.print(analysis[i][j]+"\t\t");
                
            }
            pw3.println("\n");
            
        }

            
        pw3.flush();
        pw3.close();
        
    }
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //fill the Analysis array and return it
    public static int[][] AnalysisArr(int [][]analysis,Reservation[]reservations,String []types , Service[]services){
      
        for (int i = 0; i < reservations.length; i++) {
            if (!(reservations[i]==null)){
                for (int j = 0; j < analysis.length; j++) {
                    if(reservations[i].getCar().getCarType().equalsIgnoreCase(types[j])){
                        for (int k = 0; k < analysis[j].length; k++) {
                            if (reservations[i].getService().getType().equalsIgnoreCase(services[k].getType())){
                                analysis[j][k]++;
                            }
                            
                        }
                    }
                    
                }
                
            }
            
        }
        return analysis;
    }

}
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
