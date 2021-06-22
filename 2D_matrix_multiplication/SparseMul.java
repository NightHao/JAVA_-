public class SparseMul extends Mul {
    private int count;

    @Override
    public String doc() {
        String rt = new String();
        rt += "稀疏矩陣（英語：sparse matrix），在數值分析中，是其元素大部分為零的矩陣。\n";
        rt += "設A是NxM的矩陣，B是MxP的矩陣，則它們的矩陣積AB是NxP的矩陣。\n";
        rt += "A中每一個column的m個元素都與B中對應row的m個元素對應相乘，這些乘積的和就是AB中的一個元素。\n";
        rt += "相比普通的矩陣乘法，其稀疏矩陣只對兩邊對應元素不為0的作乘積，因此節省許多時間\n";
        return rt;
    }

    @Override
    public String getName() {
        return "Sparse Algorithm";
    }

    public int[][] runTest(int[][] A, int[][] B) {
        count = 0;
        int aRow = A.length, aCol = A[0].length, bRow = B.length, bCol = B[0].length;
        int[][] R = new int[aRow][bCol];
        for (int i = 0; i < aRow; ++i) {
            for (int k = 0; k < aCol; ++k) {
                if (A[i][k] != 0) {
                    for (int j = 0; j < bCol; ++j) {
                        if (B[k][j] != 0){
                            R[i][j] += A[i][k] * B[k][j];
                            count++;
                        }
                    }
                }
            }
        }
        return R;
    }

    @Override
	public int calTime(){
		return count;
	}

}
