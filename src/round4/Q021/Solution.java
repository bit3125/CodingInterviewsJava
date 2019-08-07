/**�㷨������
 * ����д���Ƿ��ȶ�
 *
 * �����Ҫ�ȶ��Ļ���������˼·��
 * 1.�����ռ临�Ӷȣ��ø����������ݴ�
 * 2.����ʱ�临�Ӷȣ��������Ϊ���Σ�|--������--|--ż����--|--δ̽����--|��ÿ��̽����������ʱ�򶼰�����ż��������ŲȻ�����������
 *   ���������ʱ�临�Ӷȴ����On^2
 * ����д��
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