// https://leetcode.com/problems/count-vowels-permutation/

// Solution: Dynamic Programming — O(n) time, O(1) space
// Solution: Dynamic Programming — O(n) time, O(1) space
class Solution {
    public int countVowelPermutation(int n) {
        long MOD = 1_000_000_007, a = 1, e = 1, i = 1, o = 1, u = 1;
        for (int k = 1; k < n; k++) {
            long na = (e + i + u) % MOD;
            long ne = (a + i) % MOD;
            long ni = (e + o) % MOD;
            long no = i % MOD;
            long nu = (i + o) % MOD;
            a = na; e = ne; i = ni; o = no; u = nu;
        }
        return (int) ((a + e + i + o + u) % MOD);
    }
}
