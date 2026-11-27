// https://leetcode.com/problems/limit-occurrences-in-sorted-array/
class Solution {
    public int[] limitOccurrences(int[] nums, int k) {
        List<Integer> result = new ArrayList<>();
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i == 0 || nums[i] != nums[i - 1]) {
                count = 1;
            } else {
                count++;
            }
            if (count <= k) {
                result.add(nums[i]);
            }
        }
        int[] ans = new int[result.size()];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = result.get(i);
        }
        return ans;
    }
}
