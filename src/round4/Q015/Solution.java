package round4.Q015;

public class Solution {
    public int NumberOf1(int n) {
        int cnt = 0;
        while ( n!=0 ) {
            n = (n - 1) & n;
            cnt++;
        }
        return cnt;
    }

}