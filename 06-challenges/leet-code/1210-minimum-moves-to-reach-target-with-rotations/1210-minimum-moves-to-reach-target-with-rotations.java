// https://leetcode.com/problems/minimum-moves-to-reach-target-with-rotations/

// Solution: BFS — O(n²) time, O(n²) space
// Solution: BFS — O(n²) time, O(n²) space
class Solution {
    public int minimumMoves(int[][] grid) {
        int n = grid.length;
        boolean[][][] visited = new boolean[n][n][2];
        Deque<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{0, 0, 0});
        visited[0][0][0] = true;
        int steps = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int[] cur = queue.poll();
                int r = cur[0], c = cur[1], d = cur[2];
                if (r == n-1 && c == n-2 && d == 0) return steps;
                if (d == 0) {
                    if (c+2 < n && grid[r][c+2] == 0 && !visited[r][c+1][0]) { visited[r][c+1][0]=true; queue.add(new int[]{r,c+1,0}); }
                    if (r+1 < n && grid[r+1][c] == 0 && grid[r+1][c+1] == 0 && !visited[r+1][c][0]) { visited[r+1][c][0]=true; queue.add(new int[]{r+1,c,0}); }
                    if (r+1 < n && grid[r+1][c] == 0 && grid[r+1][c+1] == 0 && !visited[r][c][1]) { visited[r][c][1]=true; queue.add(new int[]{r,c,1}); }
                } else {
                    if (r+2 < n && grid[r+2][c] == 0 && !visited[r+1][c][1]) { visited[r+1][c][1]=true; queue.add(new int[]{r+1,c,1}); }
                    if (c+1 < n && grid[r][c+1] == 0 && grid[r+1][c+1] == 0 && !visited[r][c+1][1]) { visited[r][c+1][1]=true; queue.add(new int[]{r,c+1,1}); }
                    if (c+1 < n && grid[r][c+1] == 0 && grid[r+1][c+1] == 0 && !visited[r][c][0]) { visited[r][c][0]=true; queue.add(new int[]{r,c,0}); }
                }
            }
            steps++;
        }
        return -1;
    }
}
