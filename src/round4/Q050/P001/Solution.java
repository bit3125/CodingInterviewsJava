package round4.Q050.P001;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int FirstNotRepeatingChar(String str) {
        if (str==null || str.length()==0)
            return -1;

        Map<Character, Integer> cnts = new HashMap<>();
        Character curChar;

        for (int i = 0; i < str.length(); i++) {
            curChar = str.charAt(i);
            cnts.put(curChar, cnts.getOrDefault(curChar, 0)+1);
        }
        for (int i = 0; i < str.length(); i++) {
            if (cnts.get(str.charAt(i))==0)
                return i;
        }
        return -1;
    }
}