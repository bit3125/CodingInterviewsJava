package round4.Q063;

public class Solution {
    public int maxProfit(int[] data){
        if (data==null || data.length==0)
            return 0;

        int minIdx = 0, maxProfit = 0;
        for (int i = 0; i < data.length; i++) {
            if (data[i]<data[minIdx])
                minIdx = i;
            maxProfit = Integer.max(data[i] - data[minIdx], maxProfit);
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        int[] data = {9,11,8,5,7,12,16,14};
//        int[] data = {1,2};

        Solution sl = new Solution();
        System.out.println(sl.maxProfit(data));
    }
}
