// https://leetcode.com/problems/k-closest-points-to-origin/

// Solution: Sort — O(n log n) time, O(1) space
class Solution {
    public int[][] kClosest(int[][] points, int k) {
        Arrays.sort(points, (a, b) -> (a[0]*a[0] + a[1]*a[1]) - (b[0]*b[0] + b[1]*b[1]));
        return Arrays.copyOfRange(points, 0, k);
    }
}
