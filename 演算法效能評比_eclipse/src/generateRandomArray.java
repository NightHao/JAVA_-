import java.util.Random;
public class generateRandomArray{
    //�i�H���O�}�C���\���X�W
	private int ArraySize,LowerRange,UpperRange;
    private int[]  RandomArray;
    //�]�w�}�C(�}�C�j�p�A�̤p�ȡA�̤j��)
	public generateRandomArray(int ArraySize,int LowerRange,int UpperRange){
		if(ArraySize<=0){
            System.out.println("Error value of variable ArraySize,set ArraySize to 10");
            ArraySize=10;
        }
        if(LowerRange>UpperRange){
            System.out.println("Error value of variable LowerRange//UpperRange,set them to 0//100");
            LowerRange=0;
            UpperRange=100;
        }
        this.ArraySize=ArraySize;
		this.LowerRange=LowerRange;
		this.UpperRange=UpperRange;
        int[] RandomArray = new int [ArraySize];
        Random rd = new Random();
        for(int i=0;i<ArraySize;++i){
            RandomArray[i]=(int)((rd.nextFloat()*(UpperRange-LowerRange-1))+LowerRange+1);
        }
        this.RandomArray=RandomArray;
	}

    //Set���s��Random Array�ALowerRange/UpperRange�|���O�]���}�C�̤p��/�̤j��
    public void setRandomArray(int[] Array){
        ArraySize = Array.length;
        int mi = Integer.MAX_VALUE , ma = Integer.MIN_VALUE;
        for(int i=0;i<ArraySize;++i){
            mi = Math.min(mi,Array[i]);
            ma = Math.max(ma,Array[i]);
        } 
        RandomArray = Array;
        LowerRange = mi-1;
        UpperRange = ma+1;
    }

    @Override
    public String toString(){
        String rt="";
        rt+="ArraySize : " + ArraySize;
        rt+="\nRange of ArraySize[i] : " + LowerRange + " < ArraySize[i] < " + UpperRange + "\n";
        for(int i=0;i<ArraySize;++i){
            rt+=RandomArray[i]+" ";
        }
        rt+="\n";
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
        return RandomArray;
    }

    public static String doc(){
        String str;
        str = "";
        str += "�b�Ыئ����O�ɡA�ϥΪ̶���JArraySize�BLowerRange�H��UpperRange�T�ӰѼơA���۫K�|���ͤ@�ӥHArraySize���j�p�BLowerRange���U���U�ɡBUpperRange���W�ɤ��H���}�C\n";
        return str;
    }
}