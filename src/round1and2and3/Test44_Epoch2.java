/** ����д�ıȵ�һ���ң�
 * ��Epoch1��˼·��
 * 
 * */

package round1and2and3;

public class Test44_Epoch2 {

	public int digitAtIndex(int index){
		if(index<0)
			return -1;
		if (index<=10)//һλ�������
			return index-1;
		
		index -= 10;
		int targetNum, targetDigit;//Ŀ������Ŀ����λ
		int digitNum = 2;//λ��
		int base = 90;
		//ȷ��targetNum�Ǽ�λ��
		while(index>base){
			index -= base;
			digitNum++;
			base *=10;
		}

		//����Ŀ����
		targetNum = base/9-1+ (int)Math.ceil(index*1.0/digitNum);
		//����Ŀ����λ
		index %= digitNum;
		index = index==0?digitNum:index; //***bug:
		base = (int) Math.pow(10, digitNum-index);
		targetDigit = targetNum/(base)%10;
		
		return targetDigit;
	}
	
	public static void main(String[] args) {
		Test44_Epoch2 t = new Test44_Epoch2();
		int index = 1;
		System.out.println(t.digitAtIndex(index));
	}

}
