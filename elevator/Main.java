import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Elevator> elevators = new ArrayList<>();
        ElevatorCar elevatorCar = new ElevatorCar(elevators);
        elevators.add(elevatorCar);

        new Thread(elevatorCar).start();

        elevatorCar.requestElevator(1);
        elevatorCar.requestElevator(2);
        elevatorCar.requestElevator(4);
        elevatorCar.requestElevator(3);
        elevatorCar.requestElevator(5);
    }
}
