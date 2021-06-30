public class MergeSort extends Sort {

	@Override
	public String doc() {
		/* Str1��Str4���w�q������ */
		String str1 = "�X�ֱƧǡ]�^�y:Merge sort�^�A�O�إߦb�X�־ާ@�W���@�ئ��Ī��ƧǺt��k�A�Ӻt��k�O�ĥΤ��v�k�]�^��W��:Divide and Conquer�^���@�ӫD�`�嫬�����ΡA�B�U�h���v���j�i�H�P�ɶi��C\n";
		String str2 = "�X�־ާ@�]�^��W��:merge�^�A�]�s�X�ֺt��k�A�����O�N��Ӥw�g�ƧǪ��ǦC�X�֦��@�ӧǦC���ާ@�C�X�ֱƧǺt��k�̿�X�־ާ@�C\n";
		String str3 = "����:���j�a���e�ǦC�������Φ���b�C\n";
		String str4 = "�X��:�b�O���������Ǫ��P�ɱN�W�@�B�o�쪺�l�ǦC��X��@�_\n";
		/* Str5��Str8���ƧǨB�J������ */
		String str5 = "��B�J��:(���]�ǦC�@��N�Ӥ���)\n";
		String str6 = "1.�N�ǦC�C�۾F��ӼƦr�i��X�־ާ@�A�Φ�(N/2)�ӧǦC�A�Ƨǫ�C�ӧǦC�]�t��өΤ@�Ӥ���\n";
		String str7 = "2.�Y���ɧǦC�Ƥ��O1�ӫh�N�W�z�ǦC�A���X�֡A�Φ�(N/4)�ӧǦC�A�C�ӧǦC�]�t�|�өΤT�Ӥ���\n";
		String str8 = "3.���ƨB�J2�A����Ҧ������Ƨǧ����A�Y�ǦC�Ƭ�1\n";
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
				if (left + i / 2 >= arr.length) {
					mid = arr.length - 1;
				} else {
					mid = left + i / 2;
				}
				int right;
				if (i * (j + 1) - 1 >= arr.length) {
					right = arr.length - 1;
				} else {
					right = i * (j + 1) - 1;
				}
				int start = left, l = left, m = mid;
				while (l < mid && m <= right) {
					if (arr[l] < arr[m]) {
						orderedArr[start++] = arr[l++];
					} else {
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

	public newArray[] sortStep(int count, int[] arr) {
		newArray sortStepArr[] = new newArray[0];
		return sortStepArr;
	}
}