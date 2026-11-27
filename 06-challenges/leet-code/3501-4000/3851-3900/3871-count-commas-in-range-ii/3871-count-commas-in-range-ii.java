// https://leetcode.com/problems/count-commas-in-range-ii/

class Solution {
    public long countCommas(long n) {
        long result = 0;
        long threshold = 1000;
        while (threshold <= n) {
            result += n - threshold + 1;
            threshold *= 1000;
        }
        return result;
    }
}
