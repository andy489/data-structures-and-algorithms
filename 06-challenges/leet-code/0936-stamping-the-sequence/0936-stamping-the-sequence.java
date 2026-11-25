// https://leetcode.com/problems/stamping-the-sequence/

// Solution: Reverse Greedy — O(n²*m) time, O(n) space
class Solution {
    public int[] movesToStamp(String stamp, String target) {
        char[] t = target.toCharArray();
        char[] s = stamp.toCharArray();
        int n = t.length, m = s.length;
        boolean[] stamped = new boolean[n];
        java.util.List<Integer> result = new java.util.ArrayList<>();
        int stars = 0;
        while (stars < n) {
            boolean progress = false;
            for (int i = 0; i <= n - m; i++) {
                int covered = check(t, s, i);
                if (covered > 0) {
                    stars += covered;
                    progress = true;
                    result.add(i);
                    for (int j = i; j < i + m; j++) {
                        t[j] = '?';
                    }
                }
            }
            if (!progress) {
                return new int[0];
            }
        }
        java.util.Collections.reverse(result);
        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    private int check(char[] t, char[] s, int pos) {
        int covered = 0;
        for (int i = 0; i < s.length; i++) {
            if (t[pos + i] == '?') {
                continue;
            }
            if (t[pos + i] != s[i]) {
                return 0;
            }
            covered++;
        }
        return covered;
    }
}
