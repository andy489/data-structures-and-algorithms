// https://leetcode.com/problems/escape-a-large-maze/

// Solution: BFS with Area Bound — O(B²) time, O(B²) space
class Solution {
    public boolean isEscapePossible(int[][] blocked, int[] source, int[] target) {
        Set<Long> blockedSet = new HashSet<>();
        for (int[] b : blocked) {
            blockedSet.add((long) b[0] * 1000000 + b[1]);
        }
        int maxEnclosed = blocked.length * blocked.length / 2;
        return bfs(source, target, blockedSet, maxEnclosed) && bfs(target, source, blockedSet, maxEnclosed);
    }

    private boolean bfs(int[] start, int[] end, Set<Long> blocked, int maxEnclosed) {
        int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
        Set<Long> visited = new HashSet<>();
        Queue<int[]> q = new LinkedList<>();
        q.offer(start);
        visited.add((long) start[0] * 1000000 + start[1]);
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            if (cur[0] == end[0] && cur[1] == end[1]) {
                return true;
            }
            if (visited.size() > maxEnclosed) {
                return true;
            }
            for (int[] d : dirs) {
                int nr = cur[0] + d[0], nc = cur[1] + d[1];
                long key = (long) nr * 1000000 + nc;
                if (nr >= 0 && nr < 1000000 && nc >= 0 && nc < 1000000 && !blocked.contains(key) && visited.add(key)) {
                    q.offer(new int[]{nr, nc});
                }
            }
        }
        return false;
    }
}
