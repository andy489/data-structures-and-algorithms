// https://leetcode.com/problems/minimize-array-sum-using-divisible-replacements/

class Solution {
    public long minimizeSum(int[] nums) {
        Set<Integer> valSet = new HashSet<>();
        for (int v : nums) {
            valSet.add(v);
        }
        long sum = 0;
        for (int v : nums) {
            int best = v;
            // Check all divisors of v that are in valSet
            for (int d = 1; (long) d * d <= v; d++) {
                if (v % d == 0) {
                    if (valSet.contains(d)) {
                        best = Math.min(best, d);
                    }
                    if (valSet.contains(v / d)) {
                        best = Math.min(best, v / d);
                    }
                }
            }
            sum += best;
        }
        return sum;
    }
}
