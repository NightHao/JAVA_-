import java.util.Arrays;
public class newArray {
	private int ArraySize,LowerRange,UpperRange/*,Type*/;
	private int[] Arr/*,Color*/;
    //�]�i�H��Set������}�C����

    //��Ū�J�X�k�}�C�ɤ]�i�H�নnewArray
    //�Х��ϥ�judge����stringIsArray�P�_�榡�O�_���T
    public newArray(String A){
        int size=0,ff=0;
        //��}�C�j�p 
        for(int i=0;i<A.length();++i){
            if((A.charAt(i)>='0'&&A.charAt(i)<='9')||A.charAt(i)=='-'){
                if(ff==0){
                    ++size;
                    ff=1;
                }
            }
            else{
                ff=0;
            }
        }
        ArraySize = size;
        int[] tmpArr = new int[ArraySize];
        int mi = Integer.MAX_VALUE , ma = Integer.MIN_VALUE , it=0;
        String tmp="";
        for(int i=0;i<A.length();++i){
            if((A.charAt(i)>='0'&&A.charAt(i)<='9')||A.charAt(i)=='-'){
                tmp+=A.charAt(i);
            }
            else{
                if(tmp!=""){
                    tmpArr[it]=Integer.parseInt(tmp);
                    mi = Math.min(mi,tmpArr[it]);
                    ma = Math.max(mi,tmpArr[it]);
                    ++it;
                }
                tmp="";
            }
        }
        if(tmp!=""){
            tmpArr[it]=Integer.parseInt(tmp);
            mi = Math.min(mi,tmpArr[it]);
            ma = Math.max(mi,tmpArr[it]);
            ++it;
        }
        Arr = tmpArr;
        LowerRange = mi-1;
        UpperRange = ma+1;
    }

    //Set���s��Random Array�ALowerRange/UpperRange�|���O�]���}�C�̤p��/�̤j��
    public newArray(int[] A){
		Arr = A;
        int mi = Integer.MAX_VALUE , ma = Integer.MIN_VALUE;
        ArraySize = A.length;
		for(int i=0;i<ArraySize;++i){
            mi = Math.min(mi,A[i]);
            ma = Math.max(ma,A[i]);
        } 
        LowerRange = mi-1;
        UpperRange = ma+1;
    }

	public newArray(int[] A,int min,int max){
		Arr = A;
		ArraySize = A.length;
        LowerRange = min;
        UpperRange = max;
    }

    @Override
    public String toString(){
        String rt="";
        rt+="ArraySize : " + ArraySize;
        rt+="\nRange of ArraySize[i] : " + LowerRange + " < ArraySize[i] < " + UpperRange + "\n";
        for(int i=0;i<ArraySize;++i){
            rt+=Arr[i]+" ";
        }
        rt+="\n";
        return rt;
    }
    //JAVA���䴩�H���X�R�}�C�A�ҥH�򥻤W�n����
    public void push(int v){
        ++ArraySize;
        Arr = Arrays.copyOf(Arr, ArraySize);
		LowerRange = Math.min(LowerRange,v-1);
        UpperRange = Math.max(UpperRange,v+1);
        Arr[ArraySize-1]=v;
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
        return Arr;
    }
}