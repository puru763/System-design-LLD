public abstract class Coffee {
    protected String name;
    protected int temperature;

    public Coffee(String name, int temperature) {
        this.name = name;
        this.temperature = temperature;
    }

    public abstract void brew();

    public String getName() {
        return name;
    }

    public int getTemperature() {
        return temperature;
    }
}
