package round1and2and3;

public class Test12 {
	/**�㷨���ʣ�DFS+���ݷ� Ѱ��ƥ��·��
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
    	
    	if (this.beFound==true)//����ȫ�ֱ���beFound�� ������Ѱ��һ��·�������������Ҫ�������������
    		return true;
		if (rowCur<0 || rowCur>=rowArange
				|| colCur<0 || colCur>=colArange 
				|| arrived[rowCur][colCur]==true 
				|| stepCur>=pathTarget.length
				|| mat[rowCur][colCur]!=pathTarget[stepCur])//�ݹ���ڣ������ж�+������ж�+���ȴﵽ�ж�
			return false;
	
    	//visit
    	this.arrived[rowCur][colCur]=true;
    	if (stepCur+1==pathTarget.length){//�ݹ���ڣ��ҵ�
    		//***bug: ֮ǰ������һ��StringBuffer���洢��ǰ·�����ڴ˴���pahtTarget���бȽ����ж��Ƿ�������
    		//�����ʱ�ˡ�Ŀ�������ڣ��˴��Ƚ������ַ����Ļ���ʱ�俪��̫����ÿ�εݹ�ǰ����ַ����ظ��Ƚϣ�
    		//�ڱȽ��ַ�������O(n)�ĸ��Ӷȡ���ֻ�Ƚϵ�ǰ�ַ��Ļ��ڱȽ��ַ�������O(1)�ĸ��Ӷȡ�
    		this.beFound =true; 
    		return true;
    	}
    	
    	//�²�����
    	stepCur++;
    	hasPathCore(mat, rowCur+1, colCur, rowArange, colArange, pathTarget, stepCur);
    	hasPathCore(mat, rowCur-1, colCur, rowArange, colArange, pathTarget, stepCur);
    	hasPathCore(mat, rowCur, colCur+1, rowArange, colArange, pathTarget, stepCur);
    	hasPathCore(mat, rowCur, colCur-1, rowArange, colArange, pathTarget, stepCur);
    	//������ϣ�return ǰ����
		this.arrived[rowCur][colCur]=false;
			//stepCurΪ�ֲ��������������
		return this.beFound;//���������beFoundȫ�ֱ������洢����Ļ������ĸ��ݹ����֮ǰ
		//��Ҫ����һ��beFound��ʱ�������ڴ洢boolean�����Ȼ����ĸ��ݹ����Ĵλ����㣬���ݣ���return
		//��������������return֮ǰ���ݣ������ñ����洢�Ļ���ֻ��ֱ��return�ĸ����Ļ�
    }
	
	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		char[] chars = "abtgcfcsjdeh".toCharArray();
//		char[] pathTarget = "bfce".toCharArray();
		char[] pathTarget = "abfb".toCharArray();
		Test12 test = new Test12();
		System.out.println(test.hasPath(chars, 3, 4, pathTarget));
	}

}
