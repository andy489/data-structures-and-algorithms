// https://leetcode.com/problems/minimum-jumps-to-reach-home/

// Solution: BFS — O(LIMIT) time, O(LIMIT) space
class Solution {
    public int minimumJumps(int[] forbidden, int a, int b, int x) {
        Set<Integer> forbidSet = new HashSet<>();
        int limit = x + a + b;
        for (int f : forbidden) {
            forbidSet.add(f);
            limit = Math.max(limit, f + a + b);
        }
        // visited[pos][0=forward/1=backward]
        boolean[][] visited = new boolean[limit + 1][2];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0}); // pos, lastWasBackward
        visited[0][0] = true;
        int steps = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int[] cur = queue.poll();
                int pos = cur[0], back = cur[1];
                if (pos == x) {
                    return steps;
                }
                // forward jump
                int fwd = pos + a;
                if (fwd <= limit && !forbidSet.contains(fwd) && !visited[fwd][0]) {
                    visited[fwd][0] = true;
                    queue.offer(new int[]{fwd, 0});
                }
                // backward jump (not allowed if last was backward)
                if (back == 0) {
                    int bwd = pos - b;
                    if (bwd > 0 && !forbidSet.contains(bwd) && !visited[bwd][1]) {
                        visited[bwd][1] = true;
                        queue.offer(new int[]{bwd, 1});
                    }
                }
            }
            steps++;
        }
        return -1;
    }
}
