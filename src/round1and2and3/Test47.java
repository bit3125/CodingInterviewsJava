package round1and2and3;

public class Test47 {
	/**�㷨˼·�����͵Ķ�̬�滮��
	 * 
	 * ����values[i][j]Ϊ����[i,j]�ϵ�����value��f[i][j]Ϊ��[i,j]�����յ����õ������������ֵ��
	 * ����
	 * ���ƹ�ʽ��f[i,j] = values[i,j]+max{g[i+1,j]*f[i+1,j], g[i,j+1]*f[i,j+1]}
	 * ��ʼ������f[m-1,n-1] = values[m-1,n-1]
	 * ���У�g[i,j] = 1, 0<=i<m, 0<=j<n
	 * 				0, ����
	 * �滮���򣺴��ҵ��󣬴��µ��ϣ�������
	 * */
	public int maxValue(int[][] values, int m, int n){
		if (values==null || m<1 || n<1){
			return -1;
		}
		
		//������
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
		// TODO �Զ����ɵķ������
		int m=4;
		int n=4;
		int[][] values = {{1,10,3,8},{12,2,9,6},{5,7,4,11},{3,7,16,5},};
		
		Test47 test = new Test47();
		int maxValue = test.maxValue(values, m, n);
		System.out.println(maxValue);
		
	}

}
