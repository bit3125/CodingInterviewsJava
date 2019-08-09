package round4.Q039.solution2;

public class Solution {

    public int MoreThanHalfNum_Solution(int [] array) {
        if (array==null || array.length==0)
            return 0;

        int front = 0, rear = array.length-1, pivotIdx = 0;
        while (front <= rear) {
            pivotIdx = partition(array, front, rear+1);

            if (pivotIdx < array.length/2)
                front = pivotIdx + 1;
            else if (pivotIdx > array.length/2)
                rear = pivotIdx - 1;
            else{  // ==, check,  总会找到中位idx
                int cnt = 0;
                for (int i = 0; i < array.length; i++) {
                    if (array[i]==array[pivotIdx] )
                        cnt++;
                }
                return (cnt > array.length / 2) ? array[pivotIdx] : 0;
            }
        }

        return 0; // will never be executed
    }


    private int partition(int[] nums, int start, int end) {
        if (start >= end)
            return -1;

        int front = start, rear = nums.length - 1;
        int pivot = nums[start];
        while (front < rear) {
            while (front < rear && nums[rear] >= pivot)
                rear--;
            if (front<rear)
                nums[front] = nums[rear];

            while (front < rear && nums[front] <= pivot)
                front++;
            if (front<rear)
                nums[rear] = nums[front];
        }
        nums[front] = pivot;
        return front;
    }
}
