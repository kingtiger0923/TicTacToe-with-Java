import java.util.Arrays;

public class GameState {

    private char[][] board;


    public GameState() {
        board = new char[3][3];
        for (char[] chars : board) {
            Arrays.fill(chars, ' ');
        }
    }

    public GameState(GameState otherState) {
        board = new char[3][3];
        for (int i = 0; i < board.length; i++) {
            System.arraycopy(otherState.board[i], 0, board[i], 0, board[i].length);
        }
    }


    public void setMove(Move move) {
        board[move.getRow()][move.getCol()] = move.getPlayer();
    }

    public boolean checkWinner(char player) {
        if (board[0][0] == player && board[0][1] == player && board[0][2] == player) return true;
        if (board[1][0] == player && board[1][1] == player && board[1][2] == player) return true;
        if (board[2][0] == player && board[2][1] == player && board[2][2] == player) return true;
        if (board[0][0] == player && board[1][0] == player && board[2][0] == player) return true;
        if (board[0][1] == player && board[1][1] == player && board[2][1] == player) return true;
        if (board[0][2] == player && board[1][2] == player && board[2][2] == player) return true;
        if (board[0][0] == player && board[1][1] == player && board[2][2] == player) return true;
        if (board[0][2] == player && board[1][1] == player && board[2][0] == player) return true;
        return false;
    }

    public boolean isValidMove(int row, int col) {
        if (row < 0 || row > 2 || col < 0 || col > 2) {
            System.out.printf("(%d, %d) is invalid.\n", row, col);
            return false;
        }
        return board[row][col] == ' ';
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        builder.append(getRowAsString(0)).append("\n");
        builder.append(getDividerString()).append("\n");
        builder.append(getRowAsString(1)).append("\n");
        builder.append(getDividerString()).append("\n");
        builder.append(getRowAsString(2)).append("\n");

        return builder.toString();
    }


    private String getRowAsString(int row) {
        return " " + board[row][0] + " | " + board[row][1] + " | " + board[row][2];
    }

    private String getDividerString() {
        return "---+---+---";
    }

    public boolean validMovesRemaining() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == ' ') {
                    return true;
                }
            }
        }
        return false;
    }
}
