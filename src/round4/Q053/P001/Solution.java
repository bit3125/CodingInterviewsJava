/**
 * 边界二分
 * */

package round4.Q053.P001;

public class Solution {
    public int GetNumberOfK(int [] array , int k) {
        if (array==null || array.length==0)
            return 0;
        if (array[0]>k || array[array.length-1]<k)
            return 0;

        // else: k exist
        int firstIdx = findFirstIdx(array, k);
        int lastIdx = findLastIdx(array, k);

        return lastIdx - firstIdx + 1;
    }

    /**
     * 调用上游保证，array中必须exist k
     * */
    private int findFirstIdx(int[] array, int k) { // inclusive
        if (array[0]==k)
            return 0;

        // else:
        int front = 0, rear = array.length-1 ; // <k , >= k
        int mid;
        while (rear - front > 1) {
            mid = (front + rear) / 2;

            if (array[mid] < k) {
                front = mid;
            } else { //array[mid]>=k
                rear = mid;
            }
        }
        return rear;
    }

    /**
     * 调用上游保证，array中必须exist k
     * */
    private int findLastIdx(int[] array, int k) { // inclusive
        if (array[array.length-1]==k)
            return array.length-1;

        // else:
        int front = 0, rear = array.length-1 ; // <= k , > k
        int mid;
        while (rear - front > 1) {
            mid = (front + rear) / 2;

            if (array[mid] <= k) {
                front = mid;
            } else { //array[mid]>k
                rear = mid;
            }
        }
        return front;
    }

}