package round1and2and3;

public class Test26 {

    public boolean HasSubtree(TreeNode root1,TreeNode root2) {// ��ʵӦ�ý���hasSubstructure
    	if (root2==null){// robust
    		return false;
    	}
    	if (root1==null){// �ݹ����
    		return false;
    	}
    	
    	boolean has = false;
    	
    	// ʹ�ö��ط�֧�ṹ��������������Ҫ��������������ʡ����
    	// ʵ���ϣ�
    	// has = hasTopSubstructure(root1, root2) || HasSubtree(root1.left, root2) || HasSubtree(root1.right, root2);
		if (hasTopSubstructure(root1, root2)){
			has = true;
		}else if (hasTopSubstructure(root1.left, root2)){
			has = true;
		}else if (hasTopSubstructure(root1.right, root2)){
    		has = true;
    	}else{
    		has = false;
    	}
		
    	return has;
    }
	
    public boolean hasTopSubstructure(TreeNode root1, TreeNode root2){
    	
    	// �ݹ����
    	if (root2==null){
    		return true;
    	}else if(root1==null){// root2δ��root1�ȿ�
    		return false;
    	}
    	
    	if ( root1.val!=root2.val ){// ���ڵ��Ѿ�ƥ������ֱ����ȥ�����������ĵݹ飬��ʡ����
    		return false;
    	}else{// �����һ���ж���������
    		return hasTopSubstructure(root1.left, root2.left) 
    			&& hasTopSubstructure(root1.right, root2.right); 
    	}
    	
    }
    
	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		
	}

}

