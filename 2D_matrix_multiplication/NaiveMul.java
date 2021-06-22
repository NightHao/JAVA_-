public class NaiveMul extends Mul {

    private int count;

    @Override
    public String doc() {
        String rt = new String();
        rt += "最原始的矩陣乘法，只有在第一個矩陣的column和第二個矩陣的row相同時才有定義。\n";
        rt += "設A是NxM的矩陣，B是MxP的矩陣，則它們的矩陣積AB是NxP的矩陣。A中每一個column的m個元素都與B中對應row的m個元素對應相乘，這些乘積的和就是AB中的一個元素。\n";
        return rt;
    }

    @Override
    public String getName() {
        return "Naive Algorithm";
    }

    public int[][] runTest(int[][] A, int[][] B) {
        count = 0;
        int arow = A.length, acol = A[0].length, brow = B.length, bcol = B[0].length;
        int[][] R = new int[arow][bcol];
        for (int i = 0; i < arow; ++i) {
            for (int j = 0; j < bcol; ++j) {
                R[i][j] = 0;
                for (int k = 0; k < acol; ++k) {
                    R[i][j] += A[i][k] * B[k][j];
                    count++;
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