// https://leetcode.com/problems/count-digit-appearances/
class Solution {
    public int countDigitAppearances(int[] nums, int digit) {
        char target = (char)('0' + digit);
        int count = 0;
        for (int num : nums) {
            String s = Integer.toString(num);
            for (char c : s.toCharArray()) {
                if (c == target) {
                    count++;
                }
            }
        }
        return count;
    }
}
