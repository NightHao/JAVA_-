//此class為所有sort的模型，abstract的部分代表每種sort都要有該功能
public abstract class Sort{
	private newArray[] sortStepArr;//儲存排序時的每個陣列
	private int[] tmpArr,tmp2Arr;//儲存排序好的陣列
	private int mi,ma;//紀錄放入的陣列max和min
	private String output;
	Boolean firstTime;//紀錄是否有算過max和min
	private Judge JJ=new Judge();
	private Double totalTime;
	//說明文件
	public abstract String doc();
	//就是get name
	public abstract String getName();

	public String arrToString(int[] arr){
		String rt="";
		for(int i=0;i<arr.length;++i)
			rt += Integer.toString(arr[i])+" ";
		rt+='\n';
		return rt;
	}
	
	public void printArr(int[] arr){
		for(int i=0;i<arr.length;++i)
			System.out.printf("%d ",arr[i]);
		System.out.println();
	}
	//主程式，sort傳入的陣列
	public abstract int[] runTest(int arr[]);
	//計算swap的次數
	public abstract int swapTime();

	public void SortMain(int [] arr){
		ma = mi = 0;//initialize
		output = "";
		firstTime = true;
		tmpArr = new int[arr.length];
		tmp2Arr = new int[arr.length];
		for(int i=0;i<arr.length;++i){
			tmp2Arr[i]=tmpArr[i]=arr[i];
		}
		double time1,time2;
		printArr(arr);
		//計時
		time1 = System.currentTimeMillis();
		tmpArr = runTest(tmpArr);
		time2 = System.currentTimeMillis();
		totalTime = time2-time1;
		printArr(tmpArr);
		if(JJ.canDraw(swapTime(), arr.length)==true){
			sortStepArr = sortStep(swapTime(),tmp2Arr);
		}
		output+=getName()+" used "+Double.toString(time2-time1)+"ms to sort the array\nSwap Times : "+Integer.toString(swapTime());
		System.out.printf("%s used %f to sort the array\n",getName(),time2-time1);
		System.out.printf("Swap Times : %d\n",swapTime());
		output+="\nresult:"+arrToString(tmpArr);
	}

	//請參考runTest寫出sortStep(MergeSort跟Selection已完成)
	public abstract newArray[] sortStep(int count,int[] arr);

	public String getOutput(){
		return output;
	}

	public newArray[] getsortStep(){
		return sortStepArr;
	}

	//將sortStep中產生的陣列轉成newArray後放入sortStepArr這個newArray陣列裡
	public void pushnewArray(int it,int[] input,newArray[] sortStepArr){
		int[] inputArr = new int[input.length];
		for(int i=0;i<input.length;++i){
			inputArr[i]=input[i];
		}
		newArray t;
		if(firstTime==true){
			t = new newArray(inputArr);
			mi = t.getLowerRange();
			ma = t.getUpperRange();
		}
		else{
			t = new newArray(inputArr,mi,ma);
		}
		sortStepArr[it]=t;
	}
	public Double getTime(){
		return totalTime;
	}
}
