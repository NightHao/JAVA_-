public class BubbleSort extends Sort {
    private int count; //計算陣列交換的次數
    @Override
    public String doc() {
        String s1,s2,s3,s4; /*s1...s4代表關於演算法解釋的句子分段 */
        s1 = "泡沫排序（英語：Bubble Sort）又稱為泡式排序，是一種簡單的排序演算法。";
        s2 = "它重複地走訪過要排序的數列，一次比較兩個元素，如果他們的順序錯誤就把他們交換過來。";
        s3 = "走訪數列的工作是重複地進行直到沒有再需要交換，也就是說該數列已經排序完成。";
        s4 = "這個演算法的名字由來是因為越小的元素會經由交換慢慢「浮」到數列的頂端。";
        return String.format("%s\n%s\n%s\n%s\n",s1,s2,s3,s4);
    }

    @Override
    public String getName() { //回傳其排序方法的名稱
        return "BubbleSort";
    }

    @Override
    public int[] runTest(int[] arr) { //進行實際Sort方法的函式
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    count++;
                }
            }
        }
        return arr;
    }

    @Override
    public int swapTime() { //回傳交換次數的函式
        return count;
    }

    @Override
    public newArray[] sortStep(int count,int[] arr){
		int temp,it=0;
		newArray[] sortStepArr = new newArray[count+1];// 交換2次 -> 需要3張圖
		pushnewArray(it++,arr,sortStepArr);//參數分別為(放入的位子,放入的陣列,放入的newArray[])
		for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    pushnewArray(it++,arr,sortStepArr);
                }
            }
        }
		return sortStepArr;
	}
    
}
