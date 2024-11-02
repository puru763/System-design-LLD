public class InnerPanel {
    private final Elevator elevator;

    public InnerPanel(Elevator elevator) {
        this.elevator = elevator;
    }

    public void pressButton(int floor) {
        System.out.println("Inner panel pressed button for floor " + floor);
        elevator.requestElevator(floor);
    }
}
