// https://leetcode.com/problems/minimum-number-of-changes-to-make-binary-string-beautiful/

// Solution 1: Greedy Pair Scan — O(n) time, O(1) space
class Solution {
    public int minChanges(String s) {
        int changes = 0;
        for (int i = 0; i < s.length(); i += 2) {
            if (s.charAt(i) != s.charAt(i + 1)) {
                changes++;
            }
        }
        return changes;
    }
}

// Solution 2: Greedy Segment Scan — O(n) time, O(1) space
class Solution2 {
    public int minChanges(String s) {
        int changes = 0, len = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                len++;
            } else {
                if (len % 2 == 1) {
                    changes++;
                }
                len = 1;
            }
        }
        return changes;
    }
}
