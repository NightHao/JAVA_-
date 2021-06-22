
public class Judge{
	//之後有任何需要判斷的檔案麻煩寫在這裡
	//判斷字串是否為array
	public Boolean stringIsArray(String n){
		//不能有0-9,"-"," "以外的字符
		for(int i=0;i<n.length();++i){
			if(n.charAt(i)!=' '&&n.charAt(i)!='-'){
				if(n.charAt(i)>'9'||n.charAt(i)<'0'){
					return false;
				}
			}
		}
		//判斷每個內部子字串是否都為int
		String tmp = "";
		for(int i=0;i<n.length();++i){
			if(n.charAt(i)!=' '){
				tmp+=n.charAt(i);
			}
			else{
				if(tmp!=""&&stringIsInt(tmp)==false){
					return false;
				}
				tmp = "";
			}
		}
		if(tmp!=""&&stringIsInt(tmp)==false){
			return false;
		}
		tmp = "";
		return true;
	}
	//判斷字串是否為int
	public Boolean stringIsInt(String n){
		//int範圍不可能超過12個字
		if(n.length()==0||n=="-"||n.length()>12)return false;
		int it=0;
		long v=0;
		if(n.charAt(0)=='-'){
			++it;
		}
		for(int i=it;i<n.length();++i){
			if(n.charAt(i)=='-')return false;
			v*=10;
			v+=n.charAt(i)-'0';
		}
		//整數部分不能超過int
		if(v>=Integer.MAX_VALUE){
			return false;
		}
		return true;
	}
	public Boolean canDraw(int swapTime,int arrSize){
		if(arrSize>1000||swapTime>1000||arrSize*swapTime>500000||swapTime==-1){
			return false;
		}
		return true;
	}
	public Boolean strassenCanRun(int A[][],int B[][]){
		if(A.length!=A[0].length||B.length!=B[0].length||A.length!=B.length){
			return false;
		}//非方陣
		int b=1,l=A.length;
		while(b<l){
			b*=2;
		}
		if(b!=l)return false;//非2的冪次
		return true;
	}

}
