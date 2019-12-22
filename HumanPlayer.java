import java.util.Scanner;

public class HumanPlayer implements Player {

    private char character;
    private Scanner scanner = new Scanner(System.in);


    public HumanPlayer(char character) {
        this.character = character;
    }


    @Override
    public Move getMoveFor(GameState state) {
        System.out.println("Your move?");

        int row;
        int col;

        do {
            System.out.print("Please enter a row between 0 and 2: ");
            row = scanner.nextInt();
            System.out.print("Please enter a col between 0 and 2: ");
            col = scanner.nextInt();
        } while (!state.isValidMove(row, col));

        return new Move(row, col, character);
    }

    @Override
    public String getName() {
        return "PLAYER";
    }

    @Override
    public char getCharacter() {
        return character;
    }
}
