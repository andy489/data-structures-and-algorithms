// https://leetcode.com/problems/can-make-palindrome-from-substring/

// Solution: Prefix XOR Bitmask — O(n + q) time, O(n) space
class Solution {
    public List<Boolean> canMakePaliQueries(String s, int[][] queries) {
        int n = s.length();
        int[] prefix = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] ^ (1 << (s.charAt(i) - 'a'));
        }
        List<Boolean> result = new ArrayList<>();
        for (int[] q : queries) {
            int mask = prefix[q[1] + 1] ^ prefix[q[0]];
            int oddCount = Integer.bitCount(mask);
            result.add(oddCount / 2 <= q[2]);
        }
        return result;
    }
}
