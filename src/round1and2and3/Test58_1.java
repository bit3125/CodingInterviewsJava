package round1and2and3;

public class Test58_1 {

	/**算法思路：使用split等java特性
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

	/**算法思路：使用最原始的算法
	 * */
	public void reverse(char[] str){
		if (str==null || str.length==0)
			return;
		
		char[] strNew = new char[str.length];
		int p1, p2, p3;//p1,p2为str的指针，p3为strNew的指针
		
		p1 = str.length-1;
		p3 = 0;
		while(p1>=0){//***bug:p1>0
			//寻找空格或最左边界
			while(p1>=0 && str[p1]!=' ')//最终停在' '上或-1上
				p1--;
			
			//copy
			p2 = p1+1;
			while(p2<str.length && str[p2]!=' '){
				strNew[p3++] = str[p2++];
			}
			if (p3<str.length)//补空格
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
