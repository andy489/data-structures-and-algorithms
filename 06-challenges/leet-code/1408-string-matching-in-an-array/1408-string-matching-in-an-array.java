// https://leetcode.com/problems/string-matching-in-an-array/

// Solution: Brute Force — O(n^2 * L) time, O(n) space
class Solution {
    public List<String> stringMatching(String[] words) {
        List<String> res = new ArrayList<>();
        for (String w : words) {
            for (String other : words) {
                if (!w.equals(other) && other.contains(w)) {
                    res.add(w);
                    break;
                }
            }
        }
        return res;
    }
}
