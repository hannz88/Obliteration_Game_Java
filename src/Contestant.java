public class Contestant {
    public String symbol;
    private int rowLim;
    private int colLim;

    public Contestant(String j, int width){
        // constructor
        this.symbol = j;
        this.rowLim = width;
        this.colLim = width;
    }

    // getter for the symbol
    public String getContestantSymbol(){
        return this.symbol;
    }

    // getter for the rowLim
    public int getRowLim(){
        return this.rowLim;
    }

    // getter for the colLim
    public int getColLim(){
        return this.colLim;
    }

}
