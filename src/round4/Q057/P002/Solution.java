package round4.Q057.P002;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class Solution {
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> results = new ArrayList<>();
        Deque<Integer> curList = new LinkedList<>();
        if (sum<=0)
            return results;

        int front = 1, rear = 2;
        int curSum = 3;
        curList.add(1);
        curList.add(2);
        while (rear < sum) {
            if (curSum == sum)
                results.add(new ArrayList<>(curList));

            if (curSum < sum) { //***bug: 两种情况先后顺序不一样
                rear++;

                curSum += rear;
                curList.addLast(rear);
            } else { // (curSum > sum)
                curSum -= front;
                curList.removeFirst();

                front++;
            }
        }
        return results;
    }
}