// https://leetcode.com/problems/maximum-number-of-balls-in-a-box/

// Solution: Digit-Sum Frequency Count — O(n·d) time, O(1) space
class Solution {
    public int countBalls(int lowLimit, int highLimit) {
        int[] count = new int[46];
        int max = 0;
        for (int i = lowLimit; i <= highLimit; i++) {
            int s = 0, n = i;
            while (n > 0) {
                s += n % 10;
                n /= 10;
            }
            max = Math.max(max, ++count[s]);
        }
        return max;
    }
}
