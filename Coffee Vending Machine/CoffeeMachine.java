public class CoffeeMachine {
    private static CoffeeMachine instance;

    private Milk milk;
    private HotWater hotWater;

    private CoffeeMachine() {
        milk = new Milk();
        hotWater = new HotWater();
    }

    public static CoffeeMachine getInstance() {
        if (instance == null) {
            instance = new CoffeeMachine();
        }
        return instance;
    }

    public void makeCoffee(Coffee coffee) {
        hotWater.heat();
        milk.steam();
        coffee.brew();
        System.out.println("here is  ur " + coffee.getName() + " enjoiy ");
    }

    public void makeMilk() {
        Milk milk = new Milk();
        milk.steam();
        System.out.println("here is  ur  milk");
    }
}
