package round1and2and3;

public class Test08 {
	/**此法作废，无法实现
	 * 此法的基本思想是，模拟中序遍历，找出目标节点的下一个节点。
	 * 问题在于，写到最后发现该题目没有给出整树的根节点，而是只给出了带有其父节点指针的目标节点
	 * 故无法用从整树根节点模拟中序遍历来找出
	 * */
//	private boolean flag = false;
//	private TreeLinkNode prev = null;
//	
//    public TreeLinkNode GetNext(TreeLinkNode pNode){
//        TreeLinkNode[] next = new TreeLinkNode[1];
//    	
//        this.flag = false;
//        this.prev = pNode;//***bug
//        getNextCore(pNode, pNode, next);
//    	return next[0];
//    }
//    
//    public void getNextCore(TreeLinkNode pNode, TreeLinkNode targetPrev, TreeLinkNode[] next){ //base为中序遍历
//    	if (this.flag) //完成任务出口
//    		return;
//    	if (pNode==null) //递归出口
//    		return ;
//    	
//    	//left
//    	getNextCore(pNode.left, targetPrev, next);
//    	//visit
//    	if (this.prev==targetPrev){
//    		next[0]=pNode;
//    		this.flag=true;
//    	}
//    	this.prev = pNode;//***bug
//    	//right
//		getNextCore(pNode.right, targetPrev, next);
//    }

	
	/**思路：
	 * 1.若pNode有右子树，则pNext=其右子树最左下角的节点
	 * 2.若pNode无右子树，则说明以pNode为根的子树已中序遍历完毕，回溯父节点
	 * 	2.1.若其无父节点，则说明pNode已到该整树的末尾，不存在pNext，是非法输入
	 *  2.2.若有父节点
	 *  	2.2.1.若pNode为其父节点的左树根，则pNext=pNode.parent
	 * 		2.2.2.若pNode为其父节点的右树根，则继续向上回溯，即回到2.1进行循环
	 * */
	
    public TreeLinkNode GetNext(TreeLinkNode pNode){
        if (pNode == null) //robust
        	return null;
        
        TreeLinkNode p;
        if (pNode.right!=null){ //有右子树
        	p = pNode.right;
        	while(p.left!=null) //寻找右子树最左下角的节点
        		p = p.left;
        	return p;
        }else{ //无右子树，则说明以pNode为根的子树已中序遍历完毕，回溯父节点
        	p = pNode;
        	while(p!=null){//***bug:这里的p全写成了pNode，那么就失去了迭代
        		if (p.next==null)//无父节点，则已到该整树的末尾，非法输入
                	return null;
                else if (p==p.next.left)//有父节点，且pNode为父节点左树
                	return p.next;
                else //if (pNode==pNode.next.right){//有父节点，且pNode为父节点右树，则继续往上回溯
                	p = p.next;
        	}
        }
        
        return null;//用不到啊大哥结构合法的话肯定早就return了。。。但是不写编译不过。。。
    }
	
	public static void main(String[] args) {
		// TODO 自动生成的方法存根

	}

}
