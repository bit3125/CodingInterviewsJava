package sort;

import java.util.Arrays;

public class QuickSort2 {

    public void quickSortMain(int[] nums) {
        if (nums == null || nums.length <= 1)
            return ;

        quickSort(nums, 0, nums.length);
    }

    public void quickSort(int[] nums, int start, int end) {
        if (end - start <= 1)
            return;

        int pivotIdx = partition(nums, start, end);
        quickSort(nums, start, pivotIdx);
        quickSort(nums, pivotIdx + 1, end);
    }

    public int partition(int[] nums, int start, int end) {
        if (end - start <= 1)
            return start; // todo

        int pivot = nums[start];
        int front = start, rear = end - 1;
        while (front < rear) {
            while (front<rear && nums[rear] >= pivot)
                rear--;
            if (front>=rear)
                break;
            nums[front] = nums[rear];

            while (front < rear && nums[front] <= pivot)
                front++;
            if (front >= rear)
                break;
            nums[rear] = nums[front];
        }
        nums[front] = pivot;
        return front;
    }

    public static void main(String[] args) {
        int[] nums =new int[]{4,7,5,6,3,8,9,1,2,5,};
        QuickSort2 q = new QuickSort2();
        q.quickSortMain(nums);
        System.out.println(Arrays.toString(nums));
    }

}
