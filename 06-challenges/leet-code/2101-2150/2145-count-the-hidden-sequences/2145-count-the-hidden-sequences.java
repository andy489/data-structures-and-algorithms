// https://leetcode.com/problems/count-the-hidden-sequences/
class Solution {
    public int numberOfArrays(int[] differences, int lower, int upper) {
        long prefix = 0;
        long minVal = 0;
        long maxVal = 0;
        for (int d : differences) {
            prefix += d;
            minVal = Math.min(minVal, prefix);
            maxVal = Math.max(maxVal, prefix);
        }
        long result = (upper - lower) - (maxVal - minVal) + 1;
        return (int) Math.max(result, 0);
    }
}
