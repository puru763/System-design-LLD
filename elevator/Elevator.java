public interface Elevator {
    void moveToFloor(int floor);
    int getCurrentFloor();
    void openDoors();
    void closeDoors();
    boolean isMoving();
    void requestElevator(int floorNumber);
}
