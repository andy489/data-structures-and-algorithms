// https://leetcode.com/problems/distribute-candies-among-children-i/

// Solution: Brute Force Enumeration — O(limit²) time, O(1) space
class Solution {
    public int distributeCandies(int n, int limit) {
        int count = 0;
        for (int i = 0; i <= limit; i++) {
            for (int j = 0; j <= limit; j++) {
                int k = n - i - j;
                if (k >= 0 && k <= limit) {
                    count++;
                }
            }
        }
        return count;
    }
}
