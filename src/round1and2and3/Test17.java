package round1and2and3;
import java.util.ArrayList;

//本题牛客上找不到

public class Test17 {

	public ArrayList<String> print1ToMaxOfNDigits(int n){
		ArrayList<String> al = new ArrayList<String>();
		if (n<1) //robust
			return al;
		
		StringBuffer max = new StringBuffer();
		StringBuffer cur = new StringBuffer("1");
		
		for (int i=0;i<n;i++)
			max.append('9');
		
		while(cur.length()<=n){
			al.add(new String(cur));
			increase(cur);
		}
		return al;
	}
	
	public boolean increase(StringBuffer str){
		if (str==null || str.length()==0)
			return false;
		
		int carry = 1;
		int sum = 0;
		int idx = str.length()-1;
		
		while(idx>=0){
			sum = str.charAt(idx)-'0'+carry;
			carry = sum/10;
			str.setCharAt( idx, (char)(sum%10+'0')); 
			idx--;
		}
		if (carry==1)
			str.insert(0, '1');
		return true;
	}
	
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		Test17 test = new Test17();
		StringBuffer str = new StringBuffer("999");
		int n = 3;
		
		test.print1ToMaxOfNDigits(n);
	}

}
