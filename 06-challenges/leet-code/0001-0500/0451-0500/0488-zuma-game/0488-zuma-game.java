// https://leetcode.com/problems/zuma-game/

// Solution: DFS with Memoization — O(board! · hand!) time, O(states) space
class Solution {
    public int findMinStep(String board, String hand) {
        int[] handCount = new int[26];
        for (char c : hand.toCharArray()) {
            handCount[c - 'A']++;
        }
        int result = dfs(board, handCount);
        return result == Integer.MAX_VALUE ? -1 : result;
    }

    private int dfs(String board, int[] handCount) {
        board = collapse(board);
        if (board.isEmpty()) {
            return 0;
        }
        int result = Integer.MAX_VALUE;
        int i = 0;
        while (i < board.length()) {
            int j = i;
            while (j < board.length() && board.charAt(j) == board.charAt(i)) {
                j++;
            }
            int need = 3 - (j - i);
            int colorIdx = board.charAt(i) - 'A';
            if (handCount[colorIdx] >= need) {
                handCount[colorIdx] -= need;
                String next = board.substring(0, i) + board.substring(j);
                int sub = dfs(next, handCount);
                if (sub != Integer.MAX_VALUE) {
                    result = Math.min(result, sub + need);
                }
                handCount[colorIdx] += need;
            }
            i = j;
        }
        return result;
    }

    private String collapse(String board) {
        StringBuilder sb = new StringBuilder(board);
        int i = 0;
        while (i < sb.length()) {
            int j = i;
            while (j < sb.length() && sb.charAt(j) == sb.charAt(i)) {
                j++;
            }
            if (j - i >= 3) {
                sb.delete(i, j);
                i = 0;
            } else {
                i = j;
            }
        }
        return sb.toString();
    }
}
