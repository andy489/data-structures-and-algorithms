// https://leetcode.com/problems/check-if-a-string-contains-all-binary-codes-of-size-k/

// Solution: HashSet Sliding Window — O(n) time, O(2^k) space
class Solution {
    public boolean hasAllCodes(String s, int k) {
        if (s.length() < k) return false;
        Set<String> seen = new HashSet<>();
        for (int i = 0; i <= s.length() - k; i++) seen.add(s.substring(i, i+k));
        return seen.size() == (1 << k);
    }
}
