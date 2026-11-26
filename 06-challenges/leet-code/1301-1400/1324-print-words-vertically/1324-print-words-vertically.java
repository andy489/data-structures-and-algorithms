// https://leetcode.com/problems/print-words-vertically/

// Solution: Simulation — O(n * max_len) time, O(n * max_len) space
class Solution {
    public List<String> printVertically(String s) {
        String[] words = s.split(" ");
        int maxLen = 0;
        for (String w : words) maxLen = Math.max(maxLen, w.length());
        List<String> res = new ArrayList<>();
        for (int i = 0; i < maxLen; i++) {
            StringBuilder sb = new StringBuilder();
            for (String w : words) sb.append(i < w.length() ? w.charAt(i) : ' ');
            int end = sb.length();
            while (end > 0 && sb.charAt(end-1) == ' ') end--;
            res.add(sb.substring(0, end));
        }
        return res;
    }
}
