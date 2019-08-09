/**
 * 目标二分
 * */

package round4.Q053.P003;

public class Solution {
    public int getNumberSameAsIdndex(int[] numbers){
        if (numbers==null || numbers.length==0)
            return -1;

        int front = 0, rear = numbers.length - 1;
        int mid ;
        while (front <= rear) {
            mid = (front + rear) >> 1;

            if (numbers[mid] > mid) {
                rear = mid - 1;
            } else if (numbers[mid] < mid) {
                front = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
//        int[] numbers ={-3,-1,1,3,5};
//        int[] numbers ={0,3};
        int[] numbers ={-3,-2,2};

        Solution sl = new Solution();
        int result = sl.getNumberSameAsIdndex(numbers);
        System.out.println(result);

    }
}
