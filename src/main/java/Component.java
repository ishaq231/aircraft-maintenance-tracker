public class Component{
    private String partNumber;
    private String type;
    private int currentFlightHours;
    private int hoursTillNextMaintenance;
    
    public Component(String partNumber, String type, int currentFlightHours, int hoursTillNextMaintenance) {
    this.partNumber = partNumber;
    this.type = type;
    this.currentFlightHours = currentFlightHours;
    this.hoursTillNextMaintenance = hoursTillNextMaintenance;

    }
    public String getPartNumber(){
        return partNumber;
    }
    public String getType(){
        return type;
    }
    public int getCurrentFlightHours(){
        return currentFlightHours;
    }
    public int getHoursTillNextMaintenance(){
        return hoursTillNextMaintenance;
    }
    public void setCurrentFlightHours(int currentFlightHours){
        this.currentFlightHours = currentFlightHours;
    }
    public void setHoursTillNextMaintenance(int hoursTillNextMaintenance){
        this.hoursTillNextMaintenance = hoursTillNextMaintenance;
    }

}