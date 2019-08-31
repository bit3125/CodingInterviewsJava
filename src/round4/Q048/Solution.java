/**
 * 状态定义：dp[i]存储以i结尾的最长不含重复字符子串的长度，另外用一个26位的map存储目前每个字符出现的最小idx
 * 转移方程：dp[i] = 1. dp[i-1]+1, if latestIdxs[i]<=(i-1-dp[i-1])
 *                  2. i-latestIdxs[i] , if latestIdxs[i]>(i-1-dp[i-1])
 * 初始条件：
 * */

package round4.Q048;

import java.util.Arrays;

public class Solution {

    public int longestSubstringWithoutDuplication(String str){
        if (str==null || str.length()==0)
            return 0;

        // init
        int[] dp = new int[str.length()];
        int[] latestIdxs = new int[26];
        Arrays.fill(dp, 1);
        Arrays.fill(latestIdxs, Integer.MIN_VALUE);
        latestIdxs[str.charAt(0)-'a'] = 0;
        int maxValue = 1;

        char curChar;
        // dp
        for (int i = 1; i < dp.length; i++) {
            curChar = str.charAt(i);
            dp[i] = (latestIdxs[curChar-'a'] <= i - 1 - dp[i - 1]) ? (dp[i - 1] + 1) : (i - latestIdxs[curChar-'a']);
            maxValue = Integer.max(maxValue, dp[i]);

            latestIdxs[curChar-'a'] = i;
        }

        return maxValue;
    }

    public static void main(String[] args) {

//        String str = "arabcacfr";
        String str = "a";

        Solution sl = new Solution();
        int max = sl.longestSubstringWithoutDuplication(str);
        System.out.println(max);
    }

}
