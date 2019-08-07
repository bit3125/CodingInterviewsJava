/**牛客无
 * 
 * 算法分析：使用动态规划
 * 设f(i,j)为掷出i个骰子时，点数和为j的情况总数
 * 则递推公式如下：f[i,j] = f[i,j-1] + f[i,j-2] + f[i,j-3] + f[i,j-4] + f[i,j-5] + f[i,j-6]
 * 
 * 初始条件：f[1,1]~f[1,6] 为1，f[i,j]当j<=0时为0。
 * 故dp矩阵可从i=1处，沿着j增大的方向规划
 * 辅助空间可简化为两条dp向量，分为作为f[i,:], f[i-1,:]
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
		for (int i=2;i<=n;i++){//色子数
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
