import java.util.List;
import java.util.concurrent.PriorityBlockingQueue;

public class ElevatorCar implements Elevator, Runnable {
    private int currentFloor;
    private boolean doorsOpen;
    private final List<Elevator> elevators;
    private final PriorityBlockingQueue<Request> requestQueue;

    public ElevatorCar(List<Elevator> elevators) {
        this.currentFloor = 0; //take   from sensor  in  actual
        this.doorsOpen = false;
        this.elevators = elevators;
        this.requestQueue = new PriorityBlockingQueue<>();
    }

    @Override
    public void run() {
        while (true) {
            try {
                Request requestedFloor = requestQueue.take();
                moveToFloor(requestedFloor.floor);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }

    @Override
    public void moveToFloor(int floor) {
        System.out.println("Going to floor " + floor);
        closeDoors();

        while (currentFloor != floor) {
            if (currentFloor < floor) {
                currentFloor++;
            } else {
                currentFloor--;
            }
            System.out.println("current  floor no is  " + currentFloor);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        openDoors();
    }

    @Override
    public int getCurrentFloor() {
        return currentFloor;
    }

    @Override
    public void openDoors() {
        if (!doorsOpen) {
            doorsOpen = true;
            System.out.println("Doors are now open.");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            closeDoors();
        }
    }

    @Override
    public void closeDoors() {
        if (doorsOpen) {
            doorsOpen = false;
            System.out.println("Doors are now closed.");
        }
    }

    @Override
    public boolean isMoving() {
        return false;
    }

    @Override
    public void requestElevator(int floorNumber) {
        System.out.println("Elevator requested at floor " + floorNumber);
        requestQueue.offer(new Request(floorNumber));
    }

    private static class Request implements Comparable<Request> {
        int floor;

        Request(int floor) {
            this.floor = floor;
        }

        @Override
        public int compareTo(Request o) {
            return Integer.compare(this.floor, o.floor);
        }
    }
}
