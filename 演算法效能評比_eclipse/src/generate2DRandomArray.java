import java.util.Random;

public class generate2DRandomArray {

    private int My2DArraySize, LowerRange, UpperRange, ColSize, RowSize;
    private int[][] Random2DArray;

    public generate2DRandomArray(int RowSize, int ColSize, int LowerRange, int UpperRange) {
        if(RowSize<=0){
            System.out.println("Error value of variable RowSize,set them to 4");
            RowSize = 4;
        }   
        if(ColSize<=0){
            System.out.println("Error value of variable ColSize,set them to 4");
            ColSize = 4;
        }  
        if (LowerRange > UpperRange) {
            System.out.println("Error value of variable LowerRange//UpperRange,set them to 0//100");
            LowerRange=0;
            UpperRange=100;
        }
        this.LowerRange = LowerRange;
        this.UpperRange = UpperRange;
        this.RowSize = RowSize;
        this.ColSize = ColSize;
        this.My2DArraySize = RowSize*ColSize;
        int[][] Random2DArray = new int [RowSize][ColSize];
        Random rd = new Random();
        for (int i = 0; i < RowSize; ++i) {
            for (int j = 0; j < ColSize; ++j) {
                Random2DArray[i][j] = (int)((rd.nextFloat() * (UpperRange - LowerRange - 1)) + LowerRange + 1); //To Do
            }
        }
        this.Random2DArray = Random2DArray;
    }

    public void setRandomArray(int[][] Array){
        int mi = Integer.MAX_VALUE, ma = Integer.MIN_VALUE;
        RowSize = Array.length;
        ColSize = Array[0].length;
        My2DArraySize = RowSize * ColSize;
        for(int i = 0; i < RowSize; ++i) {
            for (int j = 0; j < ColSize; ++j) {
                mi = Math.min(mi, Array[i][j]);
                ma = Math.max(ma, Array[i][j]);
            }
        }
        Random2DArray = Array;
        LowerRange = mi - 1;
        UpperRange = ma + 1;
    }

    @Override
    public String toString() {
        String rt = "";
        rt += "ArraySize : " + My2DArraySize;
        rt += "\nRange of ArraySize[i][j] : " + LowerRange + " < ArraySize[i][j] < " + UpperRange + "\n";
        rt += "RowSize : " + RowSize + "\nColSize : " + ColSize;
        rt += "\n";
        for (int i = 0; i < RowSize; ++i) {
            for (int j = 0; j < ColSize; ++j) {
                rt += Random2DArray[i][j] + " ";
            }
            rt += "\n";
        }
        rt += "\n";
        return rt;
    }

    public int getArraySize(){
        return My2DArraySize;
    }

    public int getLowerRange(){
        return LowerRange;
    }

    public int getUpperRange(){
        return UpperRange;
    }

    public int getRowSize(){
        return RowSize;
    }

    public int getColSize(){
        return ColSize;
    }

    public int[][] getArray(){
        return Random2DArray;
    }

    public static String doc(){
        return "It can generate an Random (int[][]) 2DArray.";
    }
}