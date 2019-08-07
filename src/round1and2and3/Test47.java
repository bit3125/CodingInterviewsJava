package round1and2and3;

public class Test47 {
	/**算法思路：典型的动态规划题
	 * 
	 * 设置values[i][j]为格子[i,j]上的礼物value，f[i][j]为从[i,j]到达终点能拿到的礼物的最大价值，
	 * 则有
	 * 递推公式：f[i,j] = values[i,j]+max{g[i+1,j]*f[i+1,j], g[i,j+1]*f[i,j+1]}
	 * 初始条件：f[m-1,n-1] = values[m-1,n-1]
	 * 其中：g[i,j] = 1, 0<=i<m, 0<=j<n
	 * 				0, 其他
	 * 规划方向：从右到左，从下到上，列优先
	 * */
	public int maxValue(int[][] values, int m, int n){
		if (values==null || m<1 || n<1){
			return -1;
		}
		
		//列优先
		int[][] f = new int[m][n];
		for (int i=m-1;i>=0;i--){
			for (int j=n-1;j>=0;j--){
				f[i][j] = values[i][j] + 
						Integer.max( g(m,n,i+1,j)?f[i+1][j]:0,
									 g(m,n,i,j+1)?f[i][j+1]:0 );
			}
		}
		return f[0][0];
	}
	
	public boolean g(int m, int n, int i, int j){
		return (0<=i && i<m && 0<=j && j<n);
	}
	
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		int m=4;
		int n=4;
		int[][] values = {{1,10,3,8},{12,2,9,6},{5,7,4,11},{3,7,16,5},};
		
		Test47 test = new Test47();
		int maxValue = test.maxValue(values, m, n);
		System.out.println(maxValue);
		
	}

}
