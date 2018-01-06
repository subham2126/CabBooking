import java.util.*;

public class Main {
    public static Map<String,Driver > drivers =  new HashMap<String,Driver> ();
    public static Map<String,Customer> customers = new HashMap<String,Customer>();

    public static void addTrip(String driver , double driverRating , String customer , double customerRating){
        Driver driverObject;
        if(drivers.containsKey(driver)) {
            driverObject = drivers.get(driver);
        }
        else {
            driverObject = new Driver();
            driverObject.setName(driver);
        }
            driverObject.setRatings(driverObject.getRatings() + driverRating);
            driverObject.setTrips(driverObject.getTrips() + 1);
            if(customerRating == 1) {
                HashSet<String> set = driverObject.getBlackListedCustomer();
                set.add(customer);
                driverObject.setBlackListedCustomer(set);
            }
            drivers.put(driver , driverObject);
        Customer customerObject;
        if(customers.containsKey(customer)){
            customerObject = customers.get(customer);
        }
        else {
            customerObject = new Customer();
            customerObject.setName(customer);
        }
        customerObject.setRatings(customerObject.getRatings()+ customerRating);
        customerObject.setTrips(customerObject.getTrips() + 1);

        if(driverRating == 1){
            HashSet<String> set = customerObject.getBlackListDrivers();
            set.add(driver);
            customerObject.setBlackListDrivers(set);
        }
        else {
            HashSet<String> set = customerObject.getDriverList();
            set.add(driver);
            customerObject.setDriverList(set);
        }
        customers.put(customer,customerObject);


        }




    public static List<Driver> getEligibleCabs(String customer){
        List<Driver> list = new ArrayList<Driver>();
        if(!customers.containsKey(customer)){
            return  new ArrayList<>();
        }
        else
        {
            Customer c = customers.get(customer);

            for(String key : drivers.keySet()){

                Driver driver = drivers.get(key);
                if(driver.getAverageRating()>= c.getAverageRating() && (c.getBlackListDrivers().contains(driver.getName()) == false) && (driver.getBlackListedCustomer().contains
                        (c.getName())==false))
                    list.add(driver);

            }

            if(list.size() == 0){
                HashSet<String> set = c.getDriverList();
                for(String driver :  set)
                    list.add(drivers.get(driver));
            }

            return list;
        }
    }

    public static double  getAverageRatingOfCustomer(String customer){

        if(customers.containsKey(customer)){
            return customers.get(customer).getAverageRating();
        }
        return -1;
    }

    public static void main(String[] args) {

        addTrip("d1",4,"c1",5);
        addTrip("d1", 5,"c2",4);
        addTrip("d1",1,"c3",2);
        addTrip("d2",5,"c1",1);
        addTrip("d2",5,"c2",5);
        addTrip("d2",4,"c3",5);
        addTrip("d3",3,"c1",2);
        addTrip("d3",4,"c2",5);
        addTrip("d3",3,"c3",3);
        addTrip("d4",1,"c2",5);
        addTrip("d4",2,"c4",5);

        System.out.println(getAverageRatingOfCustomer("c1"));
        System.out.println(getAverageRatingOfCustomer("c2"));
        System.out.println(getAverageRatingOfCustomer("c3"));
        System.out.println(getAverageRatingOfCustomer("c4"));
        List<Driver> driverss = getEligibleCabs("c4");
        for(int i=0;i<driverss.size();i++)
            System.out.println(driverss.get(i).getName()  );




    }
}
