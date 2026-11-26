// https://leetcode.com/problems/the-k-th-lexicographical-string-of-all-happy-strings-of-length-n/

// Solution: Backtracking / Direct Computation — O(n) time, O(n) space
class Solution {
    public String getHappyString(int n, int k) {
        int total = 3 * (1 << (n-1));
        if (k > total) return "";
        char[] res = new char[n];
        char prev = 0;
        for (int i = 0; i < n; i++) {
            int perChar = 1 << (n - 1 - i);
            int choices = (i == 0) ? 3 : 2;
            int found = 0;
            for (char c = 'a'; c <= 'c'; c++) {
                if (c == prev) continue;
                if (found + perChar >= k) { res[i] = c; prev = c; break; }
                found += perChar; k -= perChar;
            }
        }
        return new String(res);
    }
}
