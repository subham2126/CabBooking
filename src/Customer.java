import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Created by subhamgupta on 06/01/18.
 */
public class Customer {

    public Customer(){
        this.setDriverList(new HashSet<String>());
        this.setBlackListDrivers(new HashSet<String>());
        this.setRatings(0);
        this.setTrips(0);
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getRatings() {
        return ratings;
    }

    public void setRatings(double ratings) {
        this.ratings = ratings;
    }

    public double getTrips() {
        return trips;
    }

    public void setTrips(double trips) {
        this.trips = trips;
    }







    String name;
    double ratings;
    double trips;

    public HashSet<String> getBlackListDrivers() {
        return blackListDrivers;
    }

    public void setBlackListDrivers(HashSet<String> blackListDrivers) {
        this.blackListDrivers = blackListDrivers;
    }

    HashSet<String> blackListDrivers = new HashSet<>();


    public double getAverageRating(){
        return (ratings)/(trips);
    }

    public HashSet<String> getDriverList() {
        return driverList;
    }

    public void setDriverList(HashSet<String> driverList) {
        this.driverList = driverList;
    }

    HashSet<String> driverList;
}
