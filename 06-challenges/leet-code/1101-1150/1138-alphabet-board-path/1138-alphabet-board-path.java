// https://leetcode.com/problems/alphabet-board-path/

// Solution: Greedy Step-by-Step Navigation — O(n) time, O(n) space
class Solution {
    public String alphabetBoardPath(String target) {
        StringBuilder sb = new StringBuilder();
        int cr = 0, cc = 0;
        for (char ch : target.toCharArray()) {
            int idx = ch - 'a';
            int tr = idx / 5;
            int tc = idx % 5;
            int dr = tr - cr;
            int dc = tc - cc;
            // Move U and L first (safe when targeting 'z' from right column,
            // or leaving 'z' by going up before right)
            if (dr < 0) {
                sb.append("U".repeat(-dr));
            }
            if (dc < 0) {
                sb.append("L".repeat(-dc));
            }
            if (dr > 0) {
                sb.append("D".repeat(dr));
            }
            if (dc > 0) {
                sb.append("R".repeat(dc));
            }
            sb.append('!');
            cr = tr;
            cc = tc;
        }
        return sb.toString();
    }
}
