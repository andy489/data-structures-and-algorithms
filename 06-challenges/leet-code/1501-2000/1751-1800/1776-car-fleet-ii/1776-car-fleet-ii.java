// https://leetcode.com/problems/car-fleet-ii/

// Solution: Monotonic Stack (Right to Left) — O(n) time, O(n) space
class Solution {
    public double[] getCollisionTimes(int[][] cars) {
        int n = cars.length;
        double[] ans = new double[n];
        Arrays.fill(ans, -1.0);
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = n - 1; i >= 0; i--) {
            int pos = cars[i][0], speed = cars[i][1];
            while (!stack.isEmpty()) {
                int j = stack.peek();
                int posJ = cars[j][0], speedJ = cars[j][1];
                // Car i can only catch car j if it's faster
                if (speed <= speedJ) {
                    stack.pop();
                    continue;
                }
                double t = (double)(posJ - pos) / (speed - speedJ);
                // If car j will merge into a fleet before t, pop j
                if (ans[j] != -1 && t >= ans[j]) {
                    stack.pop();
                    continue;
                }
                ans[i] = t;
                break;
            }
            stack.push(i);
        }
        return ans;
    }
}
