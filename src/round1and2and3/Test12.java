package round1and2and3;

public class Test12 {
	/**算法本质：DFS+回溯法 寻找匹配路径
	 * 
	 * */
	private boolean[][] arrived ;
	private boolean beFound;
	
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str){
    	if (matrix==null || matrix.length==0  
    			|| str==null || str.length==0 ) //robust
    		return false;
    	
    	//init mat & arrived
    	
    	char[] pathTarget = str;
    	char[][] mat = new char[rows][cols];
    	this.arrived = new boolean[rows][cols];
    	this.beFound=false;
    	for (int i=0;i<rows;i++){
    		for (int j=0;j<cols;j++){
    			mat[i][j]=matrix[i*cols+j];
    			this.arrived[i][j]=false;
    		}
    	}
    	
    	for (int i=0;i<rows;i++)
    		for (int j=0;j<cols;j++)
    			if (hasPathCore(mat, i, j, rows, cols, pathTarget, 0))
    				return true;
    	return false;
    }
    
    public boolean hasPathCore(char[][] mat, int rowCur, int colCur, int rowArange, int colArange, 
    					char[] pathTarget, int stepCur){//range:[,), stepCur from 0 on
    	
    	if (this.beFound==true)//设置全局变量beFound， 避免在寻得一条路径后继续做不必要的深度优先搜索
    		return true;
		if (rowCur<0 || rowCur>=rowArange
				|| colCur<0 || colCur>=colArange 
				|| arrived[rowCur][colCur]==true 
				|| stepCur>=pathTarget.length
				|| mat[rowCur][colCur]!=pathTarget[stepCur])//递归出口：出界判断+到达过判断+长度达到判断
			return false;
	
    	//visit
    	this.arrived[rowCur][colCur]=true;
    	if (stepCur+1==pathTarget.length){//递归出口：找到
    		//***bug: 之前定义了一个StringBuffer来存储当前路径，在此处与pahtTarget进行比较来判断是否达成条件
    		//结果超时了。目测是由于，此处比较整个字符串的话，时间开销太大，且每次递归前面的字符都重复比较，
    		//在比较字符串上是O(n)的复杂度。而只比较当前字符的话在比较字符串上是O(1)的复杂度。
    		this.beFound =true; 
    		return true;
    	}
    	
    	//下层搜索
    	stepCur++;
    	hasPathCore(mat, rowCur+1, colCur, rowArange, colArange, pathTarget, stepCur);
    	hasPathCore(mat, rowCur-1, colCur, rowArange, colArange, pathTarget, stepCur);
    	hasPathCore(mat, rowCur, colCur+1, rowArange, colArange, pathTarget, stepCur);
    	hasPathCore(mat, rowCur, colCur-1, rowArange, colArange, pathTarget, stepCur);
    	//搜索完毕，return 前回溯
		this.arrived[rowCur][colCur]=false;
			//stepCur为局部变量，无需回溯
		return this.beFound;//如果不设置beFound全局变量来存储结果的话，在四个递归语句之前
		//需要声明一个beFound临时变量用于存储boolean结果，然后对四个递归做四次或运算，回溯，再return
		//这样才能做到在return之前回溯（不设置变量存储的话，只能直接return四个语句的或）
    }
	
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		char[] chars = "abtgcfcsjdeh".toCharArray();
//		char[] pathTarget = "bfce".toCharArray();
		char[] pathTarget = "abfb".toCharArray();
		Test12 test = new Test12();
		System.out.println(test.hasPath(chars, 3, 4, pathTarget));
	}

}
