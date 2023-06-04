package org.example;

import java.util.random.RandomGenerator;

public class Client {

    public static  void main(String [] args){
        TripManager tripManager = new TripManager();
        String duserid =  RandomGenerator.getDefault().toString();
        Driver d1 = new Driver("Abhishek" , duserid);
        tripManager.addNewDriver(d1);
        duserid = RandomGenerator.getDefault().toString();
        Driver d2 = new Driver("Shubha" , duserid);
        tripManager.addNewDriver(d2);
        duserid = RandomGenerator.getDefault().toString();
        Driver d3 = new Driver("Rahul" , duserid);
        tripManager.addNewDriver(d3);


        /******/
        String user_id = RandomGenerator.getDefault().toString();
        Rider r1= new Rider("Satya" , user_id);
        String status = tripManager.createTrip(user_id , "Mohali" , "Shimla" , 5);
         user_id = RandomGenerator.getDefault().toString();
        r1= new Rider("Satya" , user_id);
         status = tripManager.createTrip(user_id , "Dehradun" , "Shimla" , 5);
         user_id = RandomGenerator.getDefault().toString();
         r1= new Rider("Ram Malik" , user_id);
         status = tripManager.createTrip(user_id , "Mumbai" , "Shimla" , 5);
        tripManager.getTripDetails(status);
        System.out.println(tripManager.completeTrip(status));
        user_id = RandomGenerator.getDefault().toString();
         r1= new Rider("Ray Clayman" , user_id);
         status = tripManager.createTrip(user_id , "Delhi" , "Shimla" , 5);
         tripManager.getTripDetails(status);

    }
}
