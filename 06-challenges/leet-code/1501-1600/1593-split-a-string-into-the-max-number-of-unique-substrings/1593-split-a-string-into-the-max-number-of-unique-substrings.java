// https://leetcode.com/problems/split-a-string-into-the-max-number-of-unique-substrings/

// Solution: Backtracking — O(n * 2^n) time, O(n) space
class Solution {
    private int maxCount;

    public int maxUniqueSplit(String s) {
        maxCount = 0;
        backtrack(s, 0, new HashSet<>());
        return maxCount;
    }

    private void backtrack(String s, int start, Set<String> used) {
        if (s.length() - start + used.size() <= maxCount) return;
        if (start == s.length()) {
            maxCount = Math.max(maxCount, used.size());
            return;
        }
        for (int end = start + 1; end <= s.length(); end++) {
            String sub = s.substring(start, end);
            if (!used.contains(sub)) {
                used.add(sub);
                backtrack(s, end, used);
                used.remove(sub);
            }
        }
    }
}
