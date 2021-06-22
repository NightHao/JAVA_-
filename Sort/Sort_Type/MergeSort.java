public class MergeSort extends Sort {

    @Override
    public String doc() {
        /*Str1到Str4為定義之說明*/
        String str1 = "合併排序（英語:Merge sort），是建立在合併操作上的一種有效的排序演算法，該演算法是採用分治法（英文名稱:Divide and Conquer）的一個非常典型的應用，且各層分治遞迴可以同時進行。\n";
        String str2 = "合併操作（英文名稱:merge），也叫合併演算法，指的是將兩個已經排序的序列合併成一個序列的操作。合併排序演算法依賴合併操作。\n";
        String str3 = "分割:遞迴地把當前序列平均分割成兩半。\n";
        String str4 = "合併:在保持元素順序的同時將上一步得到的子序列整合到一起\n";
        /*Str5到Str8為排序步驟之說明*/
        String str5 = "其步驟為:(假設序列共有N個元素)\n";
        String str6 = "1.將序列每相鄰兩個數字進行合併操作，形成(N/2)個序列，排序後每個序列包含兩個或一個元素\n";
        String str7 = "2.若此時序列數不是1個則將上述序列再次合併，形成(N/4)個序列，每個序列包含四個或三個元素\n";
        String str8 = "3.重複步驟2，直到所有元素排序完畢，即序列數為1\n";
        return str1 + str2 + str3 + str4 + str5 + str6 + str7 + str8;
    }

    @Override
    public String getName() {
        return "MergeSort";
    }

    @Override
    public int[] runTest(int[] arr) {
        int[] orderedArr = new int[arr.length];
        for (int i = 2; i < arr.length * 2; i *= 2) {
            for (int j = 0; j < (arr.length + i - 1) / i; j++) {
                int left = i * j;
                int mid;
                if(left + i / 2 >= arr.length) {
                    mid = arr.length - 1;
                }
                else {
                    mid = left + i / 2;
                }
                int right;
                if (i * (j + 1) - 1 >= arr.length) {
                    right = arr.length - 1;
                }
                else {
                    right = i * (j + 1) - 1;
                }
                int start = left, l = left, m = mid;
                while (l < mid && m <= right) {
                    if (arr[l] < arr[m]) {
                        orderedArr[start++] = arr[l++];
                    } 
                    else {
                        orderedArr[start++] = arr[m++];
                    }
                }
                while (l < mid) {
                    orderedArr[start++] = arr[l++];
                }
                while (m <= right) {
                    orderedArr[start++] = arr[m++];
                }
                System.arraycopy(orderedArr, left, arr, left, right - left + 1);
            }
        }
        return arr;
    }

    @Override
    public int swapTime() {
        return -1;
    }

    public newArray[] sortStep(int count,int[] arr){
        newArray sortStepArr[] = new newArray[0];
		return sortStepArr;
	}
}