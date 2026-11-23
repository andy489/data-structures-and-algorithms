// https://leetcode.com/problems/smallest-good-base/

// Solution: Math + Binary Search — O(log^2 N) time, O(1) space
class Solution {
    public String smallestGoodBase(String n) {
        long num = Long.parseLong(n);
        int maxM = (int) (Math.log(num) / Math.log(2));

        for (int m = maxM; m >= 2; m--) {
            long k = (long) Math.pow(num, 1.0 / (m - 1));
            if (k >= 2 && geometricSum(k, m) == num) {
                return String.valueOf(k);
            }
        }
        return String.valueOf(num - 1);
    }

    private long geometricSum(long k, int m) {
        long sum = 0;
        long power = 1;
        for (int i = 0; i < m; i++) {
            sum += power;
            if (sum < 0) {
                return -1;
            }
            power *= k;
        }
        return sum;
    }
}
