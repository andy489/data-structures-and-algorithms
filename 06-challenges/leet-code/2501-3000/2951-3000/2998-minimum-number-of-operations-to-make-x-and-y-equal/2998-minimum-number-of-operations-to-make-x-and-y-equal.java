// https://leetcode.com/problems/minimum-number-of-operations-to-make-x-and-y-equal/
class Solution {
    public int minimumOperationsToMakeEqual(int x, int y) {
        if (x <= y) {
            return y - x;
        }
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, 0});
        Set<Integer> visited = new HashSet<>();
        visited.add(x);
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int val = curr[0], dist = curr[1];
            if (val == y) {
                return dist;
            }
            int[] neighbors = {val - 1, val + 1,
                val % 5 == 0 ? val / 5 : -1,
                val % 11 == 0 ? val / 11 : -1};
            for (int next : neighbors) {
                if (next >= 1 && !visited.contains(next) && next <= x + 11) {
                    visited.add(next);
                    queue.offer(new int[]{next, dist + 1});
                }
            }
        }
        return -1;
    }
}
