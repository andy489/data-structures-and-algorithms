// https://leetcode.com/problems/execution-of-all-suffix-instructions-staying-in-a-grid/
class Solution {
    public int[] executeInstructions(int n, int[] startPos, String s) {
        int m = s.length();
        int[] answer = new int[m];
        for (int i = 0; i < m; i++) {
            int r = startPos[0], c = startPos[1];
            int count = 0;
            for (int j = i; j < m; j++) {
                char ch = s.charAt(j);
                if (ch == 'L') { c--; }
                else if (ch == 'R') { c++; }
                else if (ch == 'U') { r--; }
                else { r++; }
                if (r < 0 || r >= n || c < 0 || c >= n) {
                    break;
                }
                count++;
            }
            answer[i] = count;
        }
        return answer;
    }
}
