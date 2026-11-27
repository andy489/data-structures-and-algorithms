// https://leetcode.com/problems/strange-printer-ii/

// Solution: Topological Sort — O(m*n + C^2) time, O(C^2) space
class Solution {
    public boolean isPrintable(int[][] targetGrid) {
        int m = targetGrid.length, n = targetGrid[0].length;
        int C = 60;
        int[] top = new int[C + 1], bottom = new int[C + 1], left = new int[C + 1], right = new int[C + 1];
        Arrays.fill(top, m);
        Arrays.fill(bottom, -1);
        Arrays.fill(left, n);
        Arrays.fill(right, -1);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int c = targetGrid[i][j];
                top[c] = Math.min(top[c], i);
                bottom[c] = Math.max(bottom[c], i);
                left[c] = Math.min(left[c], j);
                right[c] = Math.max(right[c], j);
            }
        }
        Set<Integer>[] deps = new Set[C + 1];
        for (int c = 1; c <= C; c++) {
            deps[c] = new HashSet<>();
        }
        for (int c = 1; c <= C; c++) {
            if (bottom[c] == -1) continue;
            for (int i = top[c]; i <= bottom[c]; i++) {
                for (int j = left[c]; j <= right[c]; j++) {
                    if (targetGrid[i][j] != c) {
                        deps[c].add(targetGrid[i][j]);
                    }
                }
            }
        }
        int[] indegree = new int[C + 1];
        for (int c = 1; c <= C; c++) {
            for (int dep : deps[c]) {
                indegree[c]++;
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int c = 1; c <= C; c++) {
            if (bottom[c] != -1 && indegree[c] == 0) {
                queue.offer(c);
            }
        }
        int processed = 0;
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            processed++;
            for (int c = 1; c <= C; c++) {
                if (deps[c].contains(cur)) {
                    indegree[c]--;
                    if (indegree[c] == 0) queue.offer(c);
                }
            }
        }
        int usedColors = 0;
        for (int c = 1; c <= C; c++) {
            if (bottom[c] != -1) usedColors++;
        }
        return processed == usedColors;
    }
}
