// https://leetcode.com/problems/partition-array-into-two-arrays-to-minimize-sum-difference/

// Solution: Meet in the Middle — O(2^n * n) time, O(2^n) space
class Solution {
    public int minimumDifference(int[] nums) {
        int n = nums.length / 2;
        int total = 0;
        for (int x : nums) { total += x; }
        // enumerate all subset sums for left and right halves
        List<List<Integer>> leftSums = new ArrayList<>(), rightSums = new ArrayList<>();
        for (int i = 0; i <= n; i++) { leftSums.add(new ArrayList<>()); rightSums.add(new ArrayList<>()); }
        for (int mask = 0; mask < (1 << n); mask++) {
            int sumL = 0, sumR = 0, bitsL = 0, bitsR = 0;
            for (int i = 0; i < n; i++) {
                if ((mask >> i & 1) == 1) { sumL += nums[i]; bitsL++; sumR += nums[i + n]; bitsR++; }
            }
            leftSums.get(bitsL).add(sumL);
            rightSums.get(bitsR).add(sumR);
        }
        for (List<Integer> lst : rightSums) { Collections.sort(lst); }
        int res = Integer.MAX_VALUE;
        for (int k = 0; k <= n; k++) {
            for (int ls : leftSums.get(k)) {
                List<Integer> rs = rightSums.get(n - k);
                int target = total / 2 - ls;
                int pos = Collections.binarySearch(rs, target);
                if (pos < 0) { pos = -pos - 1; }
                for (int p : new int[]{pos - 1, pos}) {
                    if (p >= 0 && p < rs.size()) {
                        int s1 = ls + rs.get(p), s2 = total - s1;
                        res = Math.min(res, Math.abs(s1 - s2));
                    }
                }
            }
        }
        return res;
    }
}
