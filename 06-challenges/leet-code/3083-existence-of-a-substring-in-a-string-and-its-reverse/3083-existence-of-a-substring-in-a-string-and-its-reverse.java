// https://leetcode.com/problems/existence-of-a-substring-in-a-string-and-its-reverse/

// Solution: HashSet — O(n) time, O(n) space
class Solution {
    public boolean isSubstringPresent(String s) {
        Set<String> seen = new HashSet<>();
        for (int i = 0; i + 1 < s.length(); i++) {
            seen.add(s.substring(i, i + 2));
        }
        for (int i = 0; i + 1 < s.length(); i++) {
            if (seen.contains("" + s.charAt(i + 1) + s.charAt(i))) { return true; }
        }
        return false;
    }
}
