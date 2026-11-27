// https://leetcode.com/problems/exclusive-time-of-functions/

// Solution: Stack Simulation — O(n) time, O(n) space
class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] time = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();
        int prevTime = 0;
        for (String log : logs) {
            String[] parts = log.split(":");
            int id = Integer.parseInt(parts[0]);
            String type = parts[1];
            int ts = Integer.parseInt(parts[2]);
            if (type.equals("start")) {
                if (!stack.isEmpty()) {
                    time[stack.peek()] += ts - prevTime;
                }
                stack.push(id);
                prevTime = ts;
            } else {
                time[stack.pop()] += ts - prevTime + 1;
                prevTime = ts + 1;
            }
        }
        return time;
    }
}
