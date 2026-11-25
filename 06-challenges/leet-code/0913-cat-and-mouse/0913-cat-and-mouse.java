// https://leetcode.com/problems/cat-and-mouse/

// Solution: BFS Retrograde Analysis — O(n³) time, O(n³) space
class Solution {
    static final int DRAW = 0, MOUSE = 1, CAT = 2;

    public int catMouseGame(int[][] graph) {
        int n = graph.length;
        int[][][] color = new int[n][n][3];
        int[][][] degree = new int[n][n][3];
        for (int m = 0; m < n; m++) {
            for (int c = 0; c < n; c++) {
                degree[m][c][1] = graph[m].length;
                degree[m][c][2] = graph[c].length;
                for (int next : graph[c]) {
                    if (next == 0) {
                        degree[m][c][2]--;
                    }
                }
            }
        }
        int[][] queue = new int[2 * n * n * 3][3];
        int head = 0, tail = 0;
        for (int i = 1; i < n; i++) {
            for (int t = 1; t <= 2; t++) {
                color[0][i][t] = MOUSE;
                queue[tail][0] = 0; queue[tail][1] = i; queue[tail++][2] = t;
                if (i != 0) {
                    color[i][i][t] = CAT;
                    queue[tail][0] = i; queue[tail][1] = i; queue[tail++][2] = t;
                }
            }
        }
        while (head < tail) {
            int m = queue[head][0], c = queue[head][1], t = queue[head++][2];
            int result = color[m][c][t];
            int prevT = 3 - t;
            if (prevT == 1) {
                for (int pm : graph[m]) {
                    if (color[pm][c][1] != DRAW) continue;
                    if (result == MOUSE) {
                        color[pm][c][1] = MOUSE;
                        queue[tail][0] = pm; queue[tail][1] = c; queue[tail++][2] = 1;
                    } else {
                        if (--degree[pm][c][1] == 0) {
                            color[pm][c][1] = CAT;
                            queue[tail][0] = pm; queue[tail][1] = c; queue[tail++][2] = 1;
                        }
                    }
                }
            } else {
                for (int pc : graph[c]) {
                    if (pc == 0) continue;
                    if (color[m][pc][2] != DRAW) continue;
                    if (result == CAT) {
                        color[m][pc][2] = CAT;
                        queue[tail][0] = m; queue[tail][1] = pc; queue[tail++][2] = 2;
                    } else {
                        if (--degree[m][pc][2] == 0) {
                            color[m][pc][2] = MOUSE;
                            queue[tail][0] = m; queue[tail][1] = pc; queue[tail++][2] = 2;
                        }
                    }
                }
            }
        }
        return color[1][2][1];
    }
}
