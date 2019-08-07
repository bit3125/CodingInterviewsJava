package round1and2and3;

/**思路分析：
 * 1.if (base==0 && exponent<0) return false;
 * 2.else 
 * 		先提取出exponent的负号
 * 		然后计算无符号exponent的快速幂
 * 		最后对exponent的符号进行处理，为负则取导数。
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
		// TODO 自动生成的方法存根
		Test16 test = new Test16();
		System.out.println(test.Power(2, -2));
	}

}
