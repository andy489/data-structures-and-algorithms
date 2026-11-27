// https://leetcode.com/problems/find-unique-binary-string/

// Solution: Cantor's Diagonal — O(n) time, O(n) space
class Solution {
    public String findDifferentBinaryString(String[] nums) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nums.length; i++) {
            sb.append(nums[i].charAt(i) == '0' ? '1' : '0');
        }
        return sb.toString();
    }
}
