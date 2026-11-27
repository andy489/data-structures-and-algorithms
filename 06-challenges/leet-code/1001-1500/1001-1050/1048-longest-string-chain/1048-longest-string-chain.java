// https://leetcode.com/problems/longest-string-chain/

// Solution: DP with Word Predecessors — O(n * L²) time, O(n * L) space
class Solution {
    public int longestStrChain(String[] words) {
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        Map<String, Integer> dp = new HashMap<>();
        int res = 1;
        for (String w : words) {
            dp.put(w, 1);
            for (int i = 0; i < w.length(); i++) {
                String prev = w.substring(0, i) + w.substring(i + 1);
                if (dp.containsKey(prev)) {
                    dp.put(w, Math.max(dp.get(w), dp.get(prev) + 1));
                }
            }
            res = Math.max(res, dp.get(w));
        }
        return res;
    }
}
