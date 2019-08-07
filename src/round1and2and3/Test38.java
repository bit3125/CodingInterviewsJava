package round1and2and3;
import java.util.ArrayList;
import java.util.Arrays;

public class Test38 {
	/**最佳算法
	 * 算法思路：见第二个算法
	 * 
	 * 此算法主要的改进是递归栈中的所有函数共享StringBuffer对象的内存，不用反复开辟新内存
	 * 
	 * */
	public ArrayList<String> Permutation(String str) {
		ArrayList<String> permuList = new ArrayList<String>();
		
		//robust
		if (str==null)
			return null;
		else if(str.equals(""))
			return permuList;
		
		StringBuffer sb;
		char[] chars = str.toCharArray();
		Arrays.sort(chars);
		str = new String(chars);
		sb = new StringBuffer(str);
		permutationCore(permuList, sb, 0);

		permuList.sort(null);//***bug: 出来的序列是没按字典序排序过的
		/*关于此处的说明：由于此算法采取的是swap的方法，即使排序好了在输入permutationCore，
		 * 每次swap后必定会导致后面的子串又是乱序（前面的小字母插到后面的大字母的位置上去了）
		 * 故出来的结果还是会是乱序的，故得作重排
		 * 
		 * 而最下面的那个算法，采取的是抽取的方法，故输入下一次递归的子串依然是有序的，
		 * 故最后的输出也是有序的，无需重排
		 * */
		return permuList;
    }
	
	public void permutationCore(ArrayList<String> permuList, 
		StringBuffer sb, int start){
		
		if (start>=sb.length()-1){ //递归出口
//			permuList.add(new String(sb));
//			return ;
			
			//***bug:即使在下面for循环开始添加了去重语句，在全局使用同一个sb的算法下还是无法保证一定不重复
			//故查重语句不能删去
			String newstr = new String(sb);
			boolean repeated = false;
			for (int i=0;i<permuList.size();i++){
				if (permuList.get(i).equals(newstr)){
					//***bug:相同字符串的String与StringBuffer对象，调用equal(),返回的是false
					repeated=true;
					break;
				}
			}
			if (!repeated){
				permuList.add(newstr);
			}
			return ;
		}
		
		//body
		for (int i=start;i<sb.length();i++){//***bug:(int i=0;i<sb.length()-start;i++)
			if (i-1>=start) //***bug: if (i-1>=0)
				if (sb.charAt(i)==sb.charAt(i-1))
					continue;//***bug: return;
			
			swap(sb, start, i);
			permutationCore(permuList, sb, start+1);
			swap(sb, start, i);//回溯
		}
	}
	
	public void swap(StringBuffer sb, int idx1, int idx2){
		if (!(0<=idx1 && idx1<sb.length() && 0<=idx2 && idx2<sb.length()))
			return;
		
		char tmp = sb.charAt(idx1);
		sb.setCharAt(idx1, sb.charAt(idx2));
		sb.setCharAt(idx2, tmp);
		
	}
	
//	/**算法思路：问题可分解为小问题：要得到一个str的一个排列，首先挑选一个char作为排列的第一位，
//	 * 然后得到剩下chars的全排列与其拼接起来，便是该char作为第一位的所有排列
//	 * 于是乎做一个for循环，列举出str中每一个char作为第一位的情况，合并起来，便得到了这个str的全排列
//	 * */
//    public ArrayList<String> Permutation(String str) {
//    	ArrayList<String> permuList = new ArrayList<String>();
//        //robust
//    	if (str==null)
//        	return null;
//        else if (str.equals(""))
//        	return permuList;
//        
//        // str sort
//        char[] chars = str.toCharArray();
//        Arrays.sort(chars);
//        str = new String(chars);
//        
//        //permutation
//        permuList = permutationCore(str);
//    	return permuList;
//    }
//    
//    public ArrayList<String> permutationCore(String str){
//    	/**得到该str的全排列
//    	 * */
//    	ArrayList<String> permuList = new ArrayList<String>();
//    	ArrayList<String> subPermuList;// = new ArrayList<String>();
//    	String substr, newPermu;
//    	boolean repeated;
//    	
//    	if (str.length()==1){ //递归出口
//    		permuList.add(str);
//    		return permuList;
//    	}
//    	
//    	for (int i=0;i<str.length();i++){
//    		if (i-1>=0)// 重复字符则不做第二次
//    			if (str.charAt(i)==str.charAt(i-1))
//    				continue;
//    		
//    		substr = str.substring(0, i)+str.substring(i+1, str.length());
//        	subPermuList = permutationCore(substr);//得到子串的全排列List
//        	//***bug:permuList = permutationCore(substr);这样每轮循环都会把上一趟的结果覆盖掉
//        	
//        	for (int j=0;j<subPermuList.size();j++){//concat
//        		newPermu = str.charAt(i)+subPermuList.get(j);//得到一个新排列
//    			permuList.add(newPermu);        				
//        	}//由于入口处加入了重复判断，故这里的newPermu不可能有重复的，不需要再做复杂度为n^2的遍历找重。
//        	//这个改进省了不少时间与空间开销
//        	
////        	for (int j=0;j<subPermuList.size();j++){//concat
////        		newPermu = str.charAt(i)+subPermuList.get(j);//得到一个新排列
////        		//若不重复则并加入permuList
////        		repeated = false; 
////        		for (int k=0;k<permuList.size();k++){//对当前位上得到的全排列遍历
////        			if (permuList.get(k).equals(newPermu)){
////        				repeated = true;
////        				break;
////        			}
////        		}
////        		if (!repeated)
////        			permuList.add(newPermu);        				
////        	}
//        	
//        }
//    	
//    	return permuList;
//    }
//    
    public void printList(ArrayList<String> al){
    	for (int i=0;i<al.size();i++){
    		System.out.println(al.get(i));
    	}
    }
	
	public static void main(String[] args) {
		// TODO 自动生成的方法存根

		String str = "abadfa";
		char[] chars = str.toCharArray();
		Arrays.sort(chars);
		System.out.println(chars);
		
		str = "a";
		System.out.println(str.substring(0, 0));
		System.out.println(str.substring(1, str.length()));
		
		System.out.println();
		Test38 test = new Test38();
		test.printList(test.Permutation("aac"));
	}
	

}
