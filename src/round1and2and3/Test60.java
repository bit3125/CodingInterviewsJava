package round1and2and3;

public class Test60 {

	/**算法思路：使用递归暴力模拟枚举所有可能扔出的情况，效率奇低。
	 * 如果能把递归改成循环会好不少。
	 * 什么情况下必须用递归不能用循环呢？即：循环的层数不确定的情况下。
	 * 如果根据色子数来进行嵌套，由于number是无法预先确定的，故循环的层数不能定， 只能用递归
	 * 故，将循环每层的嵌套改为：使用六层循环嵌套，每层遍历number个色子中取1~6中某个值的个数，使用Cmn公式计算可能数
	 * 
	 * 注：有bug，没调，结果是错的
	 * */
	public static int MAX_VALUE = 6;
	
	public double[] printProbability(int number){
		if (number<=0) //robust
			return null;
		
		double[] probs = new double[number*MAX_VALUE+1];
		int left, cnt, sum;
		int[] cnts = new int[number*MAX_VALUE+1];
		for (int i=0;i<cnts.length;i++)
			cnts[i] = 0;
		
		for (int i=number;i>=0;i--){//1的色子个数
			for(int j=number-i;j>=0;j--){//2
				for(int k=number-i-j;k>=0;k--){//3
					for(int l=number-i-j-k;l>=0;l--){//4
						for(int m=number-i-j-k-l;m>=0;m--){//5
							left = number-i-j-k-l-m;//6
							sum = i*1+j*2+k*3+l*4+m*5+left*6;
							cnt = C(number, i)*C(number-i, j)*C(number-i-j, k)
									*C(number-i-j-k, l)*C(number-i-j-k-l, m);//*C(number, left);
							cnts[sum] += cnt;
						}
					}
				}
			}
		}
		
		int totalCnt = ((int) Math.pow(MAX_VALUE, number));
		for (int i=0;i<probs.length;i++){
			probs[i] = cnts[i]*1.0/totalCnt;
		}
		
		return probs; 
	}
	
	public int C(int down, int up){
		if (down==0)
			return 1;//***bug:return 0;
		else if (up==0)
			return 1;
		
		return A(down, up)/A(up, 1);
	}
	
	public int A(int down, int up){
		if (down==0)
			return 0;
		
		int product = 1; 
		for (int i=0;i<up;i++){
			product *= down;
			down--;
		}
		return product;
	}
	
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		int number = 3;
		
		double[] probs;
		Test60 test = new Test60();
		probs = test.printProbability(number);
		
		for(int i=0;i<probs.length;i++)
			System.out.println(probs[i]);
		
	}

}
