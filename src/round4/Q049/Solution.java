package round4.Q049;

public class Solution {

    public int GetUglyNumber_Solution(int index) {
        if (index<=0)
            return 0;

        // init
        int[] uglys = new int[index];
        uglys[0] = 1;
        int[] boundIdxs = new int[]{0,0,0}; // 2,3,5Ŀǰ�ı߽�,��֤����������߽�ȥ�˳��������϶���>=uglys[i-1]
        int[] factors = new int[]{2, 3, 5}; // 2,3,5
        int[] results = new int[3]; // �洢2,3,5�˳����ĵ�ǰ���

        // cal
        int minIdx;
        for (int i = 1; i < uglys.length; i++) { // ����Ҫ�����i��ugly
            minIdx = 0;
            for (int j = 0; j < factors.length; j++) {
                results[j] = uglys[boundIdxs[j]] * factors[j]; //***bug: boundIdxs[j] * factors[j]
                if (results[j] == uglys[i-1]) { //***bug:�п��ܻ����result����ǰһ��ugly�ģ�Ҫ�ټ���һ��
                    boundIdxs[j]++;
                    j--;
                    continue;
                }

                minIdx = results[j] < results[minIdx] ? j : minIdx; // ѡ������result����С�ģ��ش��� uglys[i-1]
            }
            uglys[i] = results[minIdx];
            boundIdxs[minIdx]++;
        }

        return uglys[uglys.length-1];
    }

    public static void main(String[] args) {
        Solution sl = new Solution();
        int index = 7;
        System.out.println(sl.GetUglyNumber_Solution(index));
    }

}
