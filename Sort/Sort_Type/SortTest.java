public class SortTest {
	//供自行test，之後會做出簡單的互動介面代替
	public static void main(String args[]) {
		Sort Test1 = new SelectionSort();
		Sort Test2 = new BubbleSort();
		Sort Test3 = new QuickSort();
		Sort Test4 = new MergeSort();
		int [] TestArr = {15,7,5,2,4,3,1};
		System.out.println(Test1.doc());
		Test1.SortMain(TestArr);
		System.out.println(Test4.doc());
		Test4.SortMain(TestArr);
		/*ResetTestArr(TestArr);
		System.out.println(Test2.doc());
		Test2.SortMain(TestArr);
		ResetTestArr(TestArr);
		System.out.println(Test3.doc());
		Test3.SortMain(TestArr);
		ResetTestArr(TestArr);*/
		
		newArray testSortStep[] = Test1.getsortStep();
		for(int i=0;i<=Test1.swapTime();++i){
			System.out.println(testSortStep[i]);
		}
		testSortStep = Test4.getsortStep();
		for(int i=0;i<=Test4.swapTime();++i){
			System.out.println(testSortStep[i]);
		}
	}
	/*public static int[] ResetTestArr(int[] TestArr){
		for(int i = 0; i < TestArr.length; ++i){
			TestArr[i] = TestArr.length - i;
		}
		return TestArr;
	}*/
}