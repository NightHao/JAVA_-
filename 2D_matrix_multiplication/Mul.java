//此class為所有Mul的模型，abstract的部分代表每種Mul都要有該功能
public abstract class Mul{
	private new2DArray A,B,Ans;//儲存計算的陣列及結果
	private int Ami,Ama,Bmi,Bma,Ansmi,Ansma;//紀錄放入的陣列max和min
	private String output;
	Boolean firstTime;//紀錄是否有算過max和min
	//說明文件
	public abstract String doc();
	//就是get name
	public abstract String getName();

	public String My2DArrToString(int[][] matrix){
		String rt="";
		for(int i=0;i<matrix.length;++i){
			for(int j=0;j<matrix[i].length;++j){
				rt += Integer.toString(matrix[i][j])+" ";
			}
			rt += '\n';
		}
		rt+='\n';
		return rt;
	}
	
	public void print2DArr(int[][] matrix){
		for(int i=0;i<matrix.length;++i){
			for(int j=0;j<matrix[i].length;++j){
				System.out.printf("%d ",matrix[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}
	//主程式，Mul傳入的矩陣
	public abstract int[][] runTest(int [][] A,int [][] B);
	//計算的次數
	public abstract int calTime();

	public void MulMain(int [][] A,int [][] B){
		Ama = Ami = Bma = Bmi = 0;//initialize
		output = "";
		firstTime = true;
		int [][] tmpArrOfA = new int[A.length][A[0].length];
		int [][] tmp2ArrOfA = new int[A.length][A[0].length];
		int [][] tmpArrOfB = new int[B.length][B[0].length];
		int [][] tmp2ArrOfB = new int[B.length][B[0].length];
		for(int i=0;i<A.length;++i){
			for(int j=0;j<A[0].length;++j){
				tmp2ArrOfA[i][j]=tmpArrOfA[i][j]=A[i][j];
			}
		}
		for(int i=0;i<B.length;++i){
			for(int j=0;j<B[0].length;++j){
				tmp2ArrOfB[i][j]=tmpArrOfB[i][j]=B[i][j];
			}
		}
		double time1,time2;
		print2DArr(A);
		print2DArr(B);
		//計時
		time1 = System.currentTimeMillis();
		int [][] ans2DArr = runTest(tmpArrOfA,tmpArrOfB);
		time2 = System.currentTimeMillis();
		print2DArr(ans2DArr);
		//sortStepArr = sortStep(swapTime(),tmp2Arr);
		output+=getName()+" used "+Double.toString(time2-time1)+"ms to multiply 2 matrices \nCalculate Times : "+Integer.toString(calTime());
		System.out.printf("%s used %f to multiply 2 matrices\n",getName(),time2-time1);
		System.out.printf("Calculate Times : %d\n",calTime());
		output+="\nresult:\n"+ My2DArrToString(ans2DArr);
	}

	public String getOutput(){
		return output;
	}

}
