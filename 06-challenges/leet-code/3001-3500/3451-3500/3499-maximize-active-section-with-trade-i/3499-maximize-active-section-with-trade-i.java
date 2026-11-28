// https://leetcode.com/problems/maximize-active-section-with-trade-i/

// Solution: Run-Length Encoding with Sliding Window — O(n) time, O(n) space
class Solution {
    public int maxActiveSectionsAfterTrade(String s) {
        // Count original 1s
        int totalOnes = 0;
        for (char c : s.toCharArray()) {
            if (c == '1') {
                totalOnes++;
            }
        }

        // Augment string with '1' at both ends
        String t = "1" + s + "1";
        int len = t.length();

        // Build run-length encoding: list of (char, length) pairs
        List<long[]> runs = new ArrayList<>();
        int i = 0;
        while (i < len) {
            char c = t.charAt(i);
            int start = i;
            while (i < len && t.charAt(i) == c) {
                i++;
            }
            runs.add(new long[]{c - '0', i - start});
        }

        int bestGain = 0;
        // Look for pattern: 0-run, 1-run, 0-run (triplet at positions idx-1, idx, idx+1)
        // The 1-run must be surrounded by 0-runs in augmented string
        for (int idx = 1; idx < runs.size() - 1; idx++) {
            if (runs.get(idx)[0] == 1 && runs.get(idx - 1)[0] == 0 && runs.get(idx + 1)[0] == 0) {
                int gain = (int) (runs.get(idx - 1)[1] + runs.get(idx + 1)[1]);
                bestGain = Math.max(bestGain, gain);
            }
        }

        return totalOnes + bestGain;
    }
}
