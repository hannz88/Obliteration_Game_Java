import javax.imageio.IIOException;
import java.io.IOException;
import java.util.Scanner;

public class Player extends Contestants{
    private int playerRowCoord;
    private int playerColCoord;
    public static final String ansi_RESET = "\u001B[0m";
    public static final String ansi_BLUE = "\u001B[34m";

//    private Scanner sc;

    public Player(String j, int width){
        super(j, width);
//        this.sc = sc;
    }

    public void askPlayerRowCoord (Scanner sc){
        // method to ask player to key in a row coord
        boolean isInt = false;
        while(isInt == false){
            System.out.println("Please enter the row coordinate of the next step:");
            if(sc.hasNextInt()){
                int input = sc.nextInt();
                if((input < 0) || (input >= this.getRowLim())){  // if the value is out of the boundary
                    System.out.println("Value out of bound.");
                    continue;
                }
                this.playerRowCoord = input;
                isInt = true;
            } else if(sc.hasNextLine()){
                sc.nextLine();
                int bufferLen = 0;
                try{
                    bufferLen = System.in.available();
                } catch (IOException ignored){}
                if (bufferLen > 0){
                    sc.nextLine();
                }
                System.out.println("Invalid input for row");
            }
        }
    }

    public void askPlayerColCoord (Scanner sc){
        // method to ask player to key in a row coord
        boolean isInt = false;
        while(isInt == false){
            System.out.println("Please enter the column coordinate of the next step:");
            if(sc.hasNextInt()){  // if the input is not int
                int input = sc.nextInt();
                if((input < 0) || (input >= this.getColLim())){  // if the value is out of the boundary
                    System.out.println("Value out of bound.");
                    continue;
                }
                this.playerColCoord = input;
                isInt = true;
            } else if(sc.hasNextLine()){
                sc.nextLine();  // clear the line
                int bufferLen = 0;
                try{
                    bufferLen = System.in.available();
                } catch (IOException ignored){}
                if (bufferLen > 0){
                    sc.nextLine();
                }
                System.out.println("Invalid input for column");
            }
        }
    }

    public int getPlayerRowCoord() {
        // get the row coordinate of the player
        return this.playerRowCoord;
    }

    public int getPlayerColCoord(){
        // get the colummn coordinate of the player
        return this.playerColCoord;
    }

    @Override
    public String getContestantSymbol(){
        return ansi_BLUE + this.symbol + ansi_RESET;
    }
}
