// https://leetcode.com/problems/minimum-cost-to-make-array-equalindromic/
class Solution {
    private boolean isPalindrome(long n) {
        String s = Long.toString(n);
        int l = 0, r = s.length() - 1;
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }

    private long cost(int[] nums, long target) {
        long total = 0;
        for (int x : nums) {
            total += Math.abs(x - target);
        }
        return total;
    }

    public long minimumCost(int[] nums) {
        Arrays.sort(nums);
        long median = nums[nums.length / 2];
        long left = median, right = median;
        while (!isPalindrome(left)) {
            left--;
        }
        while (!isPalindrome(right)) {
            right++;
        }
        return Math.min(cost(nums, left), cost(nums, right));
    }
}
