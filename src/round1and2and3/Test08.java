package round1and2and3;

public class Test08 {
	/**�˷����ϣ��޷�ʵ��
	 * �˷��Ļ���˼���ǣ�ģ������������ҳ�Ŀ��ڵ����һ���ڵ㡣
	 * �������ڣ�д������ָ���Ŀû�и��������ĸ��ڵ㣬����ֻ�����˴����丸�ڵ�ָ���Ŀ��ڵ�
	 * ���޷��ô��������ڵ�ģ������������ҳ�
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
//    public void getNextCore(TreeLinkNode pNode, TreeLinkNode targetPrev, TreeLinkNode[] next){ //baseΪ�������
//    	if (this.flag) //����������
//    		return;
//    	if (pNode==null) //�ݹ����
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

	
	/**˼·��
	 * 1.��pNode������������pNext=�������������½ǵĽڵ�
	 * 2.��pNode������������˵����pNodeΪ�������������������ϣ����ݸ��ڵ�
	 * 	2.1.�����޸��ڵ㣬��˵��pNode�ѵ���������ĩβ��������pNext���ǷǷ�����
	 *  2.2.���и��ڵ�
	 *  	2.2.1.��pNodeΪ�丸�ڵ������������pNext=pNode.parent
	 * 		2.2.2.��pNodeΪ�丸�ڵ������������������ϻ��ݣ����ص�2.1����ѭ��
	 * */
	
    public TreeLinkNode GetNext(TreeLinkNode pNode){
        if (pNode == null) //robust
        	return null;
        
        TreeLinkNode p;
        if (pNode.right!=null){ //��������
        	p = pNode.right;
        	while(p.left!=null) //Ѱ�������������½ǵĽڵ�
        		p = p.left;
        	return p;
        }else{ //������������˵����pNodeΪ�������������������ϣ����ݸ��ڵ�
        	p = pNode;
        	while(p!=null){//***bug:�����pȫд����pNode����ô��ʧȥ�˵���
        		if (p.next==null)//�޸��ڵ㣬���ѵ���������ĩβ���Ƿ�����
                	return null;
                else if (p==p.next.left)//�и��ڵ㣬��pNodeΪ���ڵ�����
                	return p.next;
                else //if (pNode==pNode.next.right){//�и��ڵ㣬��pNodeΪ���ڵ���������������ϻ���
                	p = p.next;
        	}
        }
        
        return null;//�ò��������ṹ�Ϸ��Ļ��϶����return�ˡ��������ǲ�д���벻��������
    }
	
	public static void main(String[] args) {
		// TODO �Զ����ɵķ������

	}

}
