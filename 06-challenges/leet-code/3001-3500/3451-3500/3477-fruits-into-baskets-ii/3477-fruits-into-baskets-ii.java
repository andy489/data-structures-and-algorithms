// https://leetcode.com/problems/fruits-into-baskets-ii/

// Solution: Brute Force Simulation — O(n^2) time, O(n) space
class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int n = fruits.length;
        boolean[] used = new boolean[n];
        int unplaced = 0;
        for (int i = 0; i < n; i++) {
            boolean placed = false;
            for (int j = 0; j < n; j++) {
                if (!used[j] && baskets[j] >= fruits[i]) {
                    used[j] = true;
                    placed = true;
                    break;
                }
            }
            if (!placed) {
                unplaced++;
            }
        }
        return unplaced;
    }
}
