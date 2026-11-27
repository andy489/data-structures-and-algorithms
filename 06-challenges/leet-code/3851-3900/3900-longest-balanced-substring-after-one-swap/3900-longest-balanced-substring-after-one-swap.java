// https://leetcode.com/problems/longest-balanced-substring-after-one-swap/
class Solution {
    public int longestBalancedSubstring(String s) {
        int n = s.length();
        int total0 = 0, total1 = 0;
        for (char c : s.toCharArray()) {
            if (c == '0') {
                total0++;
            } else {
                total1++;
            }
        }

        int best = 0;
        int cnt0 = 0, cnt1 = 0;
        int left = 0;

        for (int right = 0; right < n; right++) {
            if (s.charAt(right) == '0') {
                cnt0++;
            } else {
                cnt1++;
            }

            // Shrink window while imbalance is too large
            while (Math.abs(cnt0 - cnt1) > 2) {
                if (s.charAt(left) == '0') {
                    cnt0--;
                } else {
                    cnt1--;
                }
                left++;
            }

            int len = right - left + 1;
            if (cnt0 == cnt1) {
                best = Math.max(best, len);
            } else if (cnt0 - cnt1 == 2 && (total1 - cnt1) >= 1) {
                best = Math.max(best, len - 1); // window length minus 1 (we swap one excess 0 out)
            } else if (cnt1 - cnt0 == 2 && (total0 - cnt0) >= 1) {
                best = Math.max(best, len - 1);
            }
        }

        // The best balanced length must be even
        if (best % 2 != 0) {
            best--;
        }
        return best;
    }
}
