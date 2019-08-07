package round1and2and3;

public class Test48 {

	/**算法思路：典型动态规划
	 * 
	 * 设f[i]为以str[i]结尾的不重复子串中最长长度值
	 * 递推公式：f[i] = max{g[i-1,i]*(f[i-1]+1),1 } //错误，不是这样的
	 * 初始条件：f[0] = 1
	 * 其中g[i-1,i] = 1, if str[i]不含于以str[i-1]结尾的不重复最长子串
	 * 			 0, if str[i]含于以str[i-1]结尾的不重复最长子串
	 * 
	 * Tn = On^2
	 * */
//	public int longestSubstringWithoutDuplication(String str){
//		if (str==null || str.length()==0)
//			return -1;
//		
//		int[] longestSubStrStartWith = new int[str.length()];
//		int[] f = new int[str.length()];
//		f[0] = 1;
//		longestSubStrStartWith[0] = 0;
//		
//		for (int i=1;i<str.length();i++){
//			if ( str.substring(longestSubStrStartWith[i-1], i).contains(str.substring(i,i+1)) ){//新子串
//				f[i] = 1;
//				longestSubStrStartWith[i] = i; 
//			}else{//连接旧子串
//				f[i] = f[i-1]+1;
//				longestSubStrStartWith[i] = longestSubStrStartWith[i-1];
//			}
//		}
//		
//		int max = f[0];
//		for (int i=0;i<str.length();i++)
//			if (f[i]>max)
//				max = f[i];
//		return max;
//	}
	
	/**上面的自己想的动态规划算法出现了一点小偏差
	 * 算法思路：典型动态规划
	 * 
	 * 设f[i]为以str[i]结尾的不重复子串中最长长度值
	 * 递推公式：f[i] = max{g[i-1,i]*(f[i-1]+1),1 } //错误，不是这样的
	 * 初始条件：f[0] = 1
	 * 其中g[i-1,i] = 1, if str[i]不含于以str[i-1]结尾的不重复最长子串
	 * 			 0, if str[i]含于以str[i-1]结尾的不重复最长子串
	 * 
	 * Tn = On^2
	 * */
	public int longestSubstringWithoutDuplication(String str){
		if (str==null || str.length()==0)
			return -1;
		
		int[] f = new int[str.length()];
		int[] latestAppearIdxs = new int[26];

		//init
		f[0] = 1;
		for (int i=0;i<26;i++)
			latestAppearIdxs[i]=-1;
		latestAppearIdxs[str.charAt(0)-'a'] = 0;
			
		//dp
		for (int i=1;i<str.length();i++){
			if (latestAppearIdxs[str.charAt(i)-'a'] < i-f[i-1])//上一个重复的字符在str[i-1]的最长子串之外
				f[i] = f[i-1]+1;
			else//上一个重复的字符在str[i-1]的最长子串之内
				f[i] = i-latestAppearIdxs[str.charAt(i)-'a'];
			latestAppearIdxs[str.charAt(i)-'a'] = i;
		}
		
		int max = f[0];
		for (int i=0;i<str.length();i++)
			if (f[i]>max)
				max = f[i];
		return max;
	}
	
	public static void main(String[] args) {
		
		String str = "arabcacfr";
		
		Test48 test = new Test48();
		int max = test.longestSubstringWithoutDuplication(str);
		System.out.println(max);
	}

}
