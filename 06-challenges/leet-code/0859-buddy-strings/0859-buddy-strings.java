// https://leetcode.com/problems/buddy-strings/

// Solution: Linear Scan — O(n) time, O(1) space
class Solution {
    public boolean buddyStrings(String s, String goal) {
        if (s.length() != goal.length()) {
            return false;
        }
        List<Integer> diffs = new ArrayList<>();
        int[] freq = new int[26];
        boolean hasDup = false;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != goal.charAt(i)) {
                diffs.add(i);
            }
            if (++freq[s.charAt(i) - 'a'] == 2) {
                hasDup = true;
            }
        }
        if (diffs.size() == 0) {
            return hasDup;
        }
        if (diffs.size() == 2) {
            int i = diffs.get(0), j = diffs.get(1);
            return s.charAt(i) == goal.charAt(j) && s.charAt(j) == goal.charAt(i);
        }
        return false;
    }
}
