// https://leetcode.com/problems/find-the-winner-of-an-array-game/

// Solution: Single Pass Simulation — O(n) time, O(1) space
class Solution {
    public int getWinner(int[] arr, int k) {
        int current = arr[0];
        int wins = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > current) {
                current = arr[i];
                wins = 1;
            } else {
                wins++;
            }
            if (wins >= k) {
                return current;
            }
        }
        return current;
    }
}
