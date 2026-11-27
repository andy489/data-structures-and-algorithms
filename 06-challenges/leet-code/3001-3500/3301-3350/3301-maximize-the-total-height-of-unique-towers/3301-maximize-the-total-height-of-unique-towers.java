// https://leetcode.com/problems/maximize-the-total-height-of-unique-towers/

class Solution {
    public long maximumTotalSum(int[] maximumHeight) {
        Arrays.sort(maximumHeight);
        int n = maximumHeight.length;
        long result = maximumHeight[n - 1];
        long prev = maximumHeight[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            long h = Math.min(maximumHeight[i], prev - 1);
            if (h < 1) {
                return -1;
            }
            result += h;
            prev = h;
        }
        return result;
    }
}
