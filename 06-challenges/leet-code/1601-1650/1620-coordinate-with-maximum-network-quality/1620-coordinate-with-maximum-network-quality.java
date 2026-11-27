// https://leetcode.com/problems/coordinate-with-maximum-network-quality/

// Solution: Grid Brute Force — O(C^2 * T) time, O(1) space
class Solution {
    public int[] bestCoordinate(int[][] towers, int radius) {
        int maxQuality = 0;
        int[] best = new int[]{0, 0};
        for (int x = 0; x <= 50; x++) {
            for (int y = 0; y <= 50; y++) {
                int quality = 0;
                for (int[] tower : towers) {
                    int dx = x - tower[0], dy = y - tower[1];
                    double d = Math.sqrt(dx * dx + dy * dy);
                    if (d <= radius) {
                        quality += (int) (tower[2] / (1 + d));
                    }
                }
                if (quality > maxQuality) {
                    maxQuality = quality;
                    best[0] = x;
                    best[1] = y;
                }
            }
        }
        return best;
    }
}
