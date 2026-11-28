// https://leetcode.com/problems/unique-3-digit-even-numbers/

// Solution: Brute Force Enumeration — O(1) time, O(1) space
class Solution {
    public int totalNumbers(int[] digits) {
        int[] freq = new int[10];
        for (int d : digits) {
            freq[d]++;
        }
        int count = 0;
        for (int num = 100; num <= 998; num += 2) {
            int h = num / 100;
            int t = (num / 10) % 10;
            int u = num % 10;
            freq[h]--;
            freq[t]--;
            freq[u]--;
            if (freq[h] >= 0 && freq[t] >= 0 && freq[u] >= 0) {
                count++;
            }
            freq[h]++;
            freq[t]++;
            freq[u]++;
        }
        return count;
    }
}
