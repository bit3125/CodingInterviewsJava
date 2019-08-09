package round4.Q033;

public class Solution {
    public boolean VerifySquenceOfBST(int [] sequence) {
        if (sequence==null || sequence.length==0)
            return false;

        return isBST(sequence, 0, sequence.length);
    }

    private boolean isBST(int[] sequence, int start, int end) {
        if (end - start <= 1)
            return true;

        // else: end-start>1
        int lessBound = start; // exclusive
        while (lessBound < end-1 && sequence[lessBound] < sequence[end-1]) //***bug: ºóÐò±éÀú
            lessBound++;
        for (int i = lessBound; i < end-1; i++) {
            if (sequence[i]<sequence[end-1])
                return false;
        }

        return isBST(sequence, start, lessBound) && isBST(sequence, lessBound, end-1);
    }
}