// https://leetcode.com/problems/count-and-say/

// Solution: Iterative RLE simulation — O(n · L) time, O(L) space
class Solution {
    public String countAndSay(int n) {
        String current = "1";
        for (int k = 1; k < n; k++) {
            StringBuilder sb = new StringBuilder();
            int i = 0;
            while (i < current.length()) {
                char ch = current.charAt(i);
                int j = i;
                while (j < current.length() && current.charAt(j) == ch) {
                    j++;
                }
                sb.append(j - i).append(ch);
                i = j;
            }
            current = sb.toString();
        }
        return current;
    }
}

// Solution2: Recursive — O(n · L) time, O(n · L) space
class Solution2 {
    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        String prev = countAndSay(n - 1);
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < prev.length()) {
            char ch = prev.charAt(i);
            int j = i;
            while (j < prev.length() && prev.charAt(j) == ch) {
                j++;
            }
            sb.append(j - i).append(ch);
            i = j;
        }
        return sb.toString();
    }
}
