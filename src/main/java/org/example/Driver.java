package org.example;

public class Driver extends User{


    private STATUS driver_status =  STATUS.IDLE;
    private String current_location;

    public Driver(String name ,String id){
        this.setUser_id(id);
        this.setUser_name(name);
    }

    public Driver() {

    }

    public boolean isAccepted(){
        if (this.driver_status==STATUS.INPROGRESS){
            System.out.println("Cannot accept the ride");
            return false;
        }
        else{
            this.driver_status =  STATUS.INPROGRESS;
            return true;
        }
    }

    public boolean completedTrip(){
        this.driver_status = STATUS.COMPLETED;
        return true;
    }

    public String getCurrent_location(){
        return this.current_location;
    }

    public void setcurrent_location(String current_location){
        this.current_location = current_location;
    }

    public void setDriver_status(STATUS status){
        this.driver_status = status;
    }

    public STATUS getDriver_status(){
        return this.driver_status;
    }


}
