package round1and2and3;

public class Test08_epoch2 {
	
	//还是epoch1写得好
    public TreeLinkNode GetNext(TreeLinkNode pNode){
        if (pNode == null) //robust
        	return null;
        
        if (pNode.right!=null){//右树不空
        	pNode = pNode.right;
        	while(pNode.left!=null)
        		pNode = pNode.left;
        	return pNode;
        }else{//右树空
        	if (pNode.next==null)//若pNode是根节点
        		return null;
        	
        	if (pNode==pNode.next.left)//pNode是父节点的左树
        		return pNode.next;
        	else{//pNode是父节点的右树
        		while(pNode.next!=null && pNode==pNode.next.right)
        			pNode = pNode.next;
        		return pNode.next;
        	}
        }
        
    }
	
	public static void main(String[] args) {
		// TODO 自动生成的方法存根

	}

}
