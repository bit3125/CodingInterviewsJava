package round1and2and3;

//ţ����û��

public class Test44 {

	public int digitAtIndex(int index){
		if (index<0) //robust
			return -1;
		//������19��'9'����(index=29)
		//һλ������10λ����λ��90λ����λ��900λ���Դ�����
		int digits = 1;
		int digitsTotalCur = 10;
		int base, curNumber, offset;
		String str;

		while(index>=digitsTotalCur){
			index -= digitsTotalCur;
			digits++;
			digitsTotalCur = digits==2?90:digits*10;
		}
		
		base = digits==1?0:(int) (Math.pow(10, digits-1)); //��λ�����������, 10
		curNumber = base + index/digits; //���������10�������ǰindex���ڵ�ʵ�����֣�29
		str = String.valueOf(curNumber);//ת��29Ϊ'29'
		offset = index % digits;//����index��'29'�ַ����е�ƫ����

		return str.charAt(offset)-'0';
	}
	
	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		Test44 test = new Test44();
		int index = 29;
		System.out.println(test.digitAtIndex(index));
		
	}

}
