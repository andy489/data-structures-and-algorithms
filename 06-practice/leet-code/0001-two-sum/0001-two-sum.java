// https://leetcode.com/problems/two-sum/

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> lookUp = new HashMap<>();
        
        final int SIZE = nums.length;
        for (int i = 0; i < SIZE; ++i) {
            if (lookUp.containsKey(target - nums[i])) {
                return new int[]{i, lookUp.get(target - nums[i])};
            } else {
                lookUp.put(nums[i], i);
            }
        }
        
        return new int[]{-1, -1};
    }
}
