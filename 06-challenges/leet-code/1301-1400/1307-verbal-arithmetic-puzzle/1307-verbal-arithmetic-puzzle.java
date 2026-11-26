// https://leetcode.com/problems/verbal-arithmetic-puzzle/

// Solution: Backtracking — O(10!) time, O(1) space
class Solution {
    int[] digitOf;
    boolean[] usedDigit;
    boolean[] noLeadZero;
    char[] chars;
    int[] colSum;
    int numCols;

    public boolean isSolvable(String[] words, String result) {
        digitOf = new int[26];
        Arrays.fill(digitOf, -1);
        usedDigit = new boolean[10];
        Set<Character> noLeadSet = new HashSet<>();
        int maxLen = result.length();
        for (String w : words) {
            if (w.length() > 1) noLeadSet.add(w.charAt(0));
            maxLen = Math.max(maxLen, w.length());
        }
        if (result.length() > 1) noLeadSet.add(result.charAt(0));

        List<Character> charList = new ArrayList<>();
        noLeadZero = new boolean[26];
        for (char c : noLeadSet) noLeadZero[c-'A'] = true;

        // collect unique chars
        boolean[] seen = new boolean[26];
        for (String w : words) for (char c : w.toCharArray()) if (!seen[c-'A']) { seen[c-'A']=true; charList.add(c); }
        for (char c : result.toCharArray()) if (!seen[c-'A']) { seen[c-'A']=true; charList.add(c); }
        chars = new char[charList.size()];
        for (int i = 0; i < chars.length; i++) chars[i] = charList.get(i);

        // col contribution: +1 for words, -1 for result, multiplied by 10^col
        numCols = maxLen;
        colSum = new int[chars.length];
        for (int col = 0; col < maxLen; col++) {
            for (String w : words) {
                int idx = w.length()-1-col;
                if (idx >= 0) {
                    int ci = indexOf(w.charAt(idx));
                    colSum[ci] += (int)Math.pow(10, col);
                }
            }
            int idx = result.length()-1-col;
            if (idx >= 0) {
                int ci = indexOf(result.charAt(idx));
                colSum[ci] -= (int)Math.pow(10, col);
            }
        }
        return bt(0, 0);
    }

    private int indexOf(char c) {
        for (int i = 0; i < chars.length; i++) if (chars[i] == c) return i;
        return -1;
    }

    private boolean bt(int idx, int total) {
        if (idx == chars.length) return total == 0;
        char c = chars[idx];
        int ci = c - 'A';
        for (int d = 0; d <= 9; d++) {
            if (usedDigit[d]) continue;
            if (d == 0 && noLeadZero[ci]) continue;
            digitOf[ci] = d;
            usedDigit[d] = true;
            if (bt(idx+1, total + colSum[idx]*d)) return true;
            digitOf[ci] = -1;
            usedDigit[d] = false;
        }
        return false;
    }
}
