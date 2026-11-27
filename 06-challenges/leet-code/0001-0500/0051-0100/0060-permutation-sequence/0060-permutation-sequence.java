// https://leetcode.com/problems/permutation-sequence/

// Solution: Factorial Number System — O(n^2) time, O(n) space
class Solution {
    public String getPermutation(int n, int k) {
        int[] fact = new int[n];
        fact[0] = 1;
        for (int i = 1; i < n; i++) {
            fact[i] = fact[i - 1] * i;
        }
        List<Integer> digits = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            digits.add(i);
        }
        k--;
        StringBuilder sb = new StringBuilder();
        for (int i = n - 1; i >= 0; i--) {
            int idx = k / fact[i];
            sb.append(digits.get(idx));
            digits.remove(idx);
            k %= fact[i];
        }
        return sb.toString();
    }
}
