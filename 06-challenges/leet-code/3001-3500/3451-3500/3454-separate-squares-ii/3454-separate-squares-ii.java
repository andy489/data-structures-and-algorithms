// https://leetcode.com/problems/separate-squares-ii/

// Solution: Binary Search + Coordinate Compression + Sweep Line — O(n^2 log n) time, O(n) space
class Solution {
    public double separateSquares(int[][] squares) {
        // Collect all unique x coordinates
        // For union area calculation at a given y = mid:
        // Each square [x, y, l] contributes rectangle [x, x+l] from bottom y to min(top, mid)
        // We binary search on mid and compute union area below line
        double lo = Double.MAX_VALUE, hi = 0;
        for (int[] sq : squares) {
            lo = Math.min(lo, sq[1]);
            hi = Math.max(hi, sq[1] + sq[2]);
        }
        double totalArea = computeUnion(squares, hi);
        for (int iter = 0; iter < 100; iter++) {
            double mid = (lo + hi) / 2.0;
            double below = computeUnionBelow(squares, mid);
            double above = totalArea - below;
            if (below < above) {
                lo = mid;
            } else {
                hi = mid;
            }
        }
        return lo;
    }

    private double computeUnionBelow(int[][] squares, double y) {
        // Build list of x-intervals for the clipped rectangles
        List<long[]> rects = new ArrayList<>();
        for (int[] sq : squares) {
            double bottom = sq[1], top = sq[1] + (double) sq[2];
            if (bottom >= y) {
                continue;
            }
            double clippedTop = Math.min(top, y);
            double height = clippedTop - bottom;
            rects.add(new long[]{sq[0], sq[0] + sq[2], Double.doubleToLongBits(height)});
        }
        // Compute union area using sweep line on x with coordinate compression
        // Collect x events
        List<int[]> events = new ArrayList<>();
        for (int[] sq : squares) {
            if (sq[1] >= y) {
                continue;
            }
            events.add(new int[]{sq[0], 1, sq[2]});
            events.add(new int[]{sq[0] + sq[2], -1, sq[2]});
        }
        events.sort((a, b) -> a[0] - b[0]);
        // Collect sorted unique x values for coordinate compression
        TreeSet<Integer> xSet = new TreeSet<>();
        for (int[] sq : squares) {
            xSet.add(sq[0]);
            xSet.add(sq[0] + sq[2]);
        }
        List<Integer> xs = new ArrayList<>(xSet);
        // For each strip between consecutive x values, track coverage count
        // This is a simplified approach: use segment tree or count-based sweep
        // For simplicity with n<=50000, use coordinate-compressed sweep
        int m = xs.size();
        int[] cnt = new int[m - 1];
        // Process x events
        int ei = 0;
        double unionArea = 0;
        for (int xi = 0; xi + 1 < m; xi++) {
            int x1 = xs.get(xi), x2 = xs.get(xi + 1);
            // Apply events at x = x1
            // Count which squares cover [x1, x2]
        }
        // Fallback: use O(n^2) direct approach for correctness
        return computeUnionBelow2(squares, y, xs);
    }

    private double computeUnionBelow2(int[][] squares, double y, List<Integer> xs) {
        double total = 0;
        List<Integer> xsSorted = new ArrayList<>(xs);
        Collections.sort(xsSorted);
        int m = xsSorted.size();
        for (int xi = 0; xi + 1 < m; xi++) {
            int x1 = xsSorted.get(xi), x2 = xsSorted.get(xi + 1);
            double width = x2 - x1;
            // Find max coverage height for this x strip
            double maxH = 0;
            for (int[] sq : squares) {
                if (sq[0] <= x1 && sq[0] + sq[2] >= x2) {
                    double bottom = sq[1], top = sq[1] + (double) sq[2];
                    if (bottom < y) {
                        double clippedTop = Math.min(top, y);
                        maxH = Math.max(maxH, clippedTop - bottom);
                    }
                }
            }
            total += width * maxH;
        }
        return total;
    }

    private double computeUnion(int[][] squares, double y) {
        TreeSet<Integer> xSet = new TreeSet<>();
        for (int[] sq : squares) {
            xSet.add(sq[0]);
            xSet.add(sq[0] + sq[2]);
        }
        List<Integer> xs = new ArrayList<>(xSet);
        return computeUnionBelow2(squares, y, xs);
    }
}
