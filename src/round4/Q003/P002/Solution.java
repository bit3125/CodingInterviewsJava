/**
 *
 * �����пӵ㣺�ڻ�������ȡֵ�����ʱ�����ʹ��[1,mid), [mid, n]���֣�Ȼ��ȥ����С��mid��ֵ�Ļ�
 * ���� front+1==rear �ı߽��ʱ��������ѭ������Ϊmid�ǷǷ���û�������
 * �� front+1==rear �ı߽�����£�mid��ȡfront��Ȼ��ǰ����ͱ���� [front,front-1)���Ƿ���
 * �ʿ��ǵ�������Σ�����ȡ�� mid==front�����������ȡ��������Ϊ [1,mid], (mid, n]
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

            //***bug:�������ʹ��[1,mid), [mid, n]���ֵĻ����� front+1==rear �ı߽��ʱ��������ѭ��
            if (equalOrLessThanCnt > mid ) { // һ����[1, mid]��
                rear = mid;
            } else { // һ����(mid, n]��
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
        // TODO �Զ����ɵķ������
        Solution sl = new Solution();
        int[] data = {2,3,5,4,3,2,6,7};

        System.out.println(sl.getDuplication(data));
    }

}
