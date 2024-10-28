import java.util.ArrayList;
import java.util.List;

public class GameBoard {
    private Player[] players;
    private List<Snake> snakes;
    private List<Ladder> ladders;

    public GameBoard() {
        this.players = new Player[4];
        this.snakes = new ArrayList<>();
        this.ladders = new ArrayList<>();
    }

    public GameBoard(Player[] players, List<Snake> snakes, List<Ladder> ladders) {
        this.players = players;
        this.snakes = snakes;
        this.ladders = ladders;
    }

    public Player[] getPlayers() {
        return players;
    }

    public void setPlayers(Player[] players) {
        this.players = players;
    }

    public List<Snake> getSnakes() {
        return snakes;
    }

    public void setSnakes(List<Snake> snakes) {
        this.snakes = snakes;
    }

    public List<Ladder> getLadders() {
        return ladders;
    }

    public void setLadders(List<Ladder> ladders) {
        this.ladders = ladders;
    }

    @Override
    public String toString() {
        return "GameBoard{" +
                "players=" + players +
                ", snakes=" + snakes +
                ", ladders=" + ladders +
                '}';
    }

    public void addPlayer() {}

    public void addSnake(int start, int end) {
        snakes.add(new Snake(start, end));
    }

    public void addLadder(int start, int end) {
        ladders.add(new Ladder(start, end));
    }

    public int snakeBite(int position) {
        for (Snake snake : snakes) {
            if (position == snake.getStart()) {
                position = snake.getEnd();
            }
        }
        return position;
    }

    public int useLadder(int position) {
        for (Ladder ladder : ladders) {
            if (position == ladder.getStart()) {
                position = ladder.getEnd();
            }
        }
        return position;
    }
}
