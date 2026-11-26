// https://leetcode.com/problems/jump-game-iv/

// Solution: BFS — O(n) time, O(n) space
class Solution {
    public int minJumps(int[] arr) {
        int n = arr.length;
        if (n == 1) return 0;
        Map<Integer, List<Integer>> sameVal = new HashMap<>();
        for (int i = 0; i < n; i++) sameVal.computeIfAbsent(arr[i], k -> new ArrayList<>()).add(i);
        boolean[] visited = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        q.offer(0);
        visited[0] = true;
        int steps = 0;
        while (!q.isEmpty()) {
            steps++;
            int sz = q.size();
            for (int i = 0; i < sz; i++) {
                int cur = q.poll();
                List<Integer> candidates = new ArrayList<>(Arrays.asList(cur-1, cur+1));
                List<Integer> same = sameVal.remove(arr[cur]);
                if (same != null) candidates.addAll(same);
                for (int next : candidates) {
                    if (next == n-1) return steps;
                    if (next >= 0 && next < n && !visited[next]) {
                        visited[next] = true;
                        q.offer(next);
                    }
                }
            }
        }
        return steps;
    }
}
