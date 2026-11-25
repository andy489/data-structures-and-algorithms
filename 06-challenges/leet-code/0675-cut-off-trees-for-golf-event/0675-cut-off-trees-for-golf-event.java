// https://leetcode.com/problems/cut-off-trees-for-golf-event/

// Solution: BFS between sorted targets — O((m·n)²) time, O(m·n) space
class Solution {
    public int cutOffTree(List<List<Integer>> forest) {
        int m = forest.size(), n = forest.get(0).size();
        List<int[]> trees = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int v = forest.get(i).get(j);
                if (v > 1) {
                    trees.add(new int[]{v, i, j});
                }
            }
        }
        trees.sort((a, b) -> a[0] - b[0]);
        int sr = 0, sc = 0, total = 0;
        for (int[] tree : trees) {
            int steps = bfs(forest, sr, sc, tree[1], tree[2], m, n);
            if (steps == -1) {
                return -1;
            }
            total += steps;
            sr = tree[1];
            sc = tree[2];
        }
        return total;
    }

    private int bfs(List<List<Integer>> forest, int sr, int sc, int tr, int tc, int m, int n) {
        if (sr == tr && sc == tc) {
            return 0;
        }
        boolean[][] visited = new boolean[m][n];
        int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{sr, sc, 0});
        visited[sr][sc] = true;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            for (int[] d : dirs) {
                int nr = cur[0] + d[0], nc = cur[1] + d[1];
                if (nr >= 0 && nr < m && nc >= 0 && nc < n && !visited[nr][nc] && forest.get(nr).get(nc) != 0) {
                    if (nr == tr && nc == tc) {
                        return cur[2] + 1;
                    }
                    visited[nr][nc] = true;
                    queue.offer(new int[]{nr, nc, cur[2] + 1});
                }
            }
        }
        return -1;
    }
}
