import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import org.junit.jupiter.api.BeforeEach;

public class MaintenanceTrackerTest {
    private MaintenanceTracker tracker;
    private Aircraft plane;
    
    @BeforeEach
    public void setUp() {
        tracker = new MaintenanceTracker();
        plane = new Aircraft("G-TEST");
        plane.addComponent(new Component("ENG001", "Engine", 0, 500));
        plane.addComponent(new Component("LG001", "Landing Gear", 0, 300));
        tracker.addAircraft(plane);
    }
    
    @Test
    public void testAddComponentIncreasesListSize() {
        assertEquals(2, plane.getComponents().size());
    }
    @Test
    public void testLogFlightHoursFlagsOverdueComponent(){
        ArrayList<Component> overdue = tracker.logFlightHours("G-TEST", 350);
        assertEquals(1, overdue.size());
        assertEquals("LG001", overdue.get(0).getPartNumber());
    }
    @Test
    public void testLogFlightHoursThrowsWhenAircraftNotFound() {
        assertThrows(AircraftNotFoundException.class, () -> {
        tracker.logFlightHours("NONEXISTENT", 100);
    });
    }
    @Test
    public void testLogFlightHoursThrowsWhenRegistrationIsEmpty() {
        assertThrows(IllegalArgumentException.class, () -> {
        tracker.logFlightHours(null, 30);
    });
    }
    @Test
    public void testLogFlighthoursThrowsWhenHoursFlownIsEnpty(){
        assertThrows(IllegalArgumentException.class, () -> {
            tracker.logFlightHours("G-TEST", -34);
        });
    }

}