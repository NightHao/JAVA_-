public class new2DArray {
	private int My2DArraySize, ColSize, RowSize, LowerRange, UpperRange/*,Type*/;
	private int[][] My2DArr/*,Color*/;
    //也可以像Set直接丟陣列產生

    //當讀入合法陣列時也可以轉成new2DArray
    //請先使用judge中的stringIsArray判斷格式是否正確
    public new2DArray(String A[]){
        newArray tmp = new newArray(A[0]);
        ColSize = tmp.getArraySize();
        RowSize = A.length;//不可有多餘換行
        int mi = Integer.MAX_VALUE, ma = Integer.MIN_VALUE;
        int[][] tmp2DArr = new int[RowSize][ColSize];
        for ( int i = 0 ; i < RowSize ; ++i){
            tmp = new newArray(A[i]);
            ColSize = tmp.getArraySize();
            tmp2DArr[i] = new int[ColSize];
            tmp2DArr[i] = tmp.getArray();
            mi = Math.min(mi, tmp.getLowerRange());
            ma = Math.max(ma, tmp.getUpperRange()); 
        }
        My2DArr = tmp2DArr;
        My2DArraySize = ColSize * RowSize;
        LowerRange = mi;
        UpperRange = ma;
    }

    //Set成新的Random Array，LowerRange/UpperRange會分別設為陣列最小值/最大值
    public new2DArray(int[][] A) {
		My2DArr = A;
        int mi = Integer.MAX_VALUE, ma = Integer.MIN_VALUE;
        RowSize = A.length;
        ColSize = A[0].length;
		for (int i = 0; i < RowSize; ++i) {
            for (int j = 0; j < ColSize; ++j) {
                mi = Math.min(mi, A[i][j]);
                ma = Math.max(ma, A[i][j]);
            }
        } 
        My2DArraySize = ColSize * RowSize;
        LowerRange = mi - 1;
        UpperRange = ma + 1;
    }

	public new2DArray(int[][] A, int min, int max) {
		My2DArr = A;
        RowSize = A.length;
        ColSize = A[0].length;
        My2DArraySize = ColSize * RowSize;
        LowerRange = min;
        UpperRange = max;
    }

    @Override
    public String toString() {
        String rt = "";
        rt += "ArraySize : " + My2DArraySize;
        rt += "\nRange of ArraySize[i] : " + LowerRange + " < ArraySize[i] < " + UpperRange + "\n";
        rt += "RowSize : " + RowSize + "\nColSize : " + ColSize;
        rt += "\n";
        for (int i = 0; i < RowSize; ++i) {
            for (int j = 0; j < ColSize; ++j) {
                rt += My2DArr[i][j] + " ";
            }
            rt += "\n";
        }
        rt += "\n";
        return rt;
    }
    //JAVA不支援隨時擴充陣列，所以基本上要重建


    public int get2DArraySize() {
        return My2DArraySize;
    }

    public int getLowerRange() {
        return LowerRange;
    }

    public int getUpperRange() {
        return UpperRange;
    }

    public int getColSize() {
        return ColSize;
    }

    public int getRowSize() {
        return RowSize;
    }

    public int[][] get2DArray() {
        return My2DArr;
    }
}