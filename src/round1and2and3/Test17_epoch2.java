/**
 * */
package round1and2and3;

import java.util.ArrayList;

public class Test17_epoch2 {

	public ArrayList<String> print1ToMaxOfNDigits(int n){
		ArrayList<String> results = new ArrayList<>();
		if (n<=0)
			return results;
		
		char[] str = new char[]{'1'};
		while(str.length<=n){
			results.add(new String(str));
			str = increaseOne(str);
		}
		
		return results;
	}
	
	public char[] increaseOne(char[] src){
		boolean carry = true;
		
		for (int i=src.length-1;i>=0;i--){
			if (carry)
				src[i] += 1;
			if (src[i]>'9'){
				carry = true;
				src[i] = '0';
			}else{
				carry = false;
			}
		}
		if (carry){
			char[] dest = new char[src.length+1];
			dest[0] = '1';
			System.arraycopy(src, 0, dest, 1, src.length);
			src = dest;
		}
		
		return src;
	}

	public static void main(String[] args) {
		Test17_epoch2 t = new Test17_epoch2();
		int n = 3;
		ArrayList<String> results = t.print1ToMaxOfNDigits(n);
		for (String s : results){
			System.out.println(s);
		}
	}

}
