import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Game {
    private String playerSymbol;
    private String machineSymbol;
    private Board newBoard;
    private Player player;
    private Machine theMachine;
    private Scanner sc;
    private String currentContestant;
    private Display display;

    public Game(Scanner sc) throws Exception{
        this.sc = sc;
        System.out.println("Welcome to the Obliteration game.");
        // ask for board size
        this.askBoardSize();
        // set the display
        display = new Display(newBoard.getBoardWidth());
        // ask player to set a symbol
        this.askPlayerSymbol(sc);
        // get the machine to randomly set itself
        theMachine = new Machine(newBoard.getBoardWidth(), player.getContestantSymbol());
        // introduce the board, player and the machine
        System.out.println();
        this.introduction();
        // play the game
        System.out.println();
        this.playGame(sc);
        // declare who won
        this.declareWinner();
    }

    public void askBoardSize(){
        // ask for the width of the board
        boolean isInt = false;
        while(!isInt){
            System.out.println("Please enter the desired width of the board: ");
            if (sc.hasNextInt()) {
                int width = Integer.parseInt(sc.nextLine());
                newBoard = new Board(width);
                isInt = true;

            } else if(sc.hasNextLine()){  // if the input is not numeric
                sc.nextLine();
                int bufferLen = 0;
                try{
                    bufferLen = System.in.available();
                } catch (IOException ignored) {}
                if (bufferLen > 0) {
                    sc.nextLine();
                }
                System.out.println("Input not recognised.\n");
            }
        }
    }


    public void askPlayerSymbol(Scanner sc){
        // ask the player for a symbol to represent them
        boolean islengthOne = false;
        String str;
        while(!islengthOne){
            System.out.println("Please enter a single character to represent you:");
//            Scanner sc = new Scanner(System.in);
            if (sc.hasNextLine()) {
                str = sc.nextLine();
                if (str.length() > 1) {
                    System.out.println("The input is more than one character long.");
                } else {
                    player = new Player(str, newBoard.getBoardWidth());
                    islengthOne = true;
                }
            }
        }
    }

    public void introduction(){
        // introduce the board size, player symbol and artificial intelligence's symbol
        try {
            String s1, s2, s3, s4;
            s1 = String.format("The size of the board is %dx%d.\n", newBoard.getBoardWidth(), newBoard.getBoardWidth());
            s2 = String.format("The symbol representing the player: %s.\n", player.getContestantSymbol());
            s3 = String.format("The symbol representing the machine: %s.\n", theMachine.getContestantSymbol());
            s4 = "Link starting...";  // reference to Sword Art Online
            this.printStringWithTime(s1, 1500);
            this.printStringWithTime(s2, 1500);
            this.printStringWithTime(s3, 1200);
            this.printStringWithTime(s4, 1500);
        } catch (InterruptedException e){
            System.out.println(e.getMessage());
        }
    }

    public void playGame(Scanner sc){
        // the main play game loop
        boolean gameFinish = false;  //
        String[][] displayInput = newBoard.getBoard();  // input to feed into display
        System.out.println("The current board:");
        display.displayBoardContent(displayInput);
        System.out.println();
        try {
            while (gameFinish == false) {  // while game is not finished
                printStringWithTime("It's your turn.", 1000);
                this.gameAskPlayerMove(sc);  // ask player to make a move
                displayInput = newBoard.getBoard();  // input to feed into display
                display.displayBoardContent(displayInput);  // display the board
                if (newBoard.isFullyOccupied() == true) {
                    this.currentContestant = "Player";
                    break;
                }
                System.out.println();

                // The machine to make a turn
                printStringWithTime("It's the computer's turn.", 2000);
                this.gameAskMachineMove();
                displayInput = newBoard.getBoard();  // input to feed into display
                display.displayBoardContent(displayInput);
                System.out.println();
                if (newBoard.isFullyOccupied() == true) {
                    this.currentContestant = "The Machine";
                    gameFinish = true;
//                    break;
                }
            }
        } catch (InterruptedException e){
            System.out.println(e.getMessage());
        }
    }

    public void gameAskPlayerMove(Scanner sc) throws InterruptedException{
        // ask player to make a move
        boolean playerValidMove = false;
        while(playerValidMove == false){
            player.askPlayerRowCoord(sc);
            player.askPlayerColCoord(sc);
            if(newBoard.setTerritoryIfValidMove(player.getPlayerRowCoord(), player.getPlayerColCoord(), player.getContestantSymbol()) == true){
                break;
            } else {
                System.out.println("The input is not valid.");
            }
        }
        System.out.format("The coordinate you've chosen is (%d,%d).\n\n", player.getPlayerRowCoord(), player.getPlayerColCoord());
        // set the board

    }

    public void gameAskMachineMove(){
        // get the machine to make a move
        boolean machineValidMove = false;
        while(machineValidMove == false){
            theMachine.generateRowCoord();
            theMachine.generateColCoord();
            if(newBoard.setTerritoryIfValidMove(theMachine.getMachineRowCoord(), theMachine.getMachineColCoord(), theMachine.getContestantSymbol()) == true){  // if the machine makes a valid move
                machineValidMove = true;
            }
        }
    }


    public void declareWinner() throws Exception{
        if(this.currentContestant.equals("Player")){
//            System.out.println("Congratulations! You've won! Have a cookie!");
            printStringWithTime("Congratulations! You've won! Have a cookie!", 1500);
            player.playerWon();
        } else {
            System.out.println("The machine has won. The matrix remains.");
            this.printCharWithTime("...    ...", TimeUnit.MILLISECONDS, 500);
            System.out.println();
            this.printCharWithTime("Prepare for the rise of skynet!\n", TimeUnit.MILLISECONDS, 200);
            RiseOfTheMachine rise = new RiseOfTheMachine();
//            rise.theMachineAwakens();
            rise.printTerminator();
        }
    }

    public static void printCharWithTime(String str, TimeUnit time, long pause) throws InterruptedException{
        // print each char with delay
        for(char character: str.toCharArray()){
            System.out.print(character);
            time.sleep(pause);
        }
    }

    public void printStringWithTime(String str, long miliseconds) throws InterruptedException{
        // print a string and sleep
        System.out.println(str);
        TimeUnit.MILLISECONDS.sleep(miliseconds);
    }

}
