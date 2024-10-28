public class Player {


    private String name;
    public int position;
    public Dice dice;

    public Player(String name, Dice dice, int position) {
        this.name = name;
        this.dice = new Dice();
        this.position = position;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public Dice getDice() {
        return dice;
    }

    public void setDice(Dice dice) {
        this.dice = dice;
    }

}
