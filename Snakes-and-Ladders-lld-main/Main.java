import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        GameBoard gameBoard = new GameBoard();
        gameBoard.addSnake(23, 4);
        gameBoard.addSnake(35, 12);
        gameBoard.addSnake(55, 32);
        gameBoard.addSnake(69, 2);
        gameBoard.addSnake(99, 55);

        gameBoard.addLadder(4, 23);
        gameBoard.addLadder(23, 67);
        gameBoard.addLadder(45, 88);
        gameBoard.addLadder(82, 94);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Press 1 to play against the computer.");
        System.out.println("Press 2 to play with 2 players.");
        System.out.println("Press 3 to play with 3 players.");
        System.out.println("Press 4 to play with 4 players.");
        int selectGame = scanner.nextInt();

        switch (selectGame) {
            case 1:
                System.out.println("You chose to play against the computer.");
                playAgainstComputer(scanner, gameBoard);
                break;
            case 2:
                System.out.println("You chose to play  gainst  1  player");
                playAgainstComputer(scanner, gameBoard);
                break;
            case 3:
                System.out.println("You chose to play against 2  player ");
                playAgainstComputer(scanner, gameBoard);
                break;
            case 4:
                System.out.println("You chose to play with " + selectGame + " players.");
                playWithMultiplePlayers(scanner, gameBoard, selectGame);
                break;
            default:
                System.out.println("Invalid choice. Please press 1, 2, 3, or 4.");
                break;
        }

        scanner.close();
    }

    private static void playAgainstComputer(Scanner scanner, GameBoard gameBoard) {
        Dice dice = new Dice();
        Player humanPlayer = new HumanPlayer("Human", dice, 0);
        Player computerPlayer = new Computerplayer("Computer", dice, 0);
        Player[] players = {humanPlayer, computerPlayer};

        playGame(players, gameBoard);
    }

    private static void playWithMultiplePlayers(Scanner scanner, GameBoard gameBoard, int numberOfPlayers) {
        Dice dice = new Dice();
        Player[] players = new Player[numberOfPlayers];

        for (int i = 0; i < numberOfPlayers; i++) {
            System.out.print("Enter name for Player " + (i + 1) + ": ");
            String playerName = scanner.next();
            players[i] = new HumanPlayer(playerName, dice, 0);
        }

        playGame(players, gameBoard);
    }

    private static void playGame(Player[] players, GameBoard gameBoard) {
        boolean gameWon = false;

        while (!gameWon) {
            for (Player player : players) {
                System.out.println(player.getName() + "  you chnace to  roll  dice ");
                new Scanner(System.in).nextLine();
                int roll = player.getDice().rollDice();
                System.out.println(player.getName() + " rolled a " + roll);
                player.setPosition(player.getPosition() + roll);

                player.setPosition(gameBoard.snakeBite(player.getPosition()));
                player.setPosition(gameBoard.useLadder(player.getPosition()));

                if (player.getPosition() >= 100) {
                    System.out.println(player.getName() + " you are the  winner ");
                    gameWon = true;
                    break;
                }

                System.out.println(player.getName() + " is now on position " + player.getPosition());
            }
        }
    }
}
