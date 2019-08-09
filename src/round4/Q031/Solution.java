package round4.Q031;

import java.util.Stack;

public class Solution {
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        if (pushA==null || popA==null || pushA.length!=popA.length)
            return false;
        Stack<Integer> stack = new Stack<>();
        int idxPush = 0, idxPop = 0;

        while (idxPush<pushA.length) {
            stack.push(pushA[idxPush++]);
            while (!stack.isEmpty() && stack.peek() == popA[idxPop]) {
                stack.pop();
                idxPop++;
            }
            if (idxPop==popA.length)
                return true;
        }

        return false;
    }
}