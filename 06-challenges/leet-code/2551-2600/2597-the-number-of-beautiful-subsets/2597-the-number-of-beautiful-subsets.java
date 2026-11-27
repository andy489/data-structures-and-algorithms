// https://leetcode.com/problems/the-number-of-beautiful-subsets/
class Solution {
    private int k;
    private Map<Integer, Integer> freq = new HashMap<>();
    private int[] nums;
    private int count = 0;

    public int beautifulSubsets(int[] nums, int k) {
        this.k = k;
        this.nums = nums;
        Arrays.sort(nums);
        backtrack(0);
        return count;
    }

    private void backtrack(int idx) {
        if (idx == nums.length) {
            return;
        }
        for (int i = idx; i < nums.length; i++) {
            int num = nums[i];
            if (freq.getOrDefault(num - k, 0) == 0) {
                freq.put(num, freq.getOrDefault(num, 0) + 1);
                count++;
                backtrack(i + 1);
                freq.put(num, freq.get(num) - 1);
                if (freq.get(num) == 0) {
                    freq.remove(num);
                }
            }
        }
    }
}
