public class InsertionSort extends Sort {
    
    private int count;

    @Override
    public String doc() {
        /*Str1為定義之說明*/
        String str1 = "插入排序（英語：Insertion Sort）是一種簡單直觀的排序演算法。它的工作原理是通過構建有序序列，對於未排序資料，在已排序序列中從後向前掃描，找到相應位置並插入。\n";
        /*Str2到Str8為排序步驟之說明*/
        String str2 = "其步驟為:\n";
        String str3 = "1.從第一個元素開始，該元素可以認為已經被排序\n";
        String str4 = "2.取出下一個元素，在已經排序的元素序列中從後向前掃描\n";
        String str5 = "3.如果該元素（已排序）大於新元素，將該元素移到下一位置\n";
        String str6 = "4.重複步驟3，直到找到已排序的元素小於或者等於新元素的位置\n";
        String str7 = "5.將新元素插入到該位置\n";
        String str8 = "6.重複步驟2~5\n";
        return str1 + str2 + str3 + str4 + str5 + str6 + str7 + str8;
    }

    @Override
    public String getName() {
        return "InsertionSort";
    }

    @Override
    public int[] runTest(int[] arr) {
        count = 0;
        int temp;
        for(int i=0; i < arr.length; ++i) {
            int j = i;
            while((j > 0) && (arr[j - 1] > arr[j])) {
                temp = arr[j - 1];
                arr[j - 1] = arr[j];
                arr[j] = temp;
                count++;
                j--;
            }
        }
        return arr;     
    }

    @Override
    public int swapTime() {
        return count;
    }

    public newArray[] sortStep(int count, int[] arr) {
        int temp, it = 0;
        newArray[] sortStepArr = new newArray[count + 2];
        pushnewArray(it++, arr, sortStepArr);
        for (int i = 1; i < arr.length; ++i) {
            int j = i;
            while ((j > 0) && (arr[j - 1] > arr[j])) {
                temp = arr[j - 1];
                arr[j - 1] = arr[j];
                arr[j] = temp;
                pushnewArray(it++, arr, sortStepArr);
                j--;
            }
        }
        return sortStepArr;
    }
}