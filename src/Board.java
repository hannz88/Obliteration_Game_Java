import java.util.Arrays;

public class Board {
    private int rowNum;
    private int colNum;
    private int width;
    private Cell[][] board;
    private int totalSpacesAvailable;

    public Board(int width){
        // set up a new Board with each square is a Cell object
        rowNum = width;
        colNum = width;
        this.width = width;
        totalSpacesAvailable = rowNum*colNum;
        board = new Cell[width][width];
        for (int i=0; i<width; i++){
            for(int j=0; j<width; j++){
                board[i][j] = new Cell();
            }
        }
    }

    public int getBoardWidth(){
        // getter for the board width
        return this.width;
    }

    public void setTerritory(int rowCoord, int colCoord, String playerSymbol){
        // set the cells in the surrounding as the territory
        for(int i = rowCoord-1; i <= rowCoord+1; i++){
            if((i < 0) || (i >= rowNum)){  // while the row is within the boundary of the board
                continue;
            }
            for (int j = colCoord-1; j <= colCoord+1; j++){
                if ((j < 0) || (j >= colNum)){  // while the column is within the boundary of the board
                    continue;
                }
                if(this.board[i][j].checkIsOccupy()==false){
                    this.board[i][j].setIsOccupy();
                    this.board[i][j].setSymbol(playerSymbol);
                    this.totalSpacesAvailable -= 1;
                }
            }
        }
    }

    public boolean isValidMove(int rowCoord, int colCoord){
        // method to check the coordinate is valid
        if ((rowCoord < 0) || (rowCoord >= this.rowNum)){
            return false;
        } else if((colCoord < 0) || (colCoord >= colNum)){
            return false;
        } else if (this.board[rowCoord][colCoord].checkIsOccupy()==true){
            return false;
        }
        return true;
    }

    public boolean setTerritoryIfValidMove(int rowCoord, int colCoord, String playerSymbol){
        // method that makes use of isValidMove and setTerritory
        if(isValidMove(rowCoord, colCoord) == true){
            this.setTerritory(rowCoord, colCoord, playerSymbol);
            return true;
        }
        return false;
    }

    public boolean isFullyOccupied(){
        // method to check if the board is fully occupied
        if (totalSpacesAvailable <= 0){
            return true;  // true when it's fully occupied
        }
        return false;
    }

    public String[][] getBoard(){
        // return 2d array of symbols
        String[][] array = new String[this.width][this.width];
        for(int i=0; i<rowNum; i++){
            for(int j=0; j<colNum; j++){
                array[i][j] = this.board[i][j].getSymbol();
            }
        }
        return array;
    }

}
