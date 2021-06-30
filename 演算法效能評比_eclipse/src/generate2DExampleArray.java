public class generate2DExampleArray {
    private int My2DArraySize, LowerRange, UpperRange, RowSize, ColSize;
    private int[][] Example2DArray;

    public generate2DExampleArray() {
        int[][] Example2DArray = {{1,50,66,-11,5}, {5,6,11,20,8}};
        this.Example2DArray = Example2DArray;
        RowSize = 2;
        ColSize = 5;
        My2DArraySize = 10;
        LowerRange = -12;
        UpperRange = 67;
    }

    public void setExampleArray(int[][] Array){
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
        Example2DArray = Array;
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
                rt += Example2DArray[i][j] + " ";
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
        return Example2DArray;
    }

    public static String doc(){
        return "It can generate an Example (int[][]) 2DArray.";
    }
}