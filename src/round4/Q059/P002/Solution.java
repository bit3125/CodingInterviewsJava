package round4.Q059.P002;

import java.util.Deque;
import java.util.LinkedList;

public class Solution {

    public static class Pair {
        public static int count = 0;

        private int value;
        private int index;

        public Pair(int value) {
            this.value = value;
            this.index = count;

            count++;
        }
    }

    private Deque<Pair> dataQ = new LinkedList<>();
    private Deque<Pair> maxQ = new LinkedList<>();

    public int max(){
        if (dataQ.isEmpty())
            return -1;
        return maxQ.getFirst().value;
    }

    public void push_back(int n){
        Pair curPair = new Pair(n);
        dataQ.addLast(curPair);

        while (!maxQ.isEmpty() && maxQ.getLast().value < n)
            maxQ.removeLast();
        maxQ.addLast(curPair);
    }

    public void pop_front(){
        if (dataQ.isEmpty())
            return ;

        Pair curPair = dataQ.removeFirst();
        while (!maxQ.isEmpty() && maxQ.getFirst().index <= curPair.index)
            maxQ.removeFirst();
    }

}
