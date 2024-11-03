public class Cappuccino extends Coffee {
    public Cappuccino() {
        super("cappuccino", 100);
    }

    @Override
    public void brew() {
        System.out.println("brewing cappuccino");
    }
}
