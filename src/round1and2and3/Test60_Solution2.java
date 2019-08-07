/**ţ����
 * 
 * �㷨������ʹ�ö�̬�滮
 * ��f(i,j)Ϊ����i������ʱ��������Ϊj���������
 * ����ƹ�ʽ���£�f[i,j] = f[i,j-1] + f[i,j-2] + f[i,j-3] + f[i,j-4] + f[i,j-5] + f[i,j-6]
 * 
 * ��ʼ������f[1,1]~f[1,6] Ϊ1��f[i,j]��j<=0ʱΪ0��
 * ��dp����ɴ�i=1��������j����ķ���滮
 * �����ռ�ɼ�Ϊ����dp��������Ϊ��Ϊf[i,:], f[i-1,:]
 * 
 * */
package round1and2and3;
import java.util.Arrays;

public class Test60_Solution2 {

	public double[] probs(int n){
		final int MAX_SUM = 6*n;
		int[] dp1 = new int[MAX_SUM+1];
		int[] dp2 = new int[MAX_SUM+1];
		int[] tmp;
		
		//init
		Arrays.fill(dp1, 0, 7, 1);
		Arrays.fill(dp1, 7, dp1.length, 0);
		
		//cal cnt
		for (int i=2;i<=n;i++){//ɫ����
			for (int j=1;j<=MAX_SUM;j++){
				dp2[j] = getValue(dp1,j-1)+getValue(dp1,j-2)+getValue(dp1,j-3)
				+getValue(dp1,j-4)+getValue(dp1,j-5)+getValue(dp1,j-6);
			}
			//swap
			tmp = dp1;
			dp1 = dp2;
			dp2 = tmp;
		}
		
		//cal probs
		double[] probs = new double[MAX_SUM];
		int sum = 0;
		for (int i=1;i<dp1.length;i++)
			sum += dp1[i];
		for (int i=0;i<probs.length;i++){
			probs[i] = dp1[i+1]*1.0/sum;
		}
		
		return probs;
	}
	
	public int getValue(int[] dp, int idx){
		if (idx<=0)
			return 0;
		else 
			return dp[idx];
	}
	
	public static void main(String[] args){
		Test60_Solution2 t = new Test60_Solution2();
		int n = 2;
		
		System.out.println(Arrays.toString(t.probs(n)));
	}
}
