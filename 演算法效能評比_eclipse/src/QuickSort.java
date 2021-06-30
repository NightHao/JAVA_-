public class QuickSort extends Sort{
    private int count,it = 0;
    newArray[] sortStepArr;
    @Override
    public String doc() {
        String s1,s2,s3,s4,s5; /*s1...s5�N������t��k�������y�l���q */
        s1 = "�ֳt�Ƨǡ]�^�y�GQuicksort�^�A�S�٤��ΰϥ洫�Ƨǡ]partition-exchange sort�A";
        s2 = "²�٧ֱơA�@�رƧǺt��k�A�̦��ѪF���P�N�����X�C�b�������p�U�A�Ƨ�n�Ӷ��حnO(n log n)������C";
        s3 = "�b���a���p�U�h�ݭnO(n^2)������A���o�ت��p�ä��`���C�ƹ�W�A";
        s4 = "�ֳt�Ƨ�Theta(n log n)�q�`������L�t��k��֡A";
        s5 = "�]�����������j��]inner loop�^�i�H�b�j�������[�c�W�ܦ��Ĳv�a�F���C";
        return String.format("%s\n%s\n%s\n%s\n%s\n",s1,s2,s3,s4,s5);
    }

    @Override
    public String getName() {//�^�Ǩ�ƧǤ�k���W��
        return "QuickSort";
    }

    @Override
    public int[] runTest(int[] arr) {//�i����Sort��k���I�s
        quickSort(arr,0,arr.length - 1);
        return arr;
    }

    @Override
    public int swapTime() { //�^�ǥ洫���ƪ��禡
        return count;
    }
    public void quickSort(int[] number, int left, int right) { //�i��QuickSort���Ƨ�
		if (left < right) {
			int q = partition(number, left, right);
			quickSort(number, left, q - 1);
			quickSort(number, q + 1, right);
		}
	}

	private int partition(int number[], int left, int right) { //�i��QuickSort���n�����M�ʧ@
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
		sortStepArr = new newArray[count+1];// �洫2�� -> �ݭn3�i��
		pushnewArray(it++,arr,sortStepArr);
        quickSortStep(arr,0,arr.length - 1);
        return sortStepArr;
    }

    public void quickSortStep(int[] number, int left, int right) { //�i��QuickSort���Ƨ�
		if (left < right) {
			int q = partitionStep(number, left, right);
			quickSortStep(number, left, q - 1);
			quickSortStep(number, q + 1, right);
		}
	}

	private int partitionStep(int number[], int left, int right) { //�i��QuickSort���n�����M�ʧ@
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
