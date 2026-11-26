// https://leetcode.com/problems/find-numbers-with-even-number-of-digits/

// Solution: Digit Count — O(n log max) time, O(1) space
// Solution: Digit Count — O(n log max) time, O(1) space
class Solution {
    public int findNumbers(int[] nums) {
        int count = 0;
        for (int x : nums) {
            int digits = 0;
            while (x > 0) { digits++; x /= 10; }
            if (digits % 2 == 0) count++;
        }
        return count;
    }
}
