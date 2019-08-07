package round1and2and3;

public class Test13 {
	/**�㷨���ʣ�
	 * DFS||BFS Ѱ����ͨ����
	 * 
	 * ��Ŀ������
	 * ��������һ�������ϵ�m*n���������ƶ����ɽ���ĸ��ӵļ��Ͽɳ���Ϊ���µ㼯��
	 * { (row, col) | (i%10+i/10+j%10+j/10) <= threshold }����·���ڵ���ظ����޲������ơ�
	 * �ʣ��������ܵ�����ٸ����ӣ�
	 * 
	 * ��Ŀ����
	 * �������ǰѾ����ÿһ�������ӡ������һ������㡱���ѡ��������ڡ�����Ϊ�������ͨ�������֮���������ߣ���
	 * �ѡ��޷�����ĸ��ӡ�����ɡ���������ͨ��㶼����ͨ������������ߣ��Ĺµ㡱��������������Գ���Ϊ��
	 * ��ĳ����������Ѱ������ͼ����ͨ�����Ľڵ����������Ȼ������ʹ��DFS����BFS����ʵ��
	 * 
	 * �㷨ʵ�֣�
	 * ����ѡ��DFS����ʵ�֡�
	 * ������������boolean����visited��isWall��ǰ����DFS�еĵ��͸������󣬼�¼ÿ���ڵ��Ƿ��ѷ��ʹ���
	 * ����������ʾÿ���ڵ��Ƿ��ǲ��ܽ���ġ��µ㡱��
	 * ���þ�̬����nodeCnt��������DFS�Ĺ����м�¼���ʹ��Ľ����
	 * DFS�ݹ麯���ĳ�����������Ϊ��   
	 * (outOfBoundary(rows, cols, row, col) || visited[row][col] || isWall[row][col] )
	 * �������������߽磨������֮�⣩���򡰷��ʹ��������޷�����Ľ�㡱 �� return
	 * Ȼ�����DFS��
	 * */
	
	int nodeCnt = 0;
	boolean[][] visited;
	boolean[][] isWall;
	int threshold;
	int rows;
	int cols;
	
    public int movingCount(int threshold, int rows, int cols){
        if (threshold<0 || rows<=0 || cols<=0) //robust
        	return 0;//ţ��ʾ����0

        //init
        this.nodeCnt = 0;
        this.threshold = threshold;
        this.rows = rows;
        this.cols = cols;
        this.visited = new boolean[rows][cols];
    	this.isWall = new boolean[rows][cols];
        for (int i=0;i<rows;i++){
        	for (int j=0;j<cols;j++){
        		this.visited[i][j]=false;
        		if ( (i%10+i/10+j%10+j/10) > threshold )
        			this.isWall[i][j]=true;
        		else
        			this.isWall[i][j]=false;
        	}
        }
        
    	//body
        DFS(0,0);
    	return this.nodeCnt;
    }
    
    public void DFS(int row, int col){
    	if (   outOfBoundary(rows, cols, row, col) 
    		|| visited[row][col] 
			|| isWall[row][col] )
    		return;
    	
    	//visit
    	visited[row][col]=true;
    	nodeCnt++;
    	
    	//DFS
    	DFS(row+1, col);
    	DFS(row-1, col);
    	DFS(row, col+1);
    	DFS(row, col-1);
    }
    
    public boolean outOfBoundary(int rows, int cols, int row, int col){
    	return ( row<0 || row>=rows || col<0 || col>=cols );
    }

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������

		
	}
}
