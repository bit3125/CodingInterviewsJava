//牛客无

package round1and2and3;

import java.util.Arrays;

public class Test60_Epoch2 {

	public double[] printProbs(int n){
		if (n<1)
			return null;
		
		final int ASPECT = 6;
		final int MAX_VALUE = n*ASPECT;
		int[] cnts0 = new int[MAX_VALUE+1];
		int[] cnts1 = new int[MAX_VALUE+1];
		int[] swapInts;
		Arrays.fill(cnts0, 0);
		Arrays.fill(cnts0, 1, 1+ASPECT, 1);
		
		//cal cnts
		for (int i=0;i<n-1;i++){ //cal f[i,*], n-1 times
			for (int j=1;j<=MAX_VALUE;j++){ //cal f[i,j]
				cnts1[j] = 0;
				for (int k=1;k<=ASPECT;k++) //accum
					cnts1[j] += f(cnts0, j-k);
			}
			swapInts = cnts0;
			cnts0 = cnts1;
			cnts1 = swapInts; //***bug:把swap操作放在了 for j 循环里头
		}
		
		//cal probs
		int totalCnt = 0;
		double[] probs = new double[cnts0.length];
		for (int i=0;i<cnts0.length;i++)
			totalCnt += cnts0[i];
		for (int i=0;i<cnts0.length;i++)
			probs[i] = cnts0[i]*1.0/totalCnt;
		
		return probs;
	}
	
	public int f(int[] f, int j){
		return j<1?0:f[j];
	}
	
	public static void main(String[] args) {
		Test60_Epoch2 t = new Test60_Epoch2();
		int n = 2;
		
		double[] probs = t.printProbs(n);
		for (int i=0;i<probs.length;i++)
			System.out.println(probs[i]);
		
	}

}
