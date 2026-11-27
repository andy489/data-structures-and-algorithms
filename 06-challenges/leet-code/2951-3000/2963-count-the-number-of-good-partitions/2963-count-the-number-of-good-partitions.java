// https://leetcode.com/problems/count-the-number-of-good-partitions/
class Solution {
    static final int MOD = 1_000_000_007;

    public int numberOfGoodPartitions(int[] nums) {
        Map<Integer, Integer> lastOccurrence = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            lastOccurrence.put(nums[i], i);
        }
        int cuts = 0;
        int minEnd = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            minEnd = Math.max(minEnd, lastOccurrence.get(nums[i]));
            if (i == minEnd) {
                cuts++;
            }
        }
        long ans = 1;
        for (int i = 0; i < cuts; i++) {
            ans = ans * 2 % MOD;
        }
        return (int) ans;
    }
}
