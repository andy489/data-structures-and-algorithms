// https://leetcode.com/problems/count-k-th-roots-in-a-range/

class Solution {
    public int countKthRoots(int l, int r, int k) {
        if (k == 1) {
            return r - l + 1;
        }
        int count = 0;
        // include 0 if l == 0
        long x = (l == 0) ? 0 : 1;
        while (true) {
            long power = pow(x, k);
            if (power > r) {
                break;
            }
            if (power >= l) {
                count++;
            }
            x++;
        }
        return count;
    }

    private long pow(long base, int exp) {
        long result = 1;
        for (int i = 0; i < exp; i++) {
            result *= base;
            if (result > (long) 2e9) {
                return (long) 2e9 + 1;
            }
        }
        return result;
    }
}
