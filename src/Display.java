public class Display {
    private int rowNum;
    private int colNum;
    public static final String ansi_RESET = "\u001B[0m";
    public static final String ansi_RED = "\u001B[31m";

    public Display(int width){
        this.rowNum = width;
        this.colNum = width;
    }

    public void displayBoardContent(String[][] arr){
        this.displayColNumber();
        for(int i=0; i<rowNum; i++){
            String iCol = ansi_RED + i + ansi_RESET;
            String tmp = iCol + "\t";
            for(int j=0; j<colNum; j++){
//                tmp[j] = board[i][j].getSymbol();
                tmp += arr[i][j] + "\t";
            }
//            System.out.println(Arrays.toString(tmp));
            System.out.println(tmp);
        }
    }

    public void displayColNumber(){
        // generate a range of numbers for the column
        String colHeader="\t";
        for(int i=0; i<this.colNum; i++){
            String iCol = ansi_RED + i + ansi_RESET;
            colHeader += iCol + "\t";
        }
        System.out.println(colHeader);
    }
}
