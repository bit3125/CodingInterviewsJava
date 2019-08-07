package round1and2and3;

public class Test58_2 {

    public String LeftRotateString(String str,int n) {
    	if (str==null || str.length()==0) //robust
    		return str;
    	else if ( n<0 || n>str.length())
    		return null;
    	
    	char[] chars = str.toCharArray();
    	
    	reverse(chars, 0, str.length()-1);
    	reverse(chars, 0, str.length()-n-1);
    	reverse(chars, str.length()-n, str.length()-1);
    	
    	return new String(chars);
    }
	
	public void reverse(char[] str, int front, int rear){
		char tmp;

		while(front<rear){
			tmp = str[front];
			str[front] = str[rear];
			str[rear] = tmp;
			
			front++;
			rear--;
		}
	}
	
	public static void main(String[] args) {
//		String str = "abcXYZdef";
		String str = "abc";
		int n = 2;
		
		Test58_2 test = new Test58_2();
		System.out.println(test.LeftRotateString(str, n));
		
	}

}
