import java.util.HashSet;
import java.util.List;

/**
 * Created by subhamgupta on 06/01/18.
 */
public class Driver {

    public Driver(){
        this.setBlackListedCustomer(new HashSet<String>());
    }

    public double getRatings() {
        return ratings;
    }

    public void setRatings(double ratings) {
        this.ratings = ratings;
    }

    public HashSet<String> getBlackListedCustomer() {
        return blackListedCustomer;
    }

    public void setBlackListedCustomer(HashSet<String> blackListedCustomer) {
        this.blackListedCustomer = blackListedCustomer;
    }

    public HashSet<String> blackListedCustomer;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    String name;
    double ratings;

    public double getTrips() {
        return trips;
    }

    public void setTrips(double trips) {
        this.trips = trips;
    }



    double trips;

    public double getAverageRating(){
        return (ratings)/(trips);
    }
}
