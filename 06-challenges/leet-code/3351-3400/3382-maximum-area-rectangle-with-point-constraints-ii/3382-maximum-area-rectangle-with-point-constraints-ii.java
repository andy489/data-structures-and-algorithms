// https://leetcode.com/problems/maximum-area-rectangle-with-point-constraints-ii/

// Solution: Sweep Line + BIT (Coordinate Compression) — O(n^2 log n) time, O(n) space
class Solution {
    private int[] bit;
    private int bitSize;

    private void update(int i, int delta) {
        for (i++; i <= bitSize; i += i & (-i)) {
            bit[i] += delta;
        }
    }

    private int query(int i) {
        int s = 0;
        for (i++; i > 0; i -= i & (-i)) {
            s += bit[i];
        }
        return s;
    }

    private int rangeQuery(int l, int r) {
        return l > r ? 0 : query(r) - (l > 0 ? query(l - 1) : 0);
    }

    public long maxRectangleArea(int[] xCoord, int[] yCoord) {
        int n = xCoord.length;

        // Coordinate compress y
        int[] sortedY = yCoord.clone();
        java.util.Arrays.sort(sortedY);
        java.util.Map<Integer, Integer> yRank = new java.util.HashMap<>();
        int rankCount = 0;
        for (int y : sortedY) {
            if (!yRank.containsKey(y)) {
                yRank.put(y, rankCount++);
            }
        }
        bitSize = rankCount;
        bit = new int[bitSize + 1];

        // Group by x
        java.util.Map<Integer, java.util.List<Integer>> byX = new java.util.TreeMap<>(java.util.Collections.reverseOrder());
        for (int i = 0; i < n; i++) {
            byX.computeIfAbsent(xCoord[i], k -> new java.util.ArrayList<>()).add(yCoord[i]);
        }

        // Map from (yLo, yHi) pair to last x seen on the right
        java.util.Map<Long, Integer> pairToX = new java.util.HashMap<>();
        long maxArea = -1;

        for (java.util.Map.Entry<Integer, java.util.List<Integer>> entry : byX.entrySet()) {
            int x = entry.getKey();
            java.util.List<Integer> ys = entry.getValue();
            java.util.Collections.sort(ys);

            // For each pair in this column, check if we saw it before
            for (int i = 0; i < ys.size(); i++) {
                for (int j = i + 1; j < ys.size(); j++) {
                    int yLo = ys.get(i), yHi = ys.get(j);
                    long key = ((long) yRank.get(yLo) << 20) | yRank.get(yHi);
                    if (pairToX.containsKey(key)) {
                        int prevX = pairToX.get(key);
                        // Check no other points strictly between yLo and yHi in x-range (x, prevX]
                        // All points in that x range have been added to BIT already
                        int cntInRange = rangeQuery(yRank.get(yLo), yRank.get(yHi));
                        // cntInRange should be exactly 2 (the two corners at prevX)
                        if (cntInRange == 2) {
                            maxArea = Math.max(maxArea, (long) (prevX - x) * (yHi - yLo));
                        }
                    }
                    pairToX.put(key, x);
                }
            }

            // Add this column's points to BIT
            for (int y : ys) {
                update(yRank.get(y), 1);
            }
        }
        return maxArea;
    }
}
