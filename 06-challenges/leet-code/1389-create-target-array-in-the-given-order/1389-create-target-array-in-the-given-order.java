// https://leetcode.com/problems/create-target-array-in-the-given-order/

// Solution: Simulation — O(n^2) time, O(n) space
class Solution {
    public int[] createTargetArray(int[] nums, int[] index) {
        List<Integer> target = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) target.add(index[i], nums[i]);
        return target.stream().mapToInt(Integer::intValue).toArray();
    }
}
