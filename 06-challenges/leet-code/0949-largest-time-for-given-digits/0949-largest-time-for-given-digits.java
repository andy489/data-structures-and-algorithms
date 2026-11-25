// https://leetcode.com/problems/largest-time-for-given-digits/

// Solution: Try All Permutations — O(1) time, O(1) space
class Solution {
    public String largestTimeFromDigits(int[] arr) {
        int best = -1;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (j == i) {
                    continue;
                }
                for (int k = 0; k < 4; k++) {
                    if (k == i || k == j) {
                        continue;
                    }
                    int l = 6 - i - j - k;
                    int h = arr[i] * 10 + arr[j];
                    int m = arr[k] * 10 + arr[l];
                    if (h < 24 && m < 60) {
                        best = Math.max(best, h * 60 + m);
                    }
                }
            }
        }
        return best == -1 ? "" : String.format("%02d:%02d", best / 60, best % 60);
    }
}
