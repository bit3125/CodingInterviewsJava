package round1and2and3;

public class Test65 {

	public class Solution {
	    public int Add(int num1,int num2) {
	        int sum = num1;
	        int carry = num2;
	        int sumOld ;
	        
	        //ѭ�����sum��carry
	        while(carry!=0){//***bug:carry>0 ��û���ǵ������������������ȻΪ������λ���
	            sumOld = sum;
	            sum = sum^carry;
	            carry = (sumOld&carry)<<1;
	        }
	        
	        return sum;
	    }
	}
	
	public static void main(String[] args) {
		// TODO �Զ����ɵķ������

	}

}
