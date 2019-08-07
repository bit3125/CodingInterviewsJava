package round4.Q004;

public class Solution {
    public boolean Find(int target, int [][] array) {
        if (array==null || array.length==0)
            return false;

        int n = array.length, m = array[0].length;
        int i = 0, j = m-1;
        while (!outOfRange(array, i, j)) {
            if (array[i][j] < target) {
                i++;
            } else if (array[i][j] > target) {
                j--;
            } else {
                return true;
            }
        }

        return false;
    }

    private boolean outOfRange(int[][] array, int i, int j) {
        return !(0 <= i && i < array.length && 0 <= j && j < array[0].length);
    }
}
