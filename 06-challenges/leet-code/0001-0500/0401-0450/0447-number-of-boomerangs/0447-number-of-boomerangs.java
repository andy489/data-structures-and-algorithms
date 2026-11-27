// https://leetcode.com/problems/number-of-boomerangs/

// Solution: HashMap of Squared Distances — O(n²) time, O(n) space
class Solution {
    public int numberOfBoomerangs(int[][] points) {
        int result = 0;
        for (int[] p1 : points) {
            HashMap<Integer, Integer> distanceCounts = new HashMap<>();
            for (int[] p2 : points) {
                int dx = p1[0] - p2[0];
                int dy = p1[1] - p2[1];
                int squaredDist = dx * dx + dy * dy;
                distanceCounts.merge(squaredDist, 1, Integer::sum);
            }
            for (int count : distanceCounts.values()) {
                result += count * (count - 1);
            }
        }
        return result;
    }
}
