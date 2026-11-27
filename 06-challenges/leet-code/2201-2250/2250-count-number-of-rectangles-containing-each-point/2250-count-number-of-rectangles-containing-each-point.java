// https://leetcode.com/problems/count-number-of-rectangles-containing-each-point/

class Solution {
    public int[] countRectangles(int[][] rectangles, int[][] points) {
        List<List<Integer>> byHeight = new ArrayList<>();
        for (int i = 0; i <= 100; i++) {
            byHeight.add(new ArrayList<>());
        }
        for (int[] rect : rectangles) {
            byHeight.get(rect[1]).add(rect[0]);
        }
        for (int h = 1; h <= 100; h++) {
            Collections.sort(byHeight.get(h));
        }

        int[] ans = new int[points.length];
        for (int i = 0; i < points.length; i++) {
            int x = points[i][0], y = points[i][1];
            for (int h = y; h <= 100; h++) {
                List<Integer> lengths = byHeight.get(h);
                int lo = 0, hi = lengths.size();
                while (lo < hi) {
                    int mid = (lo + hi) / 2;
                    if (lengths.get(mid) >= x) {
                        hi = mid;
                    } else {
                        lo = mid + 1;
                    }
                }
                ans[i] += lengths.size() - lo;
            }
        }
        return ans;
    }
}
