import java.util.ArrayList;

public class MaintenanceTracker {
    private ArrayList<Aircraft> aircraftList;
    
    public MaintenanceTracker() {
        this.aircraftList = new ArrayList<Aircraft>();
    }
    public void addAircraft(Aircraft aircraft){
        aircraftList.add(aircraft);
    }
    public ArrayList<Aircraft>getAircraft(){
        return aircraftList;
    }
    public ArrayList<Component> logFlightHours(String registrationNumber, int hoursFlown) {
    ArrayList<Component> overdueComponents = new ArrayList<Component>();
    boolean found = false;
    if (registrationNumber == null || registrationNumber.isEmpty()) {
        throw new IllegalArgumentException("Registration number cannot be null or empty");
    }
    if (hoursFlown < 0) {
        throw new IllegalArgumentException("Hours flown cannot be negative");
    }
    for (Aircraft aircraft : aircraftList) {
        String registration = aircraft.getRegistrationNumber();
        if (registrationNumber.equals(registration)) {
            found = true;
            ArrayList<Component> components = aircraft.getComponents();
            for(Component i: components){
                int newHours = i.getCurrentFlightHours() + hoursFlown;
                i.setCurrentFlightHours(newHours);
                if(i.getHoursTillNextMaintenance() <= newHours){
                    overdueComponents.add(i);
                }
            }
        }
    }
    if (!found) {
        throw new AircraftNotFoundException("No aircraft found with registration: " + registrationNumber);
    }
    return overdueComponents;
    }   
    public static void main(String[] args) {
        MaintenanceTracker tracker = new MaintenanceTracker();
        
        Aircraft plane1 = new Aircraft("G-ABCD");
        plane1.addComponent(new Component("ENG001", "Engine", 0,500));
        plane1.addComponent(new Component("LG001", "Landing Gear", 0, 300));
            
        tracker.addAircraft(plane1);
        ArrayList<Component> overdue = tracker.logFlightHours("G-ABCD", 350);
        for (Component c : overdue) {
            System.out.println("The component " + c.getPartNumber() + " needs maintenance");  
        }
        
    }
    
}
