package org.example;

import java.sql.SQLSyntaxErrorException;
import java.util.HashMap;
import java.util.Map;
import java.util.random.RandomGenerator;

public class TripManager {

    //private Map<>
    private DriverManager driverManager;
    private Map<String , Trip> trips;

    private static  final int AMOUNT_PER_KM = 23;

    public int calculateDistance(String source , String destination){
        int dis = RandomGenerator.getDefault().nextInt(23);
        return dis;

    }
    public TripManager(){
        trips = new HashMap<>();
        this.driverManager = new DriverManager();
    }

    public void addNewDriver(Driver driver){
        driverManager.addNewDriver(driver);
    }

    public String completeTrip(String driverId , String riderId){
        driverManager.completedRide(driverId);

        return "Ride Completed Successfully";
    }

    public String findAvailableDriver(String source , String destination){
        // If multiple drivers available find the one closes to him and return the return trip id , check the database

        String availableDriver  = driverManager.getAvailableDriver();

        if (availableDriver.equals("-1")){
            return "-1";
        }
        return availableDriver;
    }

    public Trip getTrip(String trip_id){
        return trips.get(trip_id);
    }

    public String createTrip(String user_id ,  String source , String destination , int no_of_seats){

        String driver_id = findAvailableDriver(source, destination);
        if (driver_id.equals("-1")){
            return "Cannot create trip as drivers are busy";
        }
        double cost = no_of_seats>=2 ? no_of_seats * 0.75 * AMOUNT_PER_KM*calculateDistance( source ,  destination) : calculateDistance(source ,destination)*AMOUNT_PER_KM;
        String trip_id = RandomGenerator.getDefault().toString();
        Trip trip = new Trip( source ,destination , user_id ,cost,  STATUS.INPROGRESS,  driver_id , trip_id);
        driverManager.startRide(driver_id);
        trips.put(trip_id , trip);
        return trip_id;
    }

    public String updateTrip(String tripid , String source , String destination){
        // Recalculate Fair

        trips.get(tripid).setDestination(destination);
        double cost = trips.get(tripid).getCost()*8;
        trips.get(tripid).setCost(cost);
        return "Trip updated Successfully";
    }

    public String completeTrip(String tripid ){
        driverManager.completedRide(trips.get(tripid).getDriver_id());
        return "Trip completed Successfully you need to pay " + trips.get(tripid).getCost();
    }



    public String cancelTrip(String tripid){

        if (trips.get(tripid)==null){
            return "Trip doesn't exist";
        }
        driverManager.completedRide(trips.get(tripid).getDriver_id());
        return "Trip cancelled successfully";
    }

    public void getTripDetails(String tripid){
        Trip trip = trips.get(tripid);

        System.out.println(trip.getSource());
        System.out.println(trip.getDestination());
        System.out.println(trip.getCost());
        System.out.println(trip.getDistance());
    }


}
