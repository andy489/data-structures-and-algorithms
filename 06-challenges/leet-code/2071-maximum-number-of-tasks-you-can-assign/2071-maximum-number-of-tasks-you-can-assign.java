// https://leetcode.com/problems/maximum-number-of-tasks-you-can-assign/

// Solution: Binary Search + Greedy — O(n log^2 n) time, O(n) space
class Solution {
    public int maxTaskAssign(int[] tasks, int[] workers, int pills, int strength) {
        Arrays.sort(tasks);
        Arrays.sort(workers);
        int lo = 0, hi = Math.min(tasks.length, workers.length);
        while (lo < hi) {
            int mid = (lo + hi + 1) / 2;
            if (canAssign(tasks, workers, pills, strength, mid)) { lo = mid; }
            else { hi = mid - 1; }
        }
        return lo;
    }
    private boolean canAssign(int[] tasks, int[] workers, int pills, int strength, int k) {
        int m = workers.length;
        TreeMap<Integer, Integer> ws = new TreeMap<>();
        for (int i = m - k; i < m; i++) { ws.merge(workers[i], 1, Integer::sum); }
        int p = pills;
        for (int i = k - 1; i >= 0; i--) {
            int t = tasks[i];
            Integer key = ws.ceilingKey(t);
            if (key != null) {
                ws.merge(key, -1, Integer::sum);
                if (ws.get(key) == 0) { ws.remove(key); }
            } else {
                if (p == 0) { return false; }
                p--;
                key = ws.ceilingKey(t - strength);
                if (key == null) { return false; }
                ws.merge(key, -1, Integer::sum);
                if (ws.get(key) == 0) { ws.remove(key); }
            }
        }
        return true;
    }
}
