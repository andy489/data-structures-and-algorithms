// https://leetcode.com/problems/falling-squares/

// Solution: Brute Force Interval Check — O(n²) time, O(n) space
class Solution {
    public List<Integer> fallingSquares(int[][] positions) {
        List<int[]> intervals = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        int globalMax = 0;
        for (int[] pos : positions) {
            int l = pos[0], side = pos[1], r = l + side;
            int base = 0;
            for (int[] interval : intervals) {
                int il = interval[0], ir = interval[1], ih = interval[2];
                if (il < r && ir > l) {
                    base = Math.max(base, ih);
                }
            }
            int height = base + side;
            intervals.add(new int[]{l, r, height});
            globalMax = Math.max(globalMax, height);
            result.add(globalMax);
        }
        return result;
    }
}
