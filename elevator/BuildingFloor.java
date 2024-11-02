import java.util.List;

public class BuildingFloor {
    private final int floorNumber;
    private final List<Elevator> elevators;

    public BuildingFloor(int floorNumber, List<Elevator> elevators) {
        this.floorNumber = floorNumber;
        this.elevators = elevators;
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public void callElevator() {
        System.out.println("elevator called to floor no " + floorNumber);
        requestElevator();
    }



    private void requestElevator() {
        Elevator bestElevator = findBestElevator();
        if (bestElevator != null) {
            bestElevator.moveToFloor(floorNumber);
        } else {
            System.out.println("elevatro car is not available");
        }
    }

    private Elevator findBestElevator() {
        Elevator bestElevator = null;
        int closestDistance = Integer.MAX_VALUE;

        for (Elevator elevator : elevators) {
            int elevatorFloor = elevator.getCurrentFloor();
            int distance = Math.abs(elevatorFloor - floorNumber);

            if (!elevator.isMoving() && distance < closestDistance) {
                closestDistance = distance;
                bestElevator = elevator;
            }
        }
        return bestElevator;
    }

    public void pressUpButton() {
        System.out.println("up button pressed on floor " + floorNumber);
        callElevator();
    }

    public void pressDownButton() {
        System.out.println("down button pressed on floor " + floorNumber);
        callElevator();
    }
}
