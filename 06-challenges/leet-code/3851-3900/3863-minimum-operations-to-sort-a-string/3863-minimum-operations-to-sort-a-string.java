// https://leetcode.com/problems/minimum-operations-to-sort-a-string/

class Solution {
    public int minimumOperations(String s) {
        int n = s.length();
        if (n == 1) {
            return 0;
        }
        // Check if already sorted
        boolean sorted = true;
        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) > s.charAt(i + 1)) {
                sorted = false;
                break;
            }
        }
        if (sorted) {
            return 0;
        }
        // Length 2 and not sorted -> impossible
        if (n == 2) {
            return -1;
        }
        // Count descents (positions where s[i] > s[i+1])
        int descents = 0;
        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) > s.charAt(i + 1)) {
                descents++;
            }
        }
        return descents;
    }
}
