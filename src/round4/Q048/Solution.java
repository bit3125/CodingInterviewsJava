/**
 * ״̬���壺dp[i]�洢��i��β��������ظ��ַ��Ӵ��ĳ��ȣ�������һ��26λ��map�洢Ŀǰÿ���ַ����ֵ���Сidx
 * ת�Ʒ��̣�dp[i] = 1. dp[i-1]+1, if latestIdxs[i]<=(i-1-dp[i-1])
 *                  2. i-latestIdxs[i] , if latestIdxs[i]>(i-1-dp[i-1])
 * ��ʼ������
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
