// https://leetcode.com/problems/minimum-operations-to-make-array-modulo-alternating-i/
class Solution {
    public int minimumOperations(int[] nums, int k) {
        int[] evenFreq = new int[k];
        int[] oddFreq = new int[k];
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                evenFreq[nums[i] % k]++;
            } else {
                oddFreq[nums[i] % k]++;
            }
        }
        int evenTotal = nums.length / 2 + (nums.length % 2 == 0 ? 0 : 1);
        int oddTotal = nums.length / 2;
        int minOps = Integer.MAX_VALUE;
        for (int x = 0; x < k; x++) {
            for (int y = 0; y < k; y++) {
                if (x == y) {
                    continue;
                }
                int evenCost = evenTotal - evenFreq[x];
                int oddCost = oddTotal - oddFreq[y];
                minOps = Math.min(minOps, evenCost + oddCost);
            }
        }
        return minOps;
    }
}
