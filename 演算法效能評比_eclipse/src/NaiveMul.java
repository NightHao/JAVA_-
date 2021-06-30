public class NaiveMul extends Mul {

    private int count;

    @Override
    public String doc() {
        String rt = new String();
        rt += "�̭�l���x�}���k�A�u���b�Ĥ@�ӯx�}��column�M�ĤG�ӯx�}��row�ۦP�ɤ~���w�q�C\n";
        rt += "�]A�ONxM���x�}�AB�OMxP���x�}�A�h���̪��x�}�nAB�ONxP���x�}�CA���C�@��column��m�Ӥ������PB������row��m�Ӥ��������ۭ��A�o�ǭ��n���M�N�OAB�����@�Ӥ����C\n";
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