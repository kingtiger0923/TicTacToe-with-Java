import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        GameState state = new GameState();
        Scanner charScanner = new Scanner(System.in);

        System.out.println("Welcome! Would you like to play as X or O?");

        char playerCharacter;

        do {
            playerCharacter = charScanner.next().toUpperCase().charAt(0);
        } while (playerCharacter != 'X' && playerCharacter != 'O' && playerCharacter != 'x' && playerCharacter != 'o');

        Player xPlayer, oPlayer;
        String computerName = "COMPUTER";

        if (playerCharacter == 'X') {
            xPlayer = new HumanPlayer(playerCharacter);
            oPlayer = new ComputerPlayer(oppositeCharacterOf(playerCharacter), computerName);
        } else {
            oPlayer = new HumanPlayer(playerCharacter);
            xPlayer = new ComputerPlayer(oppositeCharacterOf(playerCharacter), computerName);
        }

        System.out.println(state);
        while (true) {
            if (playMoveFor(state, xPlayer)) break;
            if (playMoveFor(state, oPlayer)) break;
        }

    }

    static char oppositeCharacterOf(char c) {
        return c == 'X' ? 'O' : 'X';
    }

    private static boolean playMoveFor(GameState state, Player player) {
        Move move;
        move = player.getMoveFor(state);
        state.setMove(move);
        System.out.println(state);

        if (isWinner(state, player)) return true;
        if (isDraw(state)) return true;
        return false;
    }

    private static boolean isWinner(GameState state, Player player) {
        if (state.checkWinner(player.getCharacter())) {
            System.out.println(createWinnerString(player));
            return true;
        }
        return false;
    }

    private static boolean isDraw(GameState state) {
        if (!state.validMovesRemaining()) {
            System.out.println("=== DRAW ===");
            return true;
        }
        return false;
    }

    private static String createWinnerString(Player player) {
        return "--- " + player.getName() + " WINS! ---";
    }

}
