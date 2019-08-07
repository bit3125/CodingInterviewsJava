/**
 * 按epoch1的写法写得好
 *
 * */

package round4.Q011;

public class Solution {
    public int minNumberInRotateArray(int [] array) {
        if (array==null)
            return 0;

        int front = 0, rear = array.length - 1, mid; // point to two parts
        if (array[front]<array[rear]) // case: ordered array
            return array[front];

        while (rear - front > 1) {
            mid = (front + rear) / 2;
            if (array[mid] < array[front]) {
                rear = mid;
            } else if (array[mid] > array[front]) {
                front = mid;
            } else { // ==
                if (array[mid] > array[rear]) {
                    front = mid;
                } else { // [mid]==[rear]==[front] . case: 某一段都相等。linear
                    front = 0;
                    while (/*front+1<array.length &&*/ array[front] <= array[front+1]) {
                        front++;
                    }
                    return array[front+1];
                }

            }
        }

        return array[rear];
    }

    public static void main(String[] args) {
//        int[] array = {4,5,1,2,3,};
//		int[] array = {1,1,1,1,1,1,0,1,1,1,};
//		int[] array = {5,1,2,3,4,};
        int[] array = {1,2,3,4,5};

        Solution sl = new Solution();
        System.out.println(sl.minNumberInRotateArray(array));
    }

}