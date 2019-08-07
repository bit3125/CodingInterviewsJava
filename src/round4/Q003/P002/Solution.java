/**
 *
 * 本题有坑点：在划分两个取值区间的时候，如果使用[1,mid), [mid, n]划分，然后去计数小于mid的值的话
 * ，在 front+1==rear 的边界的时候会出现死循环，因为mid是非法的没有意义的
 * 在 front+1==rear 的边界情况下，mid会取front，然后前区间就变成了 [front,front-1)，非法！
 * 故考虑到这个情形，最后会取到 mid==front的情况，必须取两个区间为 [1,mid], (mid, n]
 *
 * */

package round4.Q003.P002;

public class Solution {

    int getDuplication(int[] numbers) {
        if (numbers==null || numbers.length==0)
            return -1;

        int front = 1, rear = numbers.length - 1, mid; // range
        int equalOrLessThanCnt ;
        while (front < rear) {
            mid = (front + rear) / 2;
            equalOrLessThanCnt = countEqualOrLessThan(numbers, mid);

            //***bug:这里如果使用[1,mid), [mid, n]划分的话，在 front+1==rear 的边界的时候会出现死循环
            if (equalOrLessThanCnt > mid ) { // 一定在[1, mid]中
                rear = mid;
            } else { // 一定在(mid, n]中
                front = mid + 1;
            }

        }
        return front; // front==rear
    }

    int countEqualOrLessThan(int[] nums, int mid) {
        int cnt = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= mid)
                cnt++;
        }

        return cnt;
    }

    public static void main(String[] args) {
        // TODO 自动生成的方法存根
        Solution sl = new Solution();
        int[] data = {2,3,5,4,3,2,6,7};

        System.out.println(sl.getDuplication(data));
    }

}
