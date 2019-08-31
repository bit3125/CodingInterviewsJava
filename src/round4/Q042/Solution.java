package round4.Q042;

public class Solution {
    public int FindGreatestSumOfSubArray(int[] array) {
        if (array==null || array.length==0)
            return 0;

        int[] dp = new int[array.length];
        dp[0] = array[0];
        int max = array[0];
        for (int i = 1; i < dp.length; i++) {
            dp[i] = array[i] + ((dp[i - 1] > 0) ? dp[i - 1] : 0);
            max = Integer.max(dp[i], max);
        }

        return max;
    }
}