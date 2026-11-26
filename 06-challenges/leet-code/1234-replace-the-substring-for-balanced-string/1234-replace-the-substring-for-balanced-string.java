// https://leetcode.com/problems/replace-the-substring-for-balanced-string/

// Solution: Sliding Window — O(n) time, O(1) space
// Solution: Sliding Window — O(n) time, O(1) space
class Solution {
    public int balancedString(String s) {
        int n = s.length(), k = n / 4;
        int[] count = new int[128];
        for (char c : s.toCharArray()) count[c]++;
        if (count['Q']==k && count['W']==k && count['E']==k && count['R']==k) return 0;
        int res = n, l = 0;
        for (int r = 0; r < n; r++) {
            count[s.charAt(r)]--;
            while (l <= r && count['Q']<=k && count['W']<=k && count['E']<=k && count['R']<=k) {
                res = Math.min(res, r - l + 1);
                count[s.charAt(l++)]++;
            }
        }
        return res;
    }
}
