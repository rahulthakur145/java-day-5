package casestudy6;

import java.util.Scanner;

public class tictactoe{

    static char[] board = {'0','1','2','3','4','5','6','7','8','9'};
    static Scanner sc = new Scanner(System.in);

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
        return (board[1]==board[2] && board[2]==board[3]) ||
               (board[4]==board[5] && board[5]==board[6]) ||
               (board[7]==board[8] && board[8]==board[9]) ||
               (board[1]==board[4] && board[4]==board[7]) ||
               (board[2]==board[5] && board[5]==board[8]) ||
               (board[3]==board[6] && board[6]==board[9]) ||
               (board[1]==board[5] && board[5]==board[9]) ||
               (board[3]==board[5] && board[5]==board[7]);
    }

    public static void play(int turn) {

        if (turn > 9) {
            displayBoard();
            System.out.println("Game Draw!");
            return;
        }

        displayBoard();

        int player = (turn % 2 != 0) ? 1 : 2;
        char mark = (player == 1) ? 'X' : 'O';

        System.out.print("Player " + player + " (" + mark + "), enter slot number (1-9): ");
        int choice = sc.nextInt();

        switch (choice) {
            case 1: case 2: case 3:
            case 4: case 5: case 6:
            case 7: case 8: case 9:
                if (board[choice] != 'X' && board[choice] != 'O') {
                    board[choice] = mark;
                } else {
                    System.out.println("Invalid move! Try again.");
                    play(turn);
                    return;
                }
                break;

            default:
                System.out.println("Invalid choice! Try again.");
                play(turn);
                return;
        }

        if (checkWin()) {
            displayBoard();
            System.out.println("Player " + player + " wins!");
            return;
        }

        play(turn + 1);   // recursion instead of loop
    }

    public static void main(String[] args) {
        play(1);
    }
}
