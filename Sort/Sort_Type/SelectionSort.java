public class SelectionSort extends Sort{
	
	private int count;
	
	@Override
	public String doc(){
		String rt = new String();
		rt += "選擇排序（Selection sort）是一種簡單直觀的排序演算法。它的工作原理如下：\n";
		rt += "首先在未排序序列中找到最小（大）元素，存放到排序序列的起始位置，然後，再從\n";
		rt += "剩餘未排序元素中繼續尋找最小（大）元素，並放到已排序序列的末尾。以此類推，\n";
		rt += "直到所有元素均排序完畢。選擇排序的主要優點與資料移動有關。如果某個元素位於\n";
		rt += "正確的最終位置上，則它不會被移動。選擇排序每次交換一對元素，它們當中至少有\n";
		rt += "一個將被移到其最終位置上，因此對n個元素的表進行排序總共進行至多（n－1）次交\n";
		rt += "換。在所有的完全依靠交換去移動元素的排序方法中，選擇排序屬於非常好的一種。\n";
		return rt;
	}
	//Override記得寫
	@Override
	public String getName(){
		return "SelectionSort";
	}

	@Override
	public int[] runTest(int [] arr){
		count = 0;
		int temp;
		for(int i=0;i<arr.length;++i){
			int min=i;
			for(int j=i+1;j<arr.length;++j)
				if(arr[j]<arr[min])
					min=j;
			if(min!=i){
				++count;
				temp = arr[min];
				arr[min] = arr[i];
				arr[i] = temp;
			}
		}
		return arr;
	}

	@Override
	public int swapTime(){
		return count;
	}

	public newArray[] sortStep(int count,int[] arr){
		int temp,it=0;
		newArray[] sortStepArr = new newArray[count+1];// 交換2次 -> 需要3張圖
		pushnewArray(it++,arr,sortStepArr);//參數分別為(放入的位子,放入的陣列,放入的newArray[])
		for(int i=0;i<arr.length;++i){
			int min=i;
			for(int j=i+1;j<arr.length;++j)
				if(arr[j]<arr[min])
					min=j;
			if(min!=i){
				temp = arr[min];
				arr[min] = arr[i];
				arr[i] = temp;
				pushnewArray(it++,arr,sortStepArr);
			}
		}
		return sortStepArr;
	}
	
}
