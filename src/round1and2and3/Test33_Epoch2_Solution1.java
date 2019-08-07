/**算法分析：是WA的算法，但是有很多值得思考的地方。整体思想与Epoch1一致，但是寻找LastLeftIdx使用了二分搜索的思想
 * 但是错误的地方也是在这里，由于无法保证序列确实是BST的序列，故无法保证sequence的规律性，故这里使用二分的话可能会陷入死循环！
 * 故此处不能使用binary search来提高性能，故去掉binary search之后就是solution2了
 * 
 * 见Solution2
 * */

package round1and2and3;

public class Test33_Epoch2_Solution1 {

    public boolean VerifySquenceOfBST(int [] sequence) {
        if (sequence==null || sequence.length==0)
        	return false;
        
        return isBST(sequence, 0, sequence.length-1);
    }
    
    public boolean isBST(int[] sequence, int front, int rear){//[,]
    	//sequence[rear]为根
    	if (rear-front<=0) //单节点树
    		return true;
    	
    	//else: 节点数>=2
    	int LastLeftIdx = findLastLeftIdx(sequence, front, rear);
    	
    	return satisfyLessMore(sequence, front, rear, LastLeftIdx) 
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
    	
    	//sequence[rear] 为树根
    	if (sequence[front]>sequence[rear])//若为BST则左树空
    		return front-1;
    	else if (sequence[rear-1]<sequence[rear])//若为BST则右树空
    		return rear-1;
    	
    	//else:若为BST则左右字数皆存在
    	int left = front;
    	int right = rear-1;
    	int mid;
    	while(right-left>1){
    		mid = (left+right)/2;
    		if (sequence[mid]<sequence[rear])
    			front = mid;
    		else if (sequence[mid]>sequence[rear])
    			rear = mid;
    	}
    	
    	return left;
    }
    
    /**判断用找到的边界来划分左右子树的话，lessmore关系是否成立
     * 
     * */
    public boolean satisfyLessMore(int[] data, int front, int rear, int LastLeftIdx){//[,]
    	//上层函数isBST保证了rear-front>=2，平级函数find保证了LastLeftIdx取值为[front-1,rear-1](rear为树根)
    	
    	for (int i=front;i<=LastLeftIdx;i++){
    		if (data[i]>data[rear])
    			return false;
    	}
    	for (int i=LastLeftIdx+1;i<=rear-1;i++){
    		if (data[i]<data[rear])
    			return false;
    	}
    	
    	return true;
    }
	
	public static void main(String[] args) {
		// TODO 自动生成的方法存根

	}

}
