// https://leetcode.com/problems/walking-robot-simulation/

// Solution: Simulation with HashSet — O(n*k + m) time, O(m) space
class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        Set<String> blocked = new HashSet<>();
        for (int[] o : obstacles) {
            blocked.add(o[0] + "," + o[1]);
        }
        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int dir = 0, x = 0, y = 0, ans = 0;
        for (int cmd : commands) {
            if (cmd == -2) {
                dir = (dir + 3) % 4;
            } else if (cmd == -1) {
                dir = (dir + 1) % 4;
            } else {
                for (int step = 0; step < cmd; step++) {
                    int nx = x + dirs[dir][0], ny = y + dirs[dir][1];
                    if (blocked.contains(nx + "," + ny)) {
                        break;
                    }
                    x = nx; y = ny;
                    ans = Math.max(ans, x * x + y * y);
                }
            }
        }
        return ans;
    }
}
