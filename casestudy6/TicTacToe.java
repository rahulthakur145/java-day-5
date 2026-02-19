package casestudy6;
import java.util.Scanner;

public class TicTacToe {

    static char[] board = {'0','1','2','3','4','5','6','7','8','9'};

    public static void displayBoard() {
        System.out.println();
        System.out.println(" " + board[1] + " | " + board[2] + " | " + board[3]);
        System.out.println("---|---|---");
        System.out.println(" " + board[4] + " | " + board[5] + " | " + board[6]);
        System.out.println("---|---|---");
        System.out.println(" " + board[7] + " | " + board[8] + " | " + board[9]);
        System.out.println();
    }

    public static boolean checkWin() {
        if (board[1]==board[2] && board[2]==board[3]) return true;
        if (board[4]==board[5] && board[5]==board[6]) return true;
        if (board[7]==board[8] && board[8]==board[9]) return true;

        if (board[1]==board[4] && board[4]==board[7]) return true;
        if (board[2]==board[5] && board[5]==board[8]) return true;
        if (board[3]==board[6] && board[6]==board[9]) return true;

        if (board[1]==board[5] && board[5]==board[9]) return true;
        if (board[3]==board[5] && board[5]==board[7]) return true;

        return false;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int player = 1, choice;
        char mark;

        for (int i = 1; i <= 9; i++) {

            displayBoard();

            player = (i % 2 != 0) ? 1 : 2;
            mark = (player == 1) ? 'X' : 'O';

            System.out.print("Player " + player + " (" + mark + "), enter slot number (1-9): ");
            choice = sc.nextInt();

            if (choice >= 1 && choice <= 9 && board[choice] != 'X' && board[choice] != 'O') {
                board[choice] = mark;
            } else {
                System.out.println("Invalid move! Try again.");
                i--; 
                continue;
            }

            if (checkWin()) {
                displayBoard();
                System.out.println("Player " + player + " wins!");
                sc.close();
                return;
            }
        }

        displayBoard();
        System.out.println("Game Draw!");
        sc.close();
    }
}
