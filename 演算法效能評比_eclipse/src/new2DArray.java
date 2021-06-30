public class new2DArray {
	private int My2DArraySize, ColSize, RowSize, LowerRange, UpperRange/*,Type*/;
	private int[][] My2DArr/*,Color*/;
    //�]�i�H��Set������}�C����

    //�N�r������r��}�C��A��J
    public new2DArray(String A){
        int l=0;
        for(int i=0;i<A.length();++i){
            if(A.charAt(i)=='\n')++l;
        }
        String[] B = new String [l];
        for(int i=0,k=0;i<A.length();++i){
            if(A.charAt(i)=='\n')++k;
            else B[k]+=A.charAt(i);
        }
        newArray tmp = new newArray(B[0]);
        ColSize = tmp.getArraySize();
        RowSize = B.length;//���i���h�l����
        int mi = Integer.MAX_VALUE, ma = Integer.MIN_VALUE;
        int[][] tmp2DArr = new int[RowSize][ColSize];
        for ( int i = 0 ; i < RowSize ; ++i){
            tmp = new newArray(B[i]);
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
    //��Ū�J�X�k�}�C�ɤ]�i�H�নnew2DArray
    //�Х��ϥ�judge����stringIsArray�P�_�榡�O�_���T
    public new2DArray(String A[]){
        newArray tmp = new newArray(A[0]);
        ColSize = tmp.getArraySize();
        RowSize = A.length;//���i���h�l����
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

    //Set���s��Random Array�ALowerRange/UpperRange�|���O�]���}�C�̤p��/�̤j��
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
    //JAVA���䴩�H���X�R�}�C�A�ҥH�򥻤W�n����


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