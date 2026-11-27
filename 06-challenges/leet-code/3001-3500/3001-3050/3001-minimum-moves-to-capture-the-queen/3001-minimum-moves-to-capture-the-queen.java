// https://leetcode.com/problems/minimum-moves-to-capture-the-queen/

// Solution: Case Analysis — O(1) time, O(1) space
class Solution {
    public int minMovesToCaptureTheQueen(int a, int b, int c, int d, int e, int f) {
        // Rook at (a,b), Bishop at (c,d), Queen at (e,f)
        // Check rook captures in 1 move (same row, not blocked)
        if (a == e && (c != a || d < Math.min(b, f) || d > Math.max(b, f))) { return 1; }
        // Same col
        if (b == f && (d != b || c < Math.min(a, e) || c > Math.max(a, e))) { return 1; }
        // Check bishop captures in 1 move (same diagonal, not blocked)
        if (Math.abs(c - e) == Math.abs(d - f)) {
            int minR = Math.min(c, e), maxR = Math.max(c, e);
            int minC = Math.min(d, f), maxC = Math.max(d, f);
            if (!(a > minR && a < maxR && b > minC && b < maxC)) { return 1; }
            if (!(a > minR && a < maxR && b < maxC && b > minC)) { return 1; }
        }
        return 2;
    }
}
