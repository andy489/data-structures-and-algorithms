// https://leetcode.com/problems/couples-holding-hands/

// Solution: Greedy Swap — O(n²) time, O(1) space
class Solution {
    public int minSwapsCouples(int[] row) {
        int swaps = 0;
        for (int i = 0; i < row.length; i += 2) {
            int partner = row[i] ^ 1;
            if (row[i + 1] == partner) {
                continue;
            }
            for (int j = i + 2; j < row.length; j++) {
                if (row[j] == partner) {
                    int tmp = row[i + 1];
                    row[i + 1] = row[j];
                    row[j] = tmp;
                    swaps++;
                    break;
                }
            }
        }
        return swaps;
    }
}
