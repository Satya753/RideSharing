package org.example;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Trip {

    private String source;
    private String destination;
    private String rider_id;
    private String driver_id;
    private int distance ;
    private STATUS status;
    private double cost;
    private String trip_id;
    private int no_of_seats;

    public Trip(String source , String destination ,String rider_id , double cost , STATUS status , String driver_id , String trip_id){
        this.source =source;
        this.status = status;
        this.driver_id = driver_id;
        this.cost =cost;
        this.rider_id  = rider_id;
        this.destination  = destination;
        this.trip_id = trip_id;
    }



}
