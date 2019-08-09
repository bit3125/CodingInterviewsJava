package round4.Q039.solution1;

public class Solution {
    public int MoreThanHalfNum_Solution(int [] array) {
        if (array==null || array.length==0)
            return 0;

        int cnt = 0, result = 0;
        for (int i = 0; i < array.length; i++) {
            if (cnt == 0) {
                result = array[i];
                cnt++;
                continue;
            }
            // else: cnt>0
            if (array[i] == result) {
                cnt++;
            } else {
                cnt--;
            }
        }

        cnt = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == result)
                cnt++;
        }

        return cnt*2>array.length?result:0;
    }
}