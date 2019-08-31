package round4.Q049;

public class Solution {

    public int GetUglyNumber_Solution(int index) {
        if (index<=0)
            return 0;

        // init
        int[] uglys = new int[index];
        uglys[0] = 1;
        int[] boundIdxs = new int[]{0,0,0}; // 2,3,5目前的边界,保证本轮用这个边界去乘出来的数肯定都>=uglys[i-1]
        int[] factors = new int[]{2, 3, 5}; // 2,3,5
        int[] results = new int[3]; // 存储2,3,5乘出来的当前结果

        // cal
        int minIdx;
        for (int i = 1; i < uglys.length; i++) { // 本轮要计算第i个ugly
            minIdx = 0;
            for (int j = 0; j < factors.length; j++) {
                results[j] = uglys[boundIdxs[j]] * factors[j]; //***bug: boundIdxs[j] * factors[j]
                if (results[j] == uglys[i-1]) { //***bug:有可能会出现result等于前一个ugly的，要再计算一次
                    boundIdxs[j]++;
                    j--;
                    continue;
                }

                minIdx = results[j] < results[minIdx] ? j : minIdx; // 选出三个result中最小的，必大于 uglys[i-1]
            }
            uglys[i] = results[minIdx];
            boundIdxs[minIdx]++;
        }

        return uglys[uglys.length-1];
    }

    public static void main(String[] args) {
        Solution sl = new Solution();
        int index = 7;
        System.out.println(sl.GetUglyNumber_Solution(index));
    }

}
