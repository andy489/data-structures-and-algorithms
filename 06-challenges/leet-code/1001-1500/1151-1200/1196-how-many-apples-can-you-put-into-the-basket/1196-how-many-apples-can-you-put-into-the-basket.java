// https://leetcode.com/problems/how-many-apples-can-you-put-into-the-basket/

// Solution: Sort and Greedy — O(n log n) time, O(1) space
class Solution {
    public int maxNumberOfApples(int[] weight) {
        Arrays.sort(weight);
        int total = 0, count = 0;
        for (int w : weight) {
            total += w;
            if (total > 5000) break;
            count++;
        }
        return count;
    }
}
