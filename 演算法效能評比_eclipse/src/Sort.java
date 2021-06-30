//��class���Ҧ�sort���ҫ��Aabstract�������N��C��sort���n���ӥ\��
public abstract class Sort {
	private newArray[] sortStepArr;// �x�s�ƧǮɪ��C�Ӱ}�C
	private int[] tmpArr, tmp2Arr;// �x�s�ƧǦn���}�C
	private int mi, ma;// ������J���}�Cmax�Mmin
	private String output;
	Boolean firstTime;// �����O�_����Lmax�Mmin
	private Judge JJ = new Judge();
	private Double totalTime;

	// �������
	public abstract String doc();

	// �N�Oget name
	public abstract String getName();

	public String arrToString(int[] arr) {
		String rt = "";
		for (int i = 0; i < arr.length; ++i)
			rt += Integer.toString(arr[i]) + " ";
		rt += '\n';
		return rt;
	}

	public void printArr(int[] arr) {
		for (int i = 0; i < arr.length; ++i)
			System.out.printf("%d ", arr[i]);
		System.out.println();
	}

	// �D�{���Asort�ǤJ���}�C
	public abstract int[] runTest(int arr[]);

	// �p��swap������
	public abstract int swapTime();

	public void SortMain(int[] arr) {
		ma = mi = 0;// initialize
		output = "";
		firstTime = true;
		tmpArr = new int[arr.length];
		tmp2Arr = new int[arr.length];
		for (int i = 0; i < arr.length; ++i) {
			tmp2Arr[i] = tmpArr[i] = arr[i];
		}
		double time1, time2;
		printArr(arr);
		// �p��
		time1 = System.currentTimeMillis();
		tmpArr = runTest(tmpArr);
		time2 = System.currentTimeMillis();
		totalTime = time2 - time1;
		printArr(tmpArr);
		if (JJ.canDraw(swapTime(), arr.length) == true) {
			sortStepArr = sortStep(swapTime(), tmp2Arr);
		}
		output += getName() + " used " + Double.toString(time2 - time1) + "ms to sort the array\nSwap Times : "
				+ Integer.toString(swapTime());
		System.out.printf("%s used %f to sort the array\n", getName(), time2 - time1);
		System.out.printf("Swap Times : %d\n", swapTime());
		output += "\nresult:" + arrToString(tmpArr);
	}

	// �аѦ�runTest�g�XsortStep(MergeSort��Selection�w����)
	public abstract newArray[] sortStep(int count, int[] arr);

	public String getOutput() {
		return output;
	}

	public newArray[] getsortStep() {
		return sortStepArr;
	}

	// �NsortStep�����ͪ��}�C�নnewArray���JsortStepArr�o��newArray�}�C��
	public void pushnewArray(int it, int[] input, newArray[] sortStepArr) {
		int[] inputArr = new int[input.length];
		for (int i = 0; i < input.length; ++i) {
			inputArr[i] = input[i];
		}
		newArray t;
		if (firstTime == true) {
			t = new newArray(inputArr);
			mi = t.getLowerRange();
			ma = t.getUpperRange();
		} else {
			t = new newArray(inputArr, mi, ma);
		}
		sortStepArr[it] = t;
	}

	public Double getTime() {
		return totalTime;
	}
}
