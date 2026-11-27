// https://leetcode.com/problems/smallest-missing-non-negative-integer-after-operations/
class Solution {
    public int findSmallestInteger(int[] nums, int value) {
        Map<Integer, Integer> residueCount = new HashMap<>();
        for (int num : nums) {
            int r = ((num % value) + value) % value;
            residueCount.put(r, residueCount.getOrDefault(r, 0) + 1);
        }
        int mex = 0;
        while (true) {
            int r = mex % value;
            int available = residueCount.getOrDefault(r, 0);
            if (available == 0) {
                return mex;
            }
            residueCount.put(r, available - 1);
            mex++;
        }
    }
}
