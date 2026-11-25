// https://leetcode.com/problems/image-overlap/

// Solution: Offset Counting — O(n⁴) time, O(n²) space
class Solution {
    public int largestOverlap(int[][] img1, int[][] img2) {
        int n = img1.length;
        List<int[]> ones1 = new ArrayList<>(), ones2 = new ArrayList<>();
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                if (img1[r][c] == 1) {
                    ones1.add(new int[]{r, c});
                }
                if (img2[r][c] == 1) {
                    ones2.add(new int[]{r, c});
                }
            }
        }
        Map<Long, Integer> offsets = new HashMap<>();
        int max = 0;
        for (int[] p1 : ones1) {
            for (int[] p2 : ones2) {
                long key = (long)(p1[0] - p2[0] + n) * 100 + (p1[1] - p2[1] + n);
                int cnt = offsets.merge(key, 1, Integer::sum);
                max = Math.max(max, cnt);
            }
        }
        return max;
    }
}
