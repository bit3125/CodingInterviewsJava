//ţ����
/**f[i] Ϊ i������ʱ��f[i]�������������(��ĿǰΪֹ����ͼ���)
 * 
 * */
package round1and2and3;

public class Test63_Epoch2 {

	public int maxProfit(int[] data){
		if (data==null || data.length==0)
			return 0;
		
		int[] f = new int[data.length];
		f[0] = 0;
		for (int i=1;i<data.length;i++)
			f[i] = data[i]>data[f[i-1]]?f[i-1]:i;
		
		int maxProfit = Integer.MIN_VALUE;
		int curProfit;
		for (int i=1;i<data.length;i++){
			curProfit = data[i] - data[f[i]];
			if (curProfit>maxProfit)
				maxProfit = curProfit;
		}
		
		return maxProfit;
	}
	
	public static void main(String[] args) {
//		int[] data = {9,11,8,5,7,12,16,14};
		int[] data = {1,2};
		
		Test63_Epoch2 test = new Test63_Epoch2();
		System.out.println(test.maxProfit(data));
	
		
	}

}
