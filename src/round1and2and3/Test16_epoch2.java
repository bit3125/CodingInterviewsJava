/**二分求幂（快速幂）
 * 有一个异常情况要处理：当base==0时， exponent==0 与 exponent<0都是异常
 * */
package round1and2and3;

public class Test16_epoch2 {

	double Power(double base, int exponent) throws Exception{
		if (base==0 && exponent<=0)
			throw new Exception();
		
		boolean sign = exponent>=0;
		exponent = Math.abs(exponent);
		double result = 1.0;
		
		while(exponent>0){
			if (1 == (exponent&1))
				result *= base;
			
			exponent >>= 1;
			base *= base;
		}

		if (!sign)
			result = 1/result;
		return result;
	}
	
	public static void main(String[] args){
		Test16_epoch2 t = new Test16_epoch2();
		try{
			System.out.println(t.Power(0, 0));
		}catch (Exception e){
			e.printStackTrace();
		}
	}
	
}
