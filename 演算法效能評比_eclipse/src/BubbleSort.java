public class BubbleSort extends Sort {
    private int count; //�p��}�C�洫������
    @Override
    public String doc() {
        String s1,s2,s3,s4; /*s1...s4�N������t��k�������y�l���q */
        s1 = "�w�j�Ƨǡ]�^�y�GBubble Sort�^�S�٬��w���ƧǡA�O�@��²�檺�ƧǺt��k�C";
        s2 = "�����Ʀa���X�L�n�ƧǪ��ƦC�A�@�������Ӥ����A�p�G�L�̪����ǿ��~�N��L�̥洫�L�ӡC";
        s3 = "���X�ƦC���u�@�O���Ʀa�i�檽��S���A�ݭn�洫�A�]�N�O���ӼƦC�w�g�Ƨǧ����C";
        s4 = "�o�Ӻt��k���W�r�ѨӬO�]���V�p�������|�g�ѥ洫�C�C�u�B�v��ƦC�����ݡC";
        return String.format("%s\n%s\n%s\n%s\n",s1,s2,s3,s4);
    }

    @Override
    public String getName() { //�^�Ǩ�ƧǤ�k���W��
        return "BubbleSort";
    }

    @Override
    public int[] runTest(int[] arr) { //�i����Sort��k���禡
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
    public int swapTime() { //�^�ǥ洫���ƪ��禡
        return count;
    }

    @Override
    public newArray[] sortStep(int count,int[] arr){
		int temp,it=0;
		newArray[] sortStepArr = new newArray[count+1];// �洫2�� -> �ݭn3�i��
		pushnewArray(it++,arr,sortStepArr);//�ѼƤ��O��(��J����l,��J���}�C,��J��newArray[])
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
