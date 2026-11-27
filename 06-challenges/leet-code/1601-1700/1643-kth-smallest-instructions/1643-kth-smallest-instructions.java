// https://leetcode.com/problems/kth-smallest-instructions/

// Solution: Combinatorics (Greedy) — O((r+c)^2) time, O(1) space
class Solution {
    public String kthSmallestPath(int[] destination, int k) {
        int v = destination[0], h = destination[1];
        StringBuilder sb = new StringBuilder();
        while (h > 0 && v > 0) {
            // count of strings starting with 'H': C(h+v-1, h-1)
            long cnt = comb(h + v - 1, h - 1);
            if (k <= cnt) {
                sb.append('H');
                h--;
            } else {
                k -= cnt;
                sb.append('V');
                v--;
            }
        }
        while (h-- > 0) {
            sb.append('H');
        }
        while (v-- > 0) {
            sb.append('V');
        }
        return sb.toString();
    }

    private long comb(int n, int r) {
        if (r < 0 || r > n) {
            return 0;
        }
        if (r > n - r) {
            r = n - r;
        }
        long res = 1;
        for (int i = 0; i < r; i++) {
            res = res * (n - i) / (i + 1);
        }
        return res;
    }
}
