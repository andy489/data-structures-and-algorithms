// https://leetcode.com/problems/shortest-and-lexicographically-smallest-beautiful-string/

// Solution: Sliding Window — O(n^2) time, O(n) space
class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        int n = s.length();
        int minLen = n + 1;
        String result = "";

        int left = 0, ones = 0;
        for (int right = 0; right < n; right++) {
            if (s.charAt(right) == '1') {
                ones++;
            }
            while (ones == k) {
                int len = right - left + 1;
                String sub = s.substring(left, right + 1);
                if (len < minLen || (len == minLen && sub.compareTo(result) < 0)) {
                    minLen = len;
                    result = sub;
                }
                if (s.charAt(left) == '1') {
                    ones--;
                }
                left++;
            }
        }
        return result;
    }
}
