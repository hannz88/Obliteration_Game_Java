/* Building on the discussion of coupling and cohesion for
        * the O's and X's (tic-tac-toe) game.  Implement the game
        * Obstruction
        *
        * http://www.papg.com/show?2XMX
        * http://www.lkozma.net/game.html
        */

import java.util.Scanner;

class Main {
    private String lastPlayer;
    private static Game game;
    public static void main(String[] args) {
        System.out.println("Hello world!");
        try(Scanner sc = new Scanner(System.in)) {
            game = new Game(sc);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}