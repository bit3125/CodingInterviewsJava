package round4.Q056;

//num1,num2�ֱ�Ϊ����Ϊ1�����顣��������
//��num1[0],num2[0]����Ϊ���ؽ��
public class Solution {
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        if (array==null || array.length==0)
            return ;

        // generate mask
        int xor=0;
        for (int i = 0; i < array.length; i++)
            xor ^= array[i];
        int mask = 1;
        while ( (mask & xor)==0 )
            mask <<= 1;

        // filter
        num1[0] = 0;
        num2[0] = 0;
        for (int i = 0; i < array.length; i++) {
            if ( (mask & array[i]) == 0) {
                num1[0] ^= array[i];
            } else
                num2[0] ^= array[i];
        }
    }

}