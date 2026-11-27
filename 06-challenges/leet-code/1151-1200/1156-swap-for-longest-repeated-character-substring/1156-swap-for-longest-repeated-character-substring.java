// https://leetcode.com/problems/swap-for-longest-repeated-character-substring/

// Solution: Run-Length Groups — O(n) time, O(1) space
class Solution {
    public int maxRepOpt1(String text) {
        int[] count = new int[26];
        for (char c : text.toCharArray()) {
            count[c - 'a']++;
        }
        // Build run-length encoding
        List<int[]> runs = new ArrayList<>();
        int i = 0, n = text.length();
        while (i < n) {
            int j = i;
            while (j < n && text.charAt(j) == text.charAt(i)) {
                j++;
            }
            runs.add(new int[]{text.charAt(i) - 'a', j - i});
            i = j;
        }
        int ans = 0;
        for (int r = 0; r < runs.size(); r++) {
            int ch = runs.get(r)[0];
            int len = runs.get(r)[1];
            // Single run + possible swap from elsewhere
            int best = Math.min(len + 1, count[ch]);
            // Two same-char runs separated by a single-char gap
            if (r + 2 < runs.size() && runs.get(r + 1)[1] == 1 && runs.get(r + 2)[0] == ch) {
                int merged = len + runs.get(r + 2)[1] + 1;
                best = Math.max(best, Math.min(merged, count[ch]));
            }
            ans = Math.max(ans, best);
        }
        return ans;
    }
}
