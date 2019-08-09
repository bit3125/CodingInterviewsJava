/**
 * ±ß½ç¶ş·Ö
 * */

package round4.Q053.P002;

public class Solution {
    public int getMissingNumber(int[] numbers){
        if (numbers==null || numbers.length==0)
            return -1;
        if (numbers[0]!=0)
            return 0;
        if (numbers[numbers.length-1]!=numbers.length)
            return numbers.length;

        int front = 0, rear = numbers.length - 1;
        int mid;

        while (rear - front > 1) {
            mid = (front + rear) / 2;
            if (numbers[mid] == mid) {
                front = mid;
            } else {
                rear = mid;
            }
        }
        return rear;
    }

    public static void main(String[] args) {
//		int[] data = {0,1,2,3,5,6,7};
//		int[] data = {0};
		int[] data = {0,1,2,3};
//        int[] data = {1,2,3};
        Solution sl = new Solution();
        System.out.println(sl.getMissingNumber(data));

    }
}
