// https://leetcode.com/problems/number-of-different-subsequences-gcds/

// Solution: Enumerate Candidates — O(max * log(max)) time, O(max) space
class Solution {
    private int gcd(int a, int b) {
        while (b != 0) {
            int t = b;
            b = a % b;
            a = t;
        }
        return a;
    }

    public int countDifferentSubsequencesGCDs(int[] nums) {
        int maxVal = 0;
        for (int x : nums) {
            maxVal = Math.max(maxVal, x);
        }
        boolean[] present = new boolean[maxVal + 1];
        for (int x : nums) {
            present[x] = true;
        }
        int ans = 0;
        for (int g = 1; g <= maxVal; g++) {
            int cur = 0;
            for (int multiple = g; multiple <= maxVal; multiple += g) {
                if (present[multiple]) {
                    cur = gcd(cur, multiple);
                    if (cur == g) {
                        ans++;
                        break;
                    }
                }
            }
        }
        return ans;
    }
}
