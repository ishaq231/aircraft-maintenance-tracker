import java.util.ArrayList;

public class Aircraft {
    private String registrationNumber;
    private ArrayList<Component> components;
    
    public Aircraft(String registrationNumber) {
        this.registrationNumber = registrationNumber;
        this.components = new ArrayList<Component>();
    }
    public void addComponent(Component component){
        components.add(component);

    }
    public String getRegistrationNumber(){
        return registrationNumber;
    }
    public ArrayList<Component> getComponents(){
        return components;
    }
}