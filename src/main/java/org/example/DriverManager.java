package org.example;

import java.util.ArrayList;
import java.util.List;

public class DriverManager {
    private List<Driver> drivers;

    public DriverManager(){
        drivers = new ArrayList<>();
    }


    public  void completedRide(String driverId){
        for(int i = 0 ; i < drivers.size() ; i++){
            if (driverId==drivers.get(i).getUser_id()) {
                drivers.get(i).setDriver_status(STATUS.COMPLETED);
                drivers.get(i).setDriver_status(STATUS.IDLE);
            }
        }
    }

    public void startRide(String driverId){
        for (int i = 0   ; i < drivers.size() ; i++){
            if (driverId==drivers.get(i).getUser_id())
                drivers.get(i).setDriver_status(STATUS.INPROGRESS);
        }
    }

    public void addNewDriver(Driver driver){
        drivers.add(driver);
    }

    public String  getAvailableDriver(){

        for (int i = 0 ; i < drivers.size() ; i++){
            if (drivers.get(i).getDriver_status()==STATUS.IDLE)
                return drivers.get(i).getUser_id();
        }

        return "-1";
    }

}
