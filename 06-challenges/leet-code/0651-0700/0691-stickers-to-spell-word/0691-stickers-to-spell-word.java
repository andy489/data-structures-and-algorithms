// https://leetcode.com/problems/stickers-to-spell-word/

// Solution: DP with Bitmask — O(2^t · n · t) time, O(2^t) space
class Solution {
    public int minStickers(String[] stickers, String target) {
        int t = target.length();
        int total = 1 << t;
        int[] dp = new int[total];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int mask = 0; mask < total; mask++) {
            if (dp[mask] == Integer.MAX_VALUE) {
                continue;
            }
            for (String sticker : stickers) {
                int newMask = mask;
                int[] freq = new int[26];
                for (char c : sticker.toCharArray()) {
                    freq[c - 'a']++;
                }
                for (int i = 0; i < t; i++) {
                    if ((newMask >> i & 1) == 0) {
                        int ci = target.charAt(i) - 'a';
                        if (freq[ci] > 0) {
                            freq[ci]--;
                            newMask |= (1 << i);
                        }
                    }
                }
                if (dp[newMask] > dp[mask] + 1) {
                    dp[newMask] = dp[mask] + 1;
                }
            }
        }
        return dp[total - 1] == Integer.MAX_VALUE ? -1 : dp[total - 1];
    }
}
