/**牛客上多出来的要求：
 * 1.非重复：使用HashSet实现，没有增加复杂度开销
 * 2.字典序：使用sort实现，排序复杂度O(nlogn)，低于主复杂度O(n!)
 * 
 * 算法分析：思路见epoch1，一样的
 * 果然epoch2写的比epoch1又快又好！
 * 
 * */

package round1and2and3;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class Test38_epoch2 {

	public ArrayList<String> Permutation(String str) {
		Set<String> set = new HashSet<>();
		if (str==null || str.length()==0)
			return new ArrayList<String>();
		
		permutationCore(str.toCharArray(), set, 0);
		
		ArrayList<String> result = new ArrayList<String>(set);
		result.sort(new Comparator<String>() {
			@Override
			public int compare(String a, String b){
				return a.compareTo(b);
			}
		});
		return result;
	}
	
	/*
	 * idx:现在要决定的位置
	 * */
	public void permutationCore(char[] chars,Set<String> set, int idx ){
		if (idx>=chars.length){ //递归出口
			set.add(new String(chars));
			return ;
		}
		
		permutationCore(chars, set, idx+1);//idx位上为chars[idx]
		for (int i=idx+1;i<chars.length;i++){//idx位上为chars[i]
			swap(chars, idx, i);
			permutationCore(chars, set, idx+1);
			//回溯
			swap(chars, idx, i);
		}
		//其实上面两个也可以合并起来
		
	}
	
	public void swap(char[] chars, int idx1, int idx2){
		char tmp = chars[idx1];
		chars[idx1] = chars[idx2];
		chars[idx2] = tmp;
	}
	
	public static void main(String[] args) {
		// TODO 自动生成的方法存根

	}

}
