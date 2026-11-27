// https://leetcode.com/problems/count-special-quadruplets/
class Solution {
    public int countQuadruplets(int[] nums) {
        int n = nums.length;
        int count = 0;
        Map<Integer, Integer> freq = new HashMap<>();
        for (int c = n - 2; c >= 2; c--) {
            int d = c + 1;
            while (d < n) {
                freq.merge(nums[d] - nums[c], 1, Integer::sum);
                d++;
            }
            for (int a = 0; a < c - 1; a++) {
                for (int b = a + 1; b < c; b++) {
                    count += freq.getOrDefault(nums[a] + nums[b], 0);
                }
            }
            freq.clear();
        }
        return count;
    }
}
