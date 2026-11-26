// https://leetcode.com/problems/keys-and-rooms/

// Solution: DFS — O(n+k) time, O(n) space
class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] visited = new boolean[rooms.size()];
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(0);
        visited[0] = true;
        int count = 1;
        while (!stack.isEmpty()) {
            int room = stack.pop();
            for (int key : rooms.get(room)) {
                if (!visited[key]) {
                    visited[key] = true;
                    count++;
                    stack.push(key);
                }
            }
        }
        return count == rooms.size();
    }
}
