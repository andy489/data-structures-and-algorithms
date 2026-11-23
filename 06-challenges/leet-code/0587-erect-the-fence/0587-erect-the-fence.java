// https://leetcode.com/problems/erect-the-fence/
class Solution {
    public int[][] outerTrees(int[][] trees) {
        int n = trees.length;
        if (n <= 3) {
            return trees;
        }
        Arrays.sort(trees, (a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);
        int[] hull = new int[2 * n];
        int k = 0;
        for (int i = 0; i < n; i++) {
            while (k >= 2 && cross(trees[hull[k - 2]], trees[hull[k - 1]], trees[i]) < 0) {
                k--;
            }
            hull[k++] = i;
        }
        for (int i = n - 2, t = k + 1; i >= 0; i--) {
            while (k >= t && cross(trees[hull[k - 2]], trees[hull[k - 1]], trees[i]) < 0) {
                k--;
            }
            hull[k++] = i;
        }
        Set<Integer> onHull = new HashSet<>();
        for (int i = 0; i < k - 1; i++) {
            onHull.add(hull[i]);
        }
        int[][] result = new int[onHull.size()][2];
        int idx = 0;
        for (int i : onHull) {
            result[idx++] = trees[i];
        }
        return result;
    }

    private long cross(int[] O, int[] A, int[] B) {
        return (long) (A[0] - O[0]) * (B[1] - O[1]) - (long) (A[1] - O[1]) * (B[0] - O[0]);
    }
}
