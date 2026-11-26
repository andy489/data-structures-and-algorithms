// https://leetcode.com/problems/minimum-number-of-flips-to-convert-binary-matrix-to-zero-matrix/

// Solution: BFS on Bitmask — O(2^(m*n) * m*n) time, O(2^(m*n)) space
// Solution: BFS on Bitmask — O(2^(m*n)*m*n) time, O(2^(m*n)) space
class Solution {
    public int minFlips(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int start = 0;
        for (int i = 0; i < m; i++) for (int j = 0; j < n; j++) start |= mat[i][j] << (i*n+j);
        if (start == 0) return 0;
        int[][] dirs = {{0,0},{-1,0},{1,0},{0,-1},{0,1}};
        int[] flipMasks = new int[m*n];
        for (int i = 0; i < m; i++) for (int j = 0; j < n; j++) {
            int mask = 0;
            for (int[] d : dirs) {
                int ni=i+d[0],nj=j+d[1];
                if (ni>=0&&ni<m&&nj>=0&&nj<n) mask |= 1<<(ni*n+nj);
            }
            flipMasks[i*n+j] = mask;
        }
        Set<Integer> visited = new HashSet<>();
        Deque<Integer> q = new ArrayDeque<>();
        q.add(start); visited.add(start);
        int steps = 0;
        while (!q.isEmpty()) {
            steps++;
            int size = q.size();
            while (size-- > 0) {
                int cur = q.poll();
                for (int k = 0; k < m*n; k++) {
                    int next = cur ^ flipMasks[k];
                    if (next == 0) return steps;
                    if (!visited.contains(next)) { visited.add(next); q.add(next); }
                }
            }
        }
        return -1;
    }
}
