// https://leetcode.com/problems/building-boxes/

// Solution: Math / Greedy (Tetrahedral Layer Counts) — O(n^(1/3)) time, O(1) space
class Solution {
    public int minimumBoxes(int n) {
        // Find largest h such that h*(h+1)*(h+2)/6 <= n
        int h = 0;
        long total = 0;
        while (total + (long)(h + 1) * (h + 2) / 2 <= n) {
            h++;
            total += (long) h * (h + 1) / 2;
        }
        // Floor boxes for h complete layers
        long floor = (long) h * (h + 1) / 2;
        // Add extra floor boxes one at a time for the remaining
        int i = 1;
        while (total < n) {
            total += i;
            floor++;
            i++;
        }
        return (int) floor;
    }
}
