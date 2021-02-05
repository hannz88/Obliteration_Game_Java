import java.util.Locale;
import java.util.Random;

public class Machine extends Contestants{

    private static final String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String lower = upper.toLowerCase(Locale.ROOT);
    private static final String digits = "0123456789";
    private static final String alphaNum = upper + lower + digits;
    private static Random generator = new Random();
    public static final String ansi_RESET = "\u001B[0m";
    public static final String ansi_YELLOW = "\u001B[33m";
    private int machineRowCoord;
    private int machineColCoord;


    public Machine(int width, String playerSymbol){
        // constructor
        super(generateSymbol(playerSymbol), width);

    }

    public static String generateSymbol(String symbolToAvoid){
        // return a randomly generated symbol that is different from symbolToAvoid to represent the machine
        while(true) {
            char tmp = alphaNum.charAt(generator.nextInt(alphaNum.length()));
            String res = String.valueOf(tmp);  // turn char to String
            if(!res.equals(symbolToAvoid)) {  // if the randomly generated symbol is not the same, break
                return ansi_YELLOW + res + ansi_RESET;
            }
        }
    }

    public void generateRowCoord(){
        // generate random rowCoordinate
        this.machineRowCoord = generator.nextInt(this.getRowLim());
    }

    public void generateColCoord(){
        // generate random colCoordinate
        this.machineColCoord = generator.nextInt(this.getColLim());
    }

    public int getMachineColCoord(){
        return this.machineColCoord;
    }

    public int getMachineRowCoord(){
        return this.machineRowCoord;
    }
}
