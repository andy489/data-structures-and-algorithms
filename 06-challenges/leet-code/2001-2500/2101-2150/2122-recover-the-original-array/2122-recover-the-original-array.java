// https://leetcode.com/problems/recover-the-original-array/
class Solution {
    public int[] recoverArray(int[] nums) {
        Arrays.sort(nums);
        int m = nums.length;
        int n = m / 2;

        for (int j = 1; j < m; j++) {
            int diff = nums[j] - nums[0];
            if (diff <= 0 || diff % 2 != 0) {
                continue;
            }
            int twoK = diff;
            Map<Integer, Integer> freq = new HashMap<>();
            for (int x : nums) {
                freq.merge(x, 1, Integer::sum);
            }
            int[] result = new int[n];
            int idx = 0;
            boolean valid = true;
            for (int x : nums) {
                if (freq.getOrDefault(x, 0) == 0) {
                    continue;
                }
                int higher = x + twoK;
                if (freq.getOrDefault(higher, 0) == 0) {
                    valid = false;
                    break;
                }
                result[idx++] = x + twoK / 2;
                freq.merge(x, -1, Integer::sum);
                freq.merge(higher, -1, Integer::sum);
            }
            if (valid) {
                return result;
            }
        }
        return new int[0];
    }
}
