package round1and2and3;

public class Test08_epoch2 {
	
	//����epoch1д�ú�
    public TreeLinkNode GetNext(TreeLinkNode pNode){
        if (pNode == null) //robust
        	return null;
        
        if (pNode.right!=null){//��������
        	pNode = pNode.right;
        	while(pNode.left!=null)
        		pNode = pNode.left;
        	return pNode;
        }else{//������
        	if (pNode.next==null)//��pNode�Ǹ��ڵ�
        		return null;
        	
        	if (pNode==pNode.next.left)//pNode�Ǹ��ڵ������
        		return pNode.next;
        	else{//pNode�Ǹ��ڵ������
        		while(pNode.next!=null && pNode==pNode.next.right)
        			pNode = pNode.next;
        		return pNode.next;
        	}
        }
        
    }
	
	public static void main(String[] args) {
		// TODO �Զ����ɵķ������

	}

}
