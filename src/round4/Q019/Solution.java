/**算法分析：
 * "*"的状态转移可分为两种情况：
 * 1.不使用*，str不动，pattern向下转移
 * 2.使用*，str匹配向下转移，pattern不动
 * 而 “使用*并让pattern向下转移” 的case可由1+2组合得到
 *
 * 递归的出口边界条件很重要，很容易出问题，要考虑到一个case：str已到边界而pattern未到边界但是剩下的全是*匹配符
 *
 * 这里和round2写的各有千秋，round2中的while可以借鉴，而round2没写递归出口其实是把递归出口放在while后面了，本质是一样的
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
            return matchCore(str, pattern, idx1, idx2 + 2) || // 不使用*
                    (charEquals(str[idx1], pattern[idx2]) && matchCore(str, pattern, idx1 + 1, idx2)); // 使用*且不向下转移
        } else if (charEquals(str[idx1], pattern[idx2])) {
            return matchCore(str, pattern, idx1 + 1, idx2 + 1);
        } else { // not equals
            return false;
        }
    }

    private boolean charEquals(char strChar, char patternChar) { //***bug: 要考虑到".*"的匹配，故需要此函数
        return patternChar == '.' || strChar == patternChar;
    }

    public static void main(String[] args) {
        char[] str = "a".toCharArray();
        char[] pattern = ".*".toCharArray();

        Solution sl = new Solution();
        System.out.println(sl.match(str, pattern));

    }
}