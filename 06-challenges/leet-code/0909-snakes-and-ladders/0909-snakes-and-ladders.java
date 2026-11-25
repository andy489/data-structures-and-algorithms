// https://leetcode.com/problems/snakes-and-ladders/

// Solution: BFS — O(n²) time, O(n²) space
class Solution {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        int target = n * n;
        boolean[] visited = new boolean[target + 1];
        int[] queue = new int[target];
        int head = 0, tail = 0;
        queue[tail++] = 1;
        visited[1] = true;
        int steps = 0;
        while (head < tail) {
            int size = tail - head;
            while (size-- > 0) {
                int curr = queue[head++];
                if (curr == target) {
                    return steps;
                }
                for (int dice = 1; dice <= 6; dice++) {
                    int next = curr + dice;
                    if (next > target) {
                        break;
                    }
                    int idx = next - 1;
                    int row = n - 1 - idx / n;
                    int col = (idx / n % 2 == 0) ? idx % n : n - 1 - idx % n;
                    if (board[row][col] != -1) {
                        next = board[row][col];
                    }
                    if (!visited[next]) {
                        visited[next] = true;
                        queue[tail++] = next;
                    }
                }
            }
            steps++;
        }
        return -1;
    }
}
