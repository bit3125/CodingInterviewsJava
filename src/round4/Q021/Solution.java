/**算法分析：
 * 这里写的是非稳定
 *
 * 如果想要稳定的话，有两种思路：
 * 1.牺牲空间复杂度，用辅助数组来暂存
 * 2.牺牲时间复杂度，让数组分为三段：|--奇数段--|--偶数段--|--未探索段--|，每次探索到奇数的时候都把整个偶数段往后挪然后插在奇数段
 *   最后，这样的时间复杂度大概是On^2
 * 懒得写了
 * */

package round4.Q021;

import java.util.Arrays;

public class Solution {
    public void reOrderArray(int [] array) {
        if (array==null || array.length==0)
            return;

        int front = 0, rear = array.length - 1;
        while (front<=rear) {
            if ((array[front] & 1) == 1) {
                front++;
            } else
                swap(array, front, rear--);
        }
    }

    private void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    public static void main(String[] args) {
        int[] array = new int[]{1, 3, 5, 7, 2, 4, 6};
        Solution sl = new Solution();
        sl.reOrderArray(array);

        System.out.println(Arrays.toString(array));
    }
}