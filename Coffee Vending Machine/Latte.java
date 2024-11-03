public class Latte extends Coffee {
    public Latte() {
        super("Latte", 100);
    }

    @Override
    public void brew() {
        System.out.println("brewing a delicious Latte enjoy" );
    }
}
