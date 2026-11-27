// https://leetcode.com/problems/apple-redistribution-into-boxes/

// Solution: Greedy (Sort Descending) — O(m log m) time, O(1) space
class Solution {
    public int minimumBoxes(int[] apple, int[] capacity) {
        int total = 0;
        for (int a : apple) { total += a; }
        java.util.Arrays.sort(capacity);
        int sum = 0, count = 0;
        for (int i = capacity.length - 1; i >= 0; i--) {
            sum += capacity[i];
            count++;
            if (sum >= total) { break; }
        }
        return count;
    }
}
