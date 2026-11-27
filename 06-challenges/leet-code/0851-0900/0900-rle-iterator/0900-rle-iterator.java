// https://leetcode.com/problems/rle-iterator/

// Solution: Pointer — O(1) extra space
class RLEIterator {
    private int[] enc;
    private int idx;

    public RLEIterator(int[] encoding) {
        enc = encoding;
        idx = 0;
    }

    public int next(int n) {
        while (idx < enc.length && n > enc[idx]) {
            n -= enc[idx];
            idx += 2;
        }
        if (idx >= enc.length) { return -1; }
        enc[idx] -= n;
        return enc[idx + 1];
    }
}
