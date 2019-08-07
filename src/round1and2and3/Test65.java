package round1and2and3;

public class Test65 {

	public class Solution {
	    public int Add(int num1,int num2) {
	        int sum = num1;
	        int carry = num2;
	        int sumOld ;
	        
	        //循环相加sum与carry
	        while(carry!=0){//***bug:carry>0 。没考虑到负数的情况，负数依然为补码逐位相加
	            sumOld = sum;
	            sum = sum^carry;
	            carry = (sumOld&carry)<<1;
	        }
	        
	        return sum;
	    }
	}
	
	public static void main(String[] args) {
		// TODO 自动生成的方法存根

	}

}
