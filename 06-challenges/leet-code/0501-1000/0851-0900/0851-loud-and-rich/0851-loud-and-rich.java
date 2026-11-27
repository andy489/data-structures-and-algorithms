// https://leetcode.com/problems/loud-and-rich/

// Solution: DFS with Memoization — O(n + e) time, O(n + e) space
class Solution {
    private List<Integer>[] richerThan;
    private int[] answer;
    private int[] quiet;

    public int[] loudAndRich(int[][] richer, int[] quiet) {
        int n = quiet.length;
        this.quiet = quiet;
        richerThan = new List[n];
        answer = new int[n];
        for (int i = 0; i < n; i++) {
            richerThan[i] = new ArrayList<>();
            answer[i] = -1;
        }
        for (int[] pair : richer) {
            richerThan[pair[1]].add(pair[0]);
        }
        for (int i = 0; i < n; i++) {
            dfs(i);
        }
        return answer;
    }

    private int dfs(int x) {
        if (answer[x] != -1) {
            return answer[x];
        }
        answer[x] = x;
        for (int r : richerThan[x]) {
            int candidate = dfs(r);
            if (quiet[candidate] < quiet[answer[x]]) {
                answer[x] = candidate;
            }
        }
        return answer[x];
    }
}
