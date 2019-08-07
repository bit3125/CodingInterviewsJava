package round1and2and3;

public class Test37 {
	/**
	 * ���Ž⣬ʹ�õ�һ����
	 * 
	 */
	private int idx = 0;
	
	String Serialize(TreeNode root) {
		if (root==null) //robust ��֤�˿������ܽ���ݹ�
			return "";
		
		StringBuffer sb = new StringBuffer();
		SerializeCore(root, sb);

		return sb.toString();
	}
	
	void SerializeCore(TreeNode root, StringBuffer sb){
		if (root==null){//�ݹ����
			sb.append("*,");
			return;
		}
			
		sb.append(root.val+",");
		SerializeCore(root.left, sb);
		SerializeCore(root.right, sb);
		return;
	}

	TreeNode Deserialize(String str) {
		if (str==null || str.equals("")) //robust ��֤�˽���ݹ�Ĵ���������һ���ڵ�
			return null;
		idx = 0;
		String[] strs = str.split(",");
		TreeNode pRoot = DeserializeCore(strs);
		
		return pRoot;
	}

	TreeNode DeserializeCore(String[] strs){
		if (idx>=strs.length) //TODO 
			return null;
		
		if (strs[idx].equals("*")){ // �ݹ����
			idx++;//***bug
			return null;
		}

		TreeNode pRoot = new TreeNode(Integer.parseInt(strs[idx]));
		idx++;
		pRoot.left = DeserializeCore(strs);
		pRoot.right = DeserializeCore(strs);
			
		return pRoot;
	}
	
	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
	//	String str = "1,2,4,3,5,6,;4,2,1,5,3,6,";
		String str = "1,2,4,*,*,*,3,5,*,*,6,*,*";
//		String str = "";
		TreeNode newroot;
		String newstr;
		Test37 test = new Test37();
		newroot = test.Deserialize(str);
		newstr = test.Serialize(newroot);
		System.out.println(newstr);
		
	}
	
//	/**˼·�������Ž⣬����˼ά��
//	 * 
//	 * ���л������������������
//	 * 
//	 * �����л�:
//	 * 0.�������е���Ԫ�ؼ�Ϊ��ǰroot
//	 * 1.�������������ҵ�ǰroot���佫���������������������������õ� ���������������У����ɼ���� ������������������
//	 * 2.�����������а��� ������������ �õ� ����������������
//	 * 3.�ݹ����� �������� �ķ����л�
//	 * 
//	 * */
//	public static int MAXSIZE = 1000;
//	
//	String Serialize(TreeNode root) {
//		
//		if (root==null)//robust //***bug: 
//			return "";
//		String preOrderStr = preOrderSer(root);
//		String inOrderStr = inOrderSer(root);
//		
//		return preOrderStr+";"+inOrderStr;
//	}
//	
//	String preOrderSer(TreeNode root){
//		if (root==null)
//			return "";
//		
//		String str = String.valueOf(root.val+",");
//		str = str+preOrderSer(root.left);
//		str = str+preOrderSer(root.right);
//		
//		return str;
//	}
//
//	String inOrderSer(TreeNode root){
//		if (root==null)
//			return "";
//		
//		String str;
//		str = inOrderSer(root.left);
//		str = str+String.valueOf(root.val+",");
//		str = str+inOrderSer(root.right); //***bug: = inOrderSer(root.right);
//		
//		return str;
//	}
//	
//	TreeNode Deserialize(String str) {
//		if (str.equals("")||str==null)//robust //***bug
//			return null;
//		
//		TreeNode pRoot;
//		String[] serieses, preOrderStrs, inOrderStrs;
//		int[] preOrderNums = new int[MAXSIZE], inOrderNums = new int[MAXSIZE];
//		
//		serieses = str.split(";");
//		preOrderStrs = serieses[0].split(",");
//		inOrderStrs = serieses[1].split(",");
//
//		if (   preOrderStrs.length==0 || inOrderStrs.length==0
//			|| preOrderStrs.length!=inOrderStrs.length)//robust
//			return null;
//		
//		//convert
//		for (int i=0;i<preOrderStrs.length;i++)
//			preOrderNums[i] = Integer.valueOf(preOrderStrs[i]).intValue();
//		for (int i=0;i<inOrderStrs.length;i++)
//			inOrderNums[i] = Integer.valueOf(inOrderStrs[i]).intValue();
//		
//		//deserialize
//		pRoot = DeserializeCore(preOrderNums, inOrderNums,
//				0, preOrderStrs.length, 0, inOrderStrs.length);
//		
//		return pRoot;
//	}
//	
//	TreeNode DeserializeCore(int[] preOrderNums, int[] inOrderNums, 
//			int preStart, int preEnd, int inStart, int inEnd) {
//		if (preStart>=preEnd || inStart>=inEnd)//TODO 
//			return null;
//		//else preOrderNums.len>0
//		
//		//declare
//		int rootVal = preOrderNums[preStart];//***bug: = preOrderNums[0]
//		int rootIdxAtInOrder;
//		int leftCnt, rightCnt;
//		
//		//visit
//		TreeNode pRoot = new TreeNode(rootVal);
//			//search for rootIdxAtPreOrder
//		rootIdxAtInOrder = inStart;
//		while(rootIdxAtInOrder<inEnd && inOrderNums[rootIdxAtInOrder]!=rootVal)
//			rootIdxAtInOrder++;
//			//cal leftCnt && rightCnt
//		
//		leftCnt = rootIdxAtInOrder-inStart;
//		rightCnt = inEnd-rootIdxAtInOrder-1;
//		
//		//left&&right
//		pRoot.left = DeserializeCore(preOrderNums, inOrderNums, 
//				preStart+1, preStart+1+leftCnt, inStart, rootIdxAtInOrder);
//		pRoot.right = DeserializeCore(preOrderNums, inOrderNums, 
//				preStart+1+leftCnt, preEnd, rootIdxAtInOrder+1, inEnd);
//		
//		return pRoot;
//	}
//	
//	public static void main(String[] args) {
//		// TODO �Զ����ɵķ������
////		String str = "1,2,4,3,5,6,;4,2,1,5,3,6,";
////		String str = "1,2,4,3,6,;4,2,1,3,6,";
//		String str = "";
//		TreeNode newroot;
//		String newstr;
//		Test37 test = new Test37();
//		newroot = test.Deserialize(str);
//		newstr = test.Serialize(newroot);
//		System.out.println(newstr);
//		
//	}

}
