// https://www.lintcode.com/problem/659/

import java.util.*;

class Solution {
    /*
     * @param strs: a list of strings
     * @return: encodes a list of strings to a single string.
     */
    public String encode(List<String> strs) {
        // write your code here
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            sb.append(str.length()).append('$').append(str);
        }
        return sb.toString();
    }

    /*
     * @param str: A string
     * @return: decodes a single string to a list of strings
     */
    public List<String> decode(String str) {
        // write your code here
        List<String> list = new ArrayList<>();
        int i = 0;
        while (i < str.length()) {
            int delimeter = str.indexOf('$', i);
            int l = Integer.valueOf(str.substring(i, delimeter));
            String in = str.substring(delimeter+1, delimeter+l+1);
            list.add(in);
            i = delimeter+l+1;
        }
        return list;
    }
}