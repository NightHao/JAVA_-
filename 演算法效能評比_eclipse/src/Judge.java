public class Judge{
	private newArray tmpArr;
	//���ᦳ����ݭn�P�_���ɮ׳·мg�b�o��
	public Boolean stringIsMatrix(String n){
		//�����Φ��h��
		String tmp = "";
		int l=0;
		for(int i=0;i<n.length();++i){
			if(n.charAt(i)!=' '&&n.charAt(i)!='-'&&n.charAt(i)!='\n'){
				if(n.charAt(i)>'9'||n.charAt(i)<'0'){
					return false;
				}
			}
			if(n.charAt(i)!='\n'){
				tmp+=n.charAt(i);
			}
			else{
				//�Y������@�椣�O�}�C�A�^�ǧ_
				if(stringIsArray(tmp)==false)return false;
				tmpArr = new newArray(tmp);
				//�Y������@��ƶq���@�ˡA�^�ǧ_
				if(l==0){
					l=tmpArr.getArraySize();
				}
				else if(l!=tmpArr.getArraySize()){
					return false;
				}
				if(tmpArr.getArraySize()==0){
					return false;
				}
				tmp = "";
			}
		}
		return true;
	}

	//�P�_�r��O�_��array
	public Boolean stringIsArray(String n){
		//���঳0-9,"-"," "�H�~���r��
		for(int i=0;i<n.length();++i){
			if(n.charAt(i)!=' '&&n.charAt(i)!='-'){
				if(n.charAt(i)>'9'||n.charAt(i)<'0'){
					return false;
				}
			}
		}
		//�P�_�C�Ӥ����l�r��O�_����int
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
	//�P�_�r��O�_��int
	public Boolean stringIsInt(String n){
		//int�d�򤣥i��W�L12�Ӧr
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
		//��Ƴ�������W�Lint
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
		}//�D��}
		int b=1,l=A.length;
		while(b<l){
			b*=2;
		}
		if(b!=l)return false;//�D2������
		return true;
	}

}
