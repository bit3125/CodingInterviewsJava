/**�㷨������
 * "*"��״̬ת�ƿɷ�Ϊ���������
 * 1.��ʹ��*��str������pattern����ת��
 * 2.ʹ��*��strƥ������ת�ƣ�pattern����
 * �� ��ʹ��*����pattern����ת�ơ� ��case����1+2��ϵõ�
 *
 * �ݹ�ĳ��ڱ߽���������Ҫ�������׳����⣬Ҫ���ǵ�һ��case��str�ѵ��߽��patternδ���߽絫��ʣ�µ�ȫ��*ƥ���
 *
 * �����round2д�ĸ���ǧ�round2�е�while���Խ������round2ûд�ݹ������ʵ�ǰѵݹ���ڷ���while�����ˣ�������һ����
 * */

package round4.Q019;

public class Solution {

    public boolean match(char[] str, char[] pattern){
        if (str==null || pattern==null)
            return false;
        if (pattern.length==0)
            return str.length==0;

        // else: pattern.length!=0, str.length==0 or others
        return matchCore(str, pattern, 0, 0);
    }

    private boolean matchCore(char[] str, char[] pattern, int idx1, int idx2) {
        if (idx2 == pattern.length) {
            return idx1 == str.length;
        } else if (idx1 == str.length) { // idx2 != pattern.length
            return idx2+1<pattern.length && pattern[idx2+1]=='*' && matchCore(str, pattern, idx1, idx2 + 2);
        }

        // else: idxs are legal
        if (idx2 + 1 < pattern.length && pattern[idx2 + 1] == '*') {
            return matchCore(str, pattern, idx1, idx2 + 2) || // ��ʹ��*
                    (charEquals(str[idx1], pattern[idx2]) && matchCore(str, pattern, idx1 + 1, idx2)); // ʹ��*�Ҳ�����ת��
        } else if (charEquals(str[idx1], pattern[idx2])) {
            return matchCore(str, pattern, idx1 + 1, idx2 + 1);
        } else { // not equals
            return false;
        }
    }

    private boolean charEquals(char strChar, char patternChar) { //***bug: Ҫ���ǵ�".*"��ƥ�䣬����Ҫ�˺���
        return patternChar == '.' || strChar == patternChar;
    }

    public static void main(String[] args) {
        char[] str = "a".toCharArray();
        char[] pattern = ".*".toCharArray();

        Solution sl = new Solution();
        System.out.println(sl.match(str, pattern));

    }
}