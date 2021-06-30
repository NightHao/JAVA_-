public class SelectionSort extends Sort {

	private int count;

	@Override
	public String doc() {
		String rt = new String();
		rt += "��ܱƧǡ]Selection sort�^�O�@��²�檽�[���ƧǺt��k�C�����u�@��z�p�U�G\n";
		rt += "�����b���ƧǧǦC�����̤p�]�j�^�����A�s���ƧǧǦC���_�l��m�A�M��A�A�q\n";
		rt += "�Ѿl���ƧǤ������~��M��̤p�]�j�^�����A�é��w�ƧǧǦC�������C�H�������A\n";
		rt += "����Ҧ��������Ƨǧ����C��ܱƧǪ��D�n�u�I�P��Ʋ��ʦ����C�p�G�Y�Ӥ������\n";
		rt += "���T���̲צ�m�W�A�h�����|�Q���ʡC��ܱƧǨC���洫�@�露���A���̷��ܤ֦�\n";
		rt += "�@�ӱN�Q�����̲צ�m�W�A�]����n�Ӥ�������i��Ƨ��`�@�i��ܦh�]n��1�^����\n";
		rt += "���C�b�Ҧ��������̾a�洫�h���ʤ������ƧǤ�k���A��ܱƧ��ݩ�D�`�n���@�ءC\n";
		return rt;
	}

	// Override�O�o�g
	@Override
	public String getName() {
		return "SelectionSort";
	}

	@Override
	public int[] runTest(int[] arr) {
		count = 0;
		int temp;
		for (int i = 0; i < arr.length; ++i) {
			int min = i;
			for (int j = i + 1; j < arr.length; ++j)
				if (arr[j] < arr[min])
					min = j;
			if (min != i) {
				++count;
				temp = arr[min];
				arr[min] = arr[i];
				arr[i] = temp;
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
		newArray[] sortStepArr = new newArray[count + 1];// �洫2�� -> �ݭn3�i��
		pushnewArray(it++, arr, sortStepArr);// �ѼƤ��O��(��J����l,��J���}�C,��J��newArray[])
		for (int i = 0; i < arr.length; ++i) {
			int min = i;
			for (int j = i + 1; j < arr.length; ++j)
				if (arr[j] < arr[min])
					min = j;
			if (min != i) {
				temp = arr[min];
				arr[min] = arr[i];
				arr[i] = temp;
				pushnewArray(it++, arr, sortStepArr);
			}
		}
		return sortStepArr;
	}

}
