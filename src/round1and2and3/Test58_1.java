package round1and2and3;

public class Test58_1 {

	/**�㷨˼·��ʹ��split��java����
	 * */
//	public void reverse(char[] chars){
//		if (chars==null || chars.length==0)
//			return;
//		
//		String str = new String(chars);
//		String[] strs = str.split(" ");
//		reverseArray(strs);
//		
//		char[] charsNew = String.join(" ", strs).toCharArray();
//		for (int i=0;i<chars.length;i++){
//			chars[i] = charsNew[i];
//		}
//	}
//	
//	public void reverseArray(String[] strs){
//		String tmp;
//		int front = 0, rear = strs.length-1;
//		while(front<rear){
//			tmp = strs[front];
//			strs[front] = strs[rear];
//			strs[rear] = tmp; 
//			
//			front++;
//			rear--;
//		}
//	}

	/**�㷨˼·��ʹ����ԭʼ���㷨
	 * */
	public void reverse(char[] str){
		if (str==null || str.length==0)
			return;
		
		char[] strNew = new char[str.length];
		int p1, p2, p3;//p1,p2Ϊstr��ָ�룬p3ΪstrNew��ָ��
		
		p1 = str.length-1;
		p3 = 0;
		while(p1>=0){//***bug:p1>0
			//Ѱ�ҿո������߽�
			while(p1>=0 && str[p1]!=' ')//����ͣ��' '�ϻ�-1��
				p1--;
			
			//copy
			p2 = p1+1;
			while(p2<str.length && str[p2]!=' '){
				strNew[p3++] = str[p2++];
			}
			if (p3<str.length)//���ո�
				strNew[p3++] = ' ';
			
			p1--;
		}
		
		for (int i=0;i<str.length;i++){
			str[i] = strNew[i];
		}
	}
	
	public static void main(String[] args) {
//		char[] chars = "I am a student.".toCharArray();
//		char[] chars = " student. a".toCharArray();
		char[] chars = "".toCharArray();
		
		Test58_1 test = new Test58_1();
		test.reverse(chars);
		System.out.println(chars);
		
	}

}
