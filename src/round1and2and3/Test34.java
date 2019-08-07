package round1and2and3;
import java.util.ArrayList;

public class Test34 {
	/* 先假设val可以为负数
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
    	if(root == null){//递归出口
    		return;
    	}

    	//visit
    	sum += root.val;
    	pathCur.add(new Integer(root.val));
    	
    	if (root.left==null && root.right==null && sum == target){//***bug:叶节点才行
    		//copy path object
    		ArrayList<Integer> pathNew =(ArrayList<Integer>) pathCur.clone();
    		paths.add(pathNew);
    	}

    	//left&&right
    	findPathCore(root.left, target, sum, pathCur, paths);
    	findPathCore(root.right, target, sum, pathCur, paths);
    	
    	//return之前的路径回溯
    	pathCur.remove(pathCur.size()-1);
//    	sum -= root.val; //无需, 非指针传递
    }
	
	public static void main(String[] args) {
		// TODO 自动生成的方法存根

	}

}
