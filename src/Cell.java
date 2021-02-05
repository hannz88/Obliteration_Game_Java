public class Cell {
    /* A class that tracks each cell in a  board*/

    private Boolean isOccupy = false;
    private String symbol = "[]";

    // method/ getter to check if a cell is occupied
    public boolean checkIsOccupy(){
        if (isOccupy == true){
            return true;
        }
        return false;
    }

    // setter for the isOccupy
    public void setIsOccupy(){
        this.isOccupy = true;
    }

    // getter for the symbol that occupy the cell
    public String getSymbol(){
        return this.symbol;
    }

    // setter for the symbol
    public void setSymbol(String j){
        this.symbol = j;
    }
}
