// https://leetcode.com/problems/count-valid-word-occurrences/

class Solution {
    public int[] countValidWordOccurrences(String[] chunks, String[] queries) {
        StringBuilder sb = new StringBuilder();
        for (String c : chunks) {
            sb.append(c);
        }
        String s = sb.toString();
        int n = s.length();
        Map<String, Integer> freq = new HashMap<>();
        int start = -1;
        for (int i = 0; i <= n; i++) {
            char ch = (i < n) ? s.charAt(i) : ' ';
            if (i < n && Character.isLowerCase(ch)) {
                if (start == -1) {
                    start = i;
                }
            } else if (i < n && ch == '-') {
                // joiner hyphen: next char must be letter
                if (start == -1 || i + 1 >= n || !Character.isLowerCase(s.charAt(i + 1))) {
                    // not a joiner: flush current token, reset
                    if (start != -1) {
                        String word = s.substring(start, i);
                        freq.merge(word, 1, Integer::sum);
                        start = -1;
                    }
                }
                // else: joiner, continue building word
            } else {
                // separator (space or end)
                if (start != -1) {
                    String word = s.substring(start, i);
                    freq.merge(word, 1, Integer::sum);
                    start = -1;
                }
            }
        }
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            ans[i] = freq.getOrDefault(queries[i], 0);
        }
        return ans;
    }
}
