// https://leetcode.com/problems/longest-palindrome-by-concatenating-two-letter-words/
class Solution {
    public int longestPalindrome(String[] words) {
        Map<String, Integer> freq = new HashMap<>();
        for (String w : words) {
            freq.put(w, freq.getOrDefault(w, 0) + 1);
        }
        int length = 0;
        boolean centerUsed = false;
        for (Map.Entry<String, Integer> entry : freq.entrySet()) {
            String w = entry.getKey();
            int cnt = entry.getValue();
            String rev = "" + w.charAt(1) + w.charAt(0);
            if (w.equals(rev)) {
                // Palindromic word like "gg"
                length += (cnt / 2) * 4;
                if (cnt % 2 == 1 && !centerUsed) {
                    length += 2;
                    centerUsed = true;
                }
            } else if (w.compareTo(rev) < 0) {
                // Count pairs with reverse
                int pairs = Math.min(cnt, freq.getOrDefault(rev, 0));
                length += pairs * 4;
            }
        }
        return length;
    }
}
