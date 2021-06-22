public class StrassenMul extends Mul{
	
	private int count;
	
	@Override
	public String doc(){
		String rt = new String();
		rt += "施特拉森演算法（英語：Strassen algorithm）是一個計算矩陣乘法的演算法，時間複雜度為O(n^lg7)~=O(n^2.807)。\n";
		rt += "施特拉森演算法在1969年由沃爾克·施特拉森提出來，是第一個時間複雜度低於O(n^3)的矩陣乘法演算法。\n";
		rt += "施特拉森演算法因為只有每次的分治法（英語：Divide and conquer algorithm）只有七個矩陣乘法運算，\n";
		rt += "所以依照主定理（英語：Master theorem）可以得出時間複雜度為O(n^2.807)。\n";
		rt += "但Strassen演算法的數值穩定性較差。(PS:由於技術不足，目前只能處理長度相同且為2的覓次的方陣相乘)\n";
		return rt;
	}
	//Override記得寫
	@Override
	public String getName(){
		return "Strassen Algorithm";
	}

	public int[][] runTest(int[][] A, int[][] B){
		count = 0;
		//分治法下子集合的陣列長度必須每次重算
        int n = A.length;
        // 技術問題，此方法只適用於方陣
        int[][] R = new int[n][n];
 
        // Base case
        // If there is only single element
        if (n == 1)
            R[0][0] = A[0][0] * B[0][0];

        else {
            // Step 1: Dividing Matrix into parts by storing sub-parts to variables
            int[][] A11 = new int[n / 2][n / 2];
            int[][] A12 = new int[n / 2][n / 2];
            int[][] A21 = new int[n / 2][n / 2];
            int[][] A22 = new int[n / 2][n / 2];
            int[][] B11 = new int[n / 2][n / 2];
            int[][] B12 = new int[n / 2][n / 2];
            int[][] B21 = new int[n / 2][n / 2];
            int[][] B22 = new int[n / 2][n / 2];
 
            // Step 2: Dividing matrix A into 4 halves
            split(A, A11, 0, 0);
            split(A, A12, 0, n / 2);
            split(A, A21, n / 2, 0);
            split(A, A22, n / 2, n / 2);
 
            // Step 3: Dividing matrix B into 4 halves
            split(B, B11, 0, 0);
            split(B, B12, 0, n / 2);
            split(B, B21, n / 2, 0);
            split(B, B22, n / 2, n / 2);
 
            // Using Formulas as described in algorithm
 
            // M1:=(A1+A3)×(B1+B2)
            int[][] M1 = runTest(add(A11, A22), add(B11, B22));
            // M2:=(A2+A4)×(B3+B4)
            int[][] M2 = runTest(add(A21, A22), B11);
            // M3:=(A1−A4)×(B1+A4)
            int[][] M3 = runTest(A11, sub(B12, B22));
            // M4:=A1×(B2−B4)
            int[][] M4 = runTest(A22, sub(B21, B11));
            // M5:=(A3+A4)×(B1)
            int[][] M5 = runTest(add(A11, A12), B22);
            // M6:=(A1+A2)×(B4)
            int[][] M6 = runTest(sub(A21, A11), add(B11, B12));
            // M7:=A4×(B3−B1)
            int[][] M7 = runTest(sub(A12, A22), add(B21, B22));
            // P:=M2+M3−M6−M7
            int[][] C11 = add(sub(add(M1, M4), M5), M7);
            // Q:=M4+M6
            int[][] C12 = add(M3, M5);
            // R:=M5+M7
            int[][] C21 = add(M2, M4);
            // S:=M1−M3−M4−M5
            int[][] C22 = add(sub(add(M1, M3), M2), M6);
 
            // Step 4: Join 4 halves into one result matrix
            join(C11, R, 0, 0);
            join(C12, R, 0, n / 2);
            join(C21, R, n / 2, 0);
            join(C22, R, n / 2, n / 2);
        }
 
        // Step 5: Return result
        return R;
    }
 
    // Function to subtract two matrices
    public int[][] sub(int[][] A, int[][] B){
        int n = A.length;//分治法下子集合的陣列長度必須每次重算
        int[][] C = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                C[i][j] = A[i][j] - B[i][j];
        return C;
    }
 
    // Function to add two matrices
    public int[][] add(int[][] A, int[][] B){
        int n = A.length;//分治法下子集合的陣列長度必須每次重算
        int[][] C = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                C[i][j] = A[i][j] + B[i][j];
        return C;
    }
 
    // Function to split parent matrix into child matrices
    public void split(int[][] P, int[][] C, int iB, int jB){
        // Iterating over elements of 2D matrix using nested for loops
        for (int i1 = 0, i2 = iB; i1 < C.length; i1++, i2++)
            for (int j1 = 0, j2 = jB; j1 < C.length;j1++, j2++)
                C[i1][j1] = P[i2][j2];
    }
 
    // Function to join child matrices into (to) parent matrix
    public void join(int[][] C, int[][] P, int iB, int jB){
        // Iterating over elements of 2D matrix using nested for loops
        for (int i1 = 0, i2 = iB; i1 < C.length; i1++, i2++)
            for (int j1 = 0, j2 = jB; j1 < C.length;j1++, j2++)
                P[i2][j2] = C[i1][j1];
    }
 
	@Override
	public int calTime(){
		return -1;//該演算法紀錄和計算混雜，不方便紀錄計算次數
	}
	
}
