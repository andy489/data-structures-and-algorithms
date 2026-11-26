// https://leetcode.com/problems/minimum-operations-to-convert-number/

// Solution: BFS — O(n*1000) time, O(1000) space
class Solution {
    public int minimumOperations(int[] nums, int start, int goal) {
        boolean[] visited = new boolean[1001];
        visited[start] = true;
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        int steps = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            steps++;
            while (size-- > 0) {
                int cur = q.poll();
                for (int num : nums) {
                    for (int next : new int[]{cur + num, cur - num, cur ^ num}) {
                        if (next == goal) { return steps; }
                        if (next >= 0 && next <= 1000 && !visited[next]) {
                            visited[next] = true;
                            q.offer(next);
                        }
                    }
                }
            }
        }
        return -1;
    }
}
