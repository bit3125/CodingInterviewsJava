/**�㷨������ʱ�临�Ӷ�O(n*m), nΪroot1�ڵ�����mΪroot2�ڵ���
 * 
 * �����Ӻ����ݹ���ڵ��Ƶ�������ֵ������
 * 
 * root1==null root2==null hasTopSubstructure
 * 1			1			1
 * 0			1			0
 * 1			0			1
 * 0			0			?
 * 
 * */

package round1and2and3;

public class Test26_epoch2 {

	public boolean HasSubtree(TreeNode root1, TreeNode root2) {//root1�����Ƿ���root2���ṹ
		if (root2==null) //ţ��ʾ���У�root2������ʾ������false��������Դͷ�������ס�����ܷ����Ӻ����У���Ϊ�Ӻ����ض��������սڵ㣬��true�����
			return false;
		if (root1==null)
			return hasTopSubstructure(root1, root2);
		
		//else : root1!=null
		return hasTopSubstructure(root1, root2) 
				||hasTopSubstructure(root1.left, root2) 
				||hasTopSubstructure(root1.right, root2);
	}
	
	public boolean hasTopSubstructure(TreeNode root1, TreeNode root2){//root1����`����`�Ƿ���root2���Ľṹ
		if (root1==null)
			return root2==null;
		else if (root2==null)
			return true;
		
		//else: root1!=null && root2!=null
		return (root1.val==root2.val && hasTopSubstructure(root1.left, root2.left) && hasTopSubstructure(root1.right, root2.right));
	}

	public static void main(String[] args) {

	}

}
