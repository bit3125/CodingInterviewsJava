package round1and2and3;

/* ����˼·��
 * �������ԳƵĶ��壺���������侵��һ����Ϊ�Գƶ�����
 * �ȼ����⣺����ͼ���֣��ö���������������Ϊ����=>�ö��������侵��һ��=>��Ϊ�Գƶ�����
 * 
 * Ҳ����������ת��Ϊ���ж����ö������Ƿ�Ϊ����
 * �жϻ�Ϊ����������
 * 1.���ڵ�ֵͬ��
 * 2.root1.left��root2.right��Ϊ���� && root1.right��root2.left��Ϊ����
 * 
 * 
 * */

public class Test28 {

	boolean isSymmetrical(TreeNode pRoot){
        if (pRoot==null){
        	return true;// ������Ȼ��true- -
        }
		return isMirror(pRoot.left, pRoot.right);
    }
	
	public boolean isMirror(TreeNode root1, TreeNode root2){
		/* �����ж��������Ƿ�Ϊ����
		 * */
		
		//�ݹ����
		if (root1==null && root2==null){
			return true;
		}else if (root1==null || root2==null){
			return false;
		}//else ���߽Բ�Ϊ��
		
		boolean is = false;
		if (root1.val!=root2.val){
			is = false;
		}else if (!isMirror(root1.left, root2.right)){
			is = false;
		}else if (!isMirror(root1.right, root2.left)){
			is = false;
		}else {
			is = true;
		}
		//is = root1.val==root2.val && isMirror(root1.left, root2.right) && isMirror(root1.right, root2.left)
		
		return is;
	}
	
	public static void main(String[] args) {
		// TODO �Զ����ɵķ������

	}

}
