/**牛客没有？
 * f[i]:以i结尾的最长不含重复字符子串的起始idx(inclusive)
 * */

package round1and2and3;

import java.util.Arrays;

public class Test48_Epoch2 {

	public int longestSubstringWithoutDuplication(String str){
		if (str==null || str.length()==0)
			return 0;
		
		int[] f = new int[str.length()];
		int[] lastAppearIdx = new int[26];
		Arrays.fill(lastAppearIdx, -1);
		f[0] = 0;
		lastAppearIdx[str.charAt(0)-'a'] = 0;
		
		for (int i=1;i<f.length;i++){
			char c = str.charAt(i);
			if (lastAppearIdx[c-'a'] < f[i-1]){
				f[i] = f[i-1]; //***bug: f[i] = f[i-1] + 1 , not length
			}else{ //>=
				f[i] = lastAppearIdx[c-'a']+1;
			}
			lastAppearIdx[c-'a'] = i;
		}
		
		int maxValue = Integer.MIN_VALUE;
		for (int i=0;i<f.length;i++){
			int v = i-f[i]+1;
			if (v>maxValue)
				maxValue = v;
		}
		return maxValue;
	}
	
	public static void main(String[] args) {

		String str = "arabcacfr";
		
		Test48_Epoch2 test = new Test48_Epoch2();
		int max = test.longestSubstringWithoutDuplication(str);
		System.out.println(max);
	}

}
