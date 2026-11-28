// https://leetcode.com/problems/longest-unequal-adjacent-groups-subsequence-ii/

// Solution: Dynamic Programming (LIS variant) — O(n^2 * L) time, O(n) space
class Solution {
    private int hammingDistance(String a, String b) {
        int dist = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                dist++;
            }
        }
        return dist;
    }

    public List<String> getWordsInLongestSubsequence(String[] words, int[] groups) {
        int n = words.length;
        int[] dp = new int[n];
        int[] prev = new int[n];
        Arrays.fill(dp, 1);
        Arrays.fill(prev, -1);

        int best = 0;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (groups[j] != groups[i]
                        && words[j].length() == words[i].length()
                        && hammingDistance(words[j], words[i]) == 1) {
                    if (dp[j] + 1 > dp[i]) {
                        dp[i] = dp[j] + 1;
                        prev[i] = j;
                    }
                }
            }
            if (dp[i] > dp[best]) {
                best = i;
            }
        }

        List<String> result = new ArrayList<>();
        for (int cur = best; cur != -1; cur = prev[cur]) {
            result.add(words[cur]);
        }
        Collections.reverse(result);
        return result;
    }
}
