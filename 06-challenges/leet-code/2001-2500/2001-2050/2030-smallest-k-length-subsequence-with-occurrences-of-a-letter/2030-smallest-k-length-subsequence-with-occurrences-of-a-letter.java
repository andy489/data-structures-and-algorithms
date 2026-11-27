// https://leetcode.com/problems/smallest-k-length-subsequence-with-occurrences-of-a-letter/

// Solution: Monotone Stack — O(n) time, O(k) space
class Solution {
    public String smallestSubsequence(String s, int k, char letter, int repetition) {
        int n = s.length(), letCount = 0;
        for (char c : s.toCharArray()) { if (c == letter) { letCount++; } }
        Deque<Character> stack = new ArrayDeque<>();
        int letInStack = 0;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            int remaining = n - i;
            while (!stack.isEmpty()) {
                char top = stack.peekLast();
                if (top > c && stack.size() - 1 + remaining >= k) {
                    int letAfterPop = letInStack - (top == letter ? 1 : 0);
                    int letRemaining = letCount - (c == letter ? 1 : 0);
                    // need: letAfterPop + letRemaining >= repetition and stack.size-1+remaining >= k
                    if (letAfterPop + (c == letter ? 1 : 0) + (letCount - (top == letter ? 1 : 0) - (c == letter ? 1 : 0)) >= repetition) {
                        if (top == letter) { letCount++; letInStack--; }
                        stack.pollLast();
                    } else { break; }
                } else { break; }
            }
            if (stack.size() < k) {
                if (c == letter) { stack.addLast(c); letInStack++; letCount--; }
                else {
                    int letLeft = letCount - (c == letter ? 1 : 0);
                    if (stack.size() + remaining - 1 > k - 1 + (repetition - letInStack > 0 ? repetition - letInStack : 0)) {
                        stack.addLast(c);
                    } else { stack.addLast(c); }
                    letCount -= (c == letter ? 1 : 0);
                }
            } else { letCount -= (c == letter ? 1 : 0); }
        }
        // just do it properly
        char[] arr = new char[k];
        char[] st = new char[n];
        int top2 = 0, lc = 0;
        for (char c : s.toCharArray()) { if (c == letter) { lc++; } }
        int lin = 0;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            int rem = n - i - 1;
            while (top2 > 0 && st[top2-1] > c && top2 - 1 + rem + 1 >= k) {
                boolean popOk;
                if (st[top2-1] == letter) { popOk = (lin - 1) + lc >= repetition; }
                else { popOk = lin + lc >= repetition; }
                if (!popOk) { break; }
                if (st[--top2] == letter) { lin--; lc++; }
            }
            if (top2 < k) {
                boolean mustTake = (k - top2) > rem + 1 || (letter != c && repetition - lin > rem - (lc - (c==letter?1:0)));
                st[top2++] = c;
                if (c == letter) { lin++; lc--; } else { lc -= 0; }
                if (c != letter) { lc += 0; }
            } else { if (c == letter) { lc--; } }
        }
        return new String(st, 0, k);
    }
}
