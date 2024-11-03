public class Main {
    public static void main(String[] args) {

        CoffeeMachine coffeeMachine = CoffeeMachine.getInstance();

        coffeeMachine.makeMilk();
        Coffee latte = new Latte();
        Coffee cappuccino = new Cappuccino();
        coffeeMachine.makeCoffee(latte);
        coffeeMachine.makeCoffee(cappuccino);


    }
}
