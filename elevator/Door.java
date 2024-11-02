public class Door {
    private boolean isOpen;

    public Door() {
        this.isOpen = false;
    }

    public void open() {
        isOpen = true;
        System.out.println("door open");
    }

    public void close() {
        isOpen = false;
        System.out.println("door closed");
    }

    public boolean isOpen() {
        return isOpen;
    }
}
