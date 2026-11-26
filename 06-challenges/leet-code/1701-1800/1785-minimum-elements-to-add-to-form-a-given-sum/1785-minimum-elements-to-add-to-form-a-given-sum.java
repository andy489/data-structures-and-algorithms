// https://leetcode.com/problems/minimum-elements-to-add-to-form-a-given-sum/

// Solution: Greedy Ceiling Division — O(n) time, O(1) space
class Solution {
    public int minElements(int[] nums, int limit, int goal) {
        long sum = 0;
        for (int x : nums) {
            sum += x;
        }
        long diff = Math.abs(goal - sum);
        return (int) ((diff + limit - 1) / limit);
    }
}
