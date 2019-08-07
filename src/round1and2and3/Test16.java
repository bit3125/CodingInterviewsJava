package round1and2and3;

/**˼·������
 * 1.if (base==0 && exponent<0) return false;
 * 2.else 
 * 		����ȡ��exponent�ĸ���
 * 		Ȼ������޷���exponent�Ŀ�����
 * 		����exponent�ķ��Ž��д���Ϊ����ȡ������
 * */

public class Test16 {

	public double Power(double base, int exponent) {
		if (equals(base, 0.0) && exponent<0) //robust
			return -1;
		double result;
		boolean sign = exponent>=0;
		exponent = abs(exponent);
		result = unsignExponentPower(base, exponent);
		return sign?result:1/result;
	}
	
	public double unsignExponentPower(double base, int exponent){
		double result = 1;
		while (exponent>0){
			if ((exponent&1)==1)
				result *= base;
			base *= base;
			exponent = exponent >> 1;
		}
		return result;
	}
	
	public int abs(int n){
		return n>0?n:-n;
	}
	
	public double abs(double n){
		return n>0?n:-n; 
	}
	
	public boolean equals(double a, double b){
		double delta = 1e-5;
		return abs(a-b)<delta;
	}
	
	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		Test16 test = new Test16();
		System.out.println(test.Power(2, -2));
	}

}
