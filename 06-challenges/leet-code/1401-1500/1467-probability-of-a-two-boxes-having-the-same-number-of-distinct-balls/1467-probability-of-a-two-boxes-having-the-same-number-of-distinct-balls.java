// https://leetcode.com/problems/probability-of-a-two-boxes-having-the-same-number-of-distinct-balls/

// Solution: Combinatorics + DFS — O(2^(sum)*k) time, O(k) space
class Solution {
    int[] balls;
    double favorable = 0, total = 0;
    public double getProbability(int[] balls) {
        this.balls = balls;
        int n = 0;
        for (int b : balls) n += b;
        dfs(0, 0, 0, 0, 0, 1, n/2);
        return favorable / total;
    }
    private void dfs(int idx, int b1, int b2, int d1, int d2, double ways, int half) {
        if (b1 > half || b2 > half) return;
        if (idx == balls.length) {
            if (b1 == half) { total += ways; if (d1 == d2) favorable += ways; }
            return;
        }
        for (int i = 0; i <= balls[idx]; i++) {
            dfs(idx+1, b1+i, b2+balls[idx]-i, d1+(i>0?1:0), d2+(balls[idx]-i>0?1:0),
                ways * comb(balls[idx], i), half);
        }
    }
    private double comb(int n, int k) {
        if (k < 0 || k > n) return 0;
        double res = 1;
        for (int i = 0; i < k; i++) { res *= (n-i); res /= (i+1); }
        return res;
    }
}
