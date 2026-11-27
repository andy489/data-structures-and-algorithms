// https://leetcode.com/problems/jump-game-iii/

// Solution: BFS — O(n) time, O(n) space
class Solution {
    public boolean canReach(int[] arr, int start) {
        int n = arr.length;
        boolean[] visited = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visited[start] = true;
        while (!q.isEmpty()) {
            int i = q.poll();
            if (arr[i] == 0) return true;
            for (int next : new int[]{i + arr[i], i - arr[i]}) {
                if (next >= 0 && next < n && !visited[next]) {
                    visited[next] = true;
                    q.offer(next);
                }
            }
        }
        return false;
    }
}
