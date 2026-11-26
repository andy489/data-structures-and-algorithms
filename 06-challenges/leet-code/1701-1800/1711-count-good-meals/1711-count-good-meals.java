// https://leetcode.com/problems/count-good-meals/

// Solution: HashMap — O(n log(max)) time, O(n) space
class Solution {
    public int countPairs(int[] deliciousness) {
        int MOD = 1_000_000_007;
        Map<Integer, Integer> freq = new HashMap<>();
        long count = 0;
        for (int d : deliciousness) {
            for (int p = 1; p <= (1 << 21); p <<= 1) {
                int complement = p - d;
                count = (count + freq.getOrDefault(complement, 0)) % MOD;
            }
            freq.merge(d, 1, Integer::sum);
        }
        return (int) count;
    }
}
