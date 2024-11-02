public class OuterPanel {
    private final Elevator elevator;

    public OuterPanel(Elevator elevator) {
        this.elevator = elevator;
    }

    public void pressButton(int floor) {
        System.out.println("Outer panel pressed button for floor " + floor);
        elevator.requestElevator(floor);
    }
}
