package org.example;

public class Rider extends User {

    private enum  STATUS{IDLE , INPROGRESS , CANCELLED , COMPLETED};

    private STATUS rider_status = STATUS.IDLE;

    public Rider(String userid , String user_name){
        this.setUser_id(userid);
        this.setUser_name(user_name);
    }
    private String current_trip;

    private boolean rideAccepted(){
        this.rider_status = STATUS.INPROGRESS;
        return true;
    }

    private boolean rideCancel(){
        this.rider_status = STATUS.CANCELLED;
        System.out.println("Ride successfully cancelled");
        return true;
    }

    private boolean rideCompleted(){
        this.rider_status = STATUS.COMPLETED;
        System.out.println("Thanks for the ride");
        this.rider_status = STATUS.IDLE;
        return true;
    }

    public String getCurrent_trip() {
        return current_trip;
    }
    public void setCurrent_trip(String trip_id){
        this.current_trip = trip_id;
    }
}
