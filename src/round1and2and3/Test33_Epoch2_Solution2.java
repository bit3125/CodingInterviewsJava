/**AC通过！
 * 整体看了一下，写的比Epoch1 清晰了不少！
 * 
 * */

package round1and2and3;

public class Test33_Epoch2_Solution2 {

    public boolean VerifySquenceOfBST(int [] sequence) {
        if (sequence==null || sequence.length==0)
        	return false;
        
        return isBST(sequence, 0, sequence.length-1);
    }
    
    public boolean isBST(int[] sequence, int front, int rear){ //[,]
    	//sequence[rear]为根
    	if (rear-front<=0) //单节点树
    		return true;
    	
    	//else: 节点数>=2
    	int LastLeftIdx = findLastLeftIdx(sequence, front, rear);
    	
    	return satisfyMore(sequence, front, rear, LastLeftIdx) 
    			&& isBST(sequence, front, LastLeftIdx) 
    			&& isBST(sequence, LastLeftIdx+1, rear-1);
    }
    
    /* 
     * param: front, rear  inclusive
     * return: 左子树的最后一个元素的下标，若为空则return front-1，
     * LastLeftIdx取值为[front-1,rear-1](rear为树根)
     * */
    public int findLastLeftIdx(int[] sequence, int front, int rear){//inclusive
    	//无需边界判断，上层函数已保证了节点数>=2
    	for (int i=front;i<rear;i++){
    		if (sequence[i]>sequence[rear])
    			return i-1;
    	}
    	
    	return rear-1;
    }
    
    public boolean satisfyMore(int[] data, int front , int rear, int LastLeftIdx){
    	//data[rear]为根节点
    	for (int i=LastLeftIdx+1;i<rear;i++){
    		if (data[i]<data[rear])
    			return false;
    	}
    	return true;
    }
    
	public static void main(String[] args) {
		Test33_Epoch2_Solution2 t = new Test33_Epoch2_Solution2();
		int[] sequence = {4,8,6,12,16,14,10};
		boolean is = t.VerifySquenceOfBST(sequence);
		System.out.println(is);
	}

}
