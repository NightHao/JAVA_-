public class InsertionSort extends Sort {
    
    private int count;

    @Override
    public String doc() {
        /*Str1���w�q������*/
        String str1 = "���J�Ƨǡ]�^�y�GInsertion Sort�^�O�@��²�檽�[���ƧǺt��k�C�����u�@��z�O�q�L�c�ئ��ǧǦC�A��󥼱ƧǸ�ơA�b�w�ƧǧǦC���q��V�e���y�A��������m�ô��J�C\n";
        /*Str2��Str8���ƧǨB�J������*/
        String str2 = "��B�J��:\n";
        String str3 = "1.�q�Ĥ@�Ӥ����}�l�A�Ӥ����i�H�{���w�g�Q�Ƨ�\n";
        String str4 = "2.���X�U�@�Ӥ����A�b�w�g�ƧǪ������ǦC���q��V�e���y\n";
        String str5 = "3.�p�G�Ӥ����]�w�Ƨǡ^�j��s�����A�N�Ӥ�������U�@��m\n";
        String str6 = "4.���ƨB�J3�A������w�ƧǪ������p��Ϊ̵���s��������m\n";
        String str7 = "5.�N�s�������J��Ӧ�m\n";
        String str8 = "6.���ƨB�J2~5\n";
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