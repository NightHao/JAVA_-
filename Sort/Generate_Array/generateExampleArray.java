public class generateExampleArray {
    private int ArraySize, LowerRange, UpperRange;
    private int[] ExampleArray;

    public generateExampleArray() {
        int[] ExampleArray = {9, 6, 8, 7, 4, 5, 2, 3};
        this.ExampleArray = ExampleArray;
        ArraySize = 8;
        LowerRange = 1;
        UpperRange = 10;
    }

    public void setExampleArray(int[] Array){
        ArraySize = Array.length;
        int mi = Integer.MAX_VALUE, ma = Integer.MIN_VALUE;
        for(int i = 0; i < ArraySize; ++i) {
            mi = Math.min(mi, Array[i]);
            ma = Math.max(ma, Array[i]);
        } 
        ExampleArray = Array;
        LowerRange = mi - 1;
        UpperRange = ma + 1;
    }

    @Override
    public String toString() {
        String rt = "";
        rt += "ArraySize : " + ArraySize;
        rt += "\nRange of ArraySize[i] : " + LowerRange + " < ArraySize[i] < " + UpperRange + "\n";
        for(int i = 0; i < ArraySize; ++i) {
            rt += ExampleArray[i] + " ";
        }
        rt += "\n";
        return rt;
    }

    public int getArraySize(){
        return ArraySize;
    }

    public int getLowerRange(){
        return LowerRange;
    }

    public int getUpperRange(){
        return UpperRange;
    }

    public int[] getArray(){
        return ExampleArray;
    }

    public static String doc(){
        String str;
        str = "";
        str += "在創建此類別時，會產生一個由系統所決定的預設陣列\n";
        return str;
    }
}