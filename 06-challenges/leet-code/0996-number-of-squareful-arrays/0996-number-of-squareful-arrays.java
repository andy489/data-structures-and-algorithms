// https://leetcode.com/problems/number-of-squareful-arrays/

// Solution: Backtracking with Deduplication — O(n!) time, O(n) space
class Solution {
    private int ans = 0;

    public int numSquarefulPerms(int[] nums) {
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        backtrack(nums, used, new int[nums.length], 0);
        return ans;
    }

    private void backtrack(int[] nums, boolean[] used, int[] perm, int len) {
        if (len == nums.length) { ans++; return; }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) { continue; }
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) { continue; }
            if (len > 0 && !isSquare(perm[len - 1] + nums[i])) { continue; }
            used[i] = true;
            perm[len] = nums[i];
            backtrack(nums, used, perm, len + 1);
            used[i] = false;
        }
    }

    private boolean isSquare(int n) {
        int s = (int)Math.sqrt(n);
        return s * s == n;
    }
}
