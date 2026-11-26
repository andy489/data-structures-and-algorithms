// https://leetcode.com/problems/maximum-number-of-achievable-transfer-requests/

// Solution: Bitmask Enumeration — O(2^r * (r + n)) time, O(n) space
class Solution {
    public int maximumRequests(int n, int[][] requests) {
        int r = requests.length;
        int best = 0;
        for (int mask = 0; mask < (1 << r); mask++) {
            int[] delta = new int[n];
            int cnt = 0;
            for (int i = 0; i < r; i++) {
                if ((mask >> i & 1) == 1) {
                    delta[requests[i][0]]--;
                    delta[requests[i][1]]++;
                    cnt++;
                }
            }
            boolean valid = true;
            for (int d : delta) {
                if (d != 0) {
                    valid = false;
                    break;
                }
            }
            if (valid) {
                best = Math.max(best, cnt);
            }
        }
        return best;
    }
}
