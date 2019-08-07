package round1and2and3;
import java.util.ArrayList;

public class Test34 {
	/* �ȼ���val����Ϊ����
	 * 
	 * */
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
    	ArrayList<ArrayList<Integer>> paths = new ArrayList<ArrayList<Integer>>();
    	ArrayList<Integer> pathCur = new ArrayList<Integer>();
    	findPathCore(root, target, 0, pathCur, paths);
    	
    	return paths;
    }
    
    public void findPathCore(TreeNode root, int target, int sum, ArrayList<Integer> pathCur,
    		ArrayList<ArrayList<Integer>> paths){
    	if(root == null){//�ݹ����
    		return;
    	}

    	//visit
    	sum += root.val;
    	pathCur.add(new Integer(root.val));
    	
    	if (root.left==null && root.right==null && sum == target){//***bug:Ҷ�ڵ����
    		//copy path object
    		ArrayList<Integer> pathNew =(ArrayList<Integer>) pathCur.clone();
    		paths.add(pathNew);
    	}

    	//left&&right
    	findPathCore(root.left, target, sum, pathCur, paths);
    	findPathCore(root.right, target, sum, pathCur, paths);
    	
    	//return֮ǰ��·������
    	pathCur.remove(pathCur.size()-1);
//    	sum -= root.val; //����, ��ָ�봫��
    }
	
	public static void main(String[] args) {
		// TODO �Զ����ɵķ������

	}

}
