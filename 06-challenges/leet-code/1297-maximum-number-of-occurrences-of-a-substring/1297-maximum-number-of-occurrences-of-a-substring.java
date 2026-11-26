// https://leetcode.com/problems/maximum-number-of-occurrences-of-a-substring/

// Solution: Sliding Window (minSize only) — O(n * minSize) time, O(n * minSize) space
// Solution: Sliding Window (minSize) — O(n*minSize) time, O(n*minSize) space
class Solution {
    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        Map<String, Integer> freq = new HashMap<>();
        int res = 0;
        for (int i = 0; i <= s.length() - minSize; i++) {
            String sub = s.substring(i, i + minSize);
            Set<Character> uniq = new HashSet<>();
            for (char c : sub.toCharArray()) uniq.add(c);
            if (uniq.size() <= maxLetters) {
                int cnt = freq.merge(sub, 1, Integer::sum);
                res = Math.max(res, cnt);
            }
        }
        return res;
    }
}
