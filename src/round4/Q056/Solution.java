package round4.Q056;

//num1,num2分别为长度为1的数组。传出参数
//将num1[0],num2[0]设置为返回结果
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