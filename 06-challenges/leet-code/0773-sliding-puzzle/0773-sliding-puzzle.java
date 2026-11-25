// https://leetcode.com/problems/sliding-puzzle/

// Solution: BFS on State String — O(1) time, O(1) space
class Solution {
    public int slidingPuzzle(int[][] board) {
        int[][] neighbors = {{1, 3}, {0, 2, 4}, {1, 5}, {0, 4}, {1, 3, 5}, {2, 4}};
        StringBuilder sb = new StringBuilder();
        for (int[] row : board) {
            for (int v : row) {
                sb.append(v);
            }
        }
        String start = sb.toString();
        String target = "123450";
        if (start.equals(target)) {
            return 0;
        }
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.offer(start);
        visited.add(start);
        int steps = 0;
        while (!queue.isEmpty()) {
            steps++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String curr = queue.poll();
                int zeroIdx = curr.indexOf('0');
                for (int next : neighbors[zeroIdx]) {
                    char[] arr = curr.toCharArray();
                    char tmp = arr[zeroIdx];
                    arr[zeroIdx] = arr[next];
                    arr[next] = tmp;
                    String newState = new String(arr);
                    if (newState.equals(target)) {
                        return steps;
                    }
                    if (!visited.contains(newState)) {
                        visited.add(newState);
                        queue.offer(newState);
                    }
                }
            }
        }
        return -1;
    }
}
