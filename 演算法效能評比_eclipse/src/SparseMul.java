public class SparseMul extends Mul {
    private int count;

    @Override
    public String doc() {
        String rt = new String();
        rt += "�}���x�}�]�^�y�Gsparse matrix�^�A�b�ƭȤ��R���A�O�䤸���j�������s���x�}�C\n";
        rt += "�]A�ONxM���x�}�AB�OMxP���x�}�A�h���̪��x�}�nAB�ONxP���x�}�C\n";
        rt += "A���C�@��column��m�Ӥ������PB������row��m�Ӥ��������ۭ��A�o�ǭ��n���M�N�OAB�����@�Ӥ����C\n";
        rt += "�ۤ񴶳q���x�}���k�A��}���x�}�u����������������0���@���n�A�]���`�ٳ\�h�ɶ�\n";
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
