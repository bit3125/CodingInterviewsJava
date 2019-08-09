package round4.Q029;

import java.util.ArrayList;

public class Solution {
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList<Integer> result = new ArrayList<>();
        if (matrix==null || matrix.length==0)
            return result;

        int i = 0, j = -1; //todo
        int right = matrix[0].length-1, down = matrix.length-1, left = 0, up = 0; // inclusive
        int num = matrix.length * matrix[0].length;
        while (true) {
            j++;
            while (j <= right) {
                result.add(matrix[i][j]);
                j++;
            }
            j--;
            up++;
            if (result.size()==num)
                break;

            i++;
            while (i <= down) {
                result.add(matrix[i][j]);
                i++;
            }
            i--;
            right--;
            if (result.size()==num)
                break;

            j--;
            while (j >= left) {
                result.add(matrix[i][j]);
                j--;
            }
            j++;
            down--;
            if (result.size()==num)
                break;

            i--;
            while (i >= up) {
                result.add(matrix[i][j]);
                i--;
            }
            i++;
            left++;
            if (result.size()==num)
                break;
        }

        return result;
    }

//    private boolean inRange(int[] ranges, int i, int j) {
//        return ( ranges[3]<=i && i<=ranges[1] && ranges[2]<=j && j<=ranges[0]);
//    }

}