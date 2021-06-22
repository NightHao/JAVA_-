public class QuickSort extends Sort{
    private int count,it = 0;
    newArray[] sortStepArr;
    @Override
    public String doc() {
        String s1,s2,s3,s4,s5; /*s1...s5代表關於演算法解釋的句子分段 */
        s1 = "快速排序（英語：Quicksort），又稱分割區交換排序（partition-exchange sort，";
        s2 = "簡稱快排，一種排序演算法，最早由東尼·霍爾提出。在平均狀況下，排序n個項目要O(n log n)次比較。";
        s3 = "在最壞狀況下則需要O(n^2)次比較，但這種狀況並不常見。事實上，";
        s4 = "快速排序Theta(n log n)通常明顯比其他演算法更快，";
        s5 = "因為它的內部迴圈（inner loop）可以在大部分的架構上很有效率地達成。";
        return String.format("%s\n%s\n%s\n%s\n%s\n",s1,s2,s3,s4,s5);
    }

    @Override
    public String getName() {//回傳其排序方法的名稱
        return "QuickSort";
    }

    @Override
    public int[] runTest(int[] arr) {//進行實際Sort方法的呼叫
        quickSort(arr,0,arr.length - 1);
        return arr;
    }

    @Override
    public int swapTime() { //回傳交換次數的函式
        return count;
    }
    public void quickSort(int[] number, int left, int right) { //進行QuickSort的排序
		if (left < right) {
			int q = partition(number, left, right);
			quickSort(number, left, q - 1);
			quickSort(number, q + 1, right);
		}
	}

	private int partition(int number[], int left, int right) { //進行QuickSort重要的分冶動作
		int i = left - 1;
		for (int j = left; j < right; j++) {
			if (number[j] <= number[right]) {
				i++;
                if(i != j){
				    int temp = number[i];
		            number[i] = number[j];
		            number[j] = temp;
                    count++;
                }
			}
		}
        if(i+1 != right){
            int temp = number[i + 1];
            number[i + 1] = number[right];
            number[right] = temp;
            count++;
        }
		return i + 1;
	}

    @Override
    public newArray[] sortStep(int count, int[] arr) {
		sortStepArr = new newArray[count+1];// 交換2次 -> 需要3張圖
		pushnewArray(it++,arr,sortStepArr);
        quickSortStep(arr,0,arr.length - 1);
        return sortStepArr;
    }

    public void quickSortStep(int[] number, int left, int right) { //進行QuickSort的排序
		if (left < right) {
			int q = partitionStep(number, left, right);
			quickSortStep(number, left, q - 1);
			quickSortStep(number, q + 1, right);
		}
	}

	private int partitionStep(int number[], int left, int right) { //進行QuickSort重要的分冶動作
		int i = left - 1;
		for (int j = left; j < right; j++) {
			if (number[j] <= number[right]) {
				i++;
                if(i!=j){
				    int temp = number[i];
		            number[i] = number[j];
		            number[j] = temp;
                    pushnewArray(it++,number,sortStepArr);
                }
			}
		}
        if(i+1 != right){
            int temp = number[i + 1];
            number[i + 1] = number[right];
            number[right] = temp;
            pushnewArray(it++,number,sortStepArr);
        }
		return i + 1;
	}

	/*private void swap(int[] data, int i, int j) {
		int temp = data[i];
		data[i] = data[j];
		data[j] = temp;
	}*/

}
