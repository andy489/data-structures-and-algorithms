// https://leetcode.com/problems/find-servers-that-handled-most-number-of-requests/

// Solution: TreeSet + Available Servers — O(n log k) time, O(k) space
class Solution {
    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
        int[] count = new int[k];
        // available servers (sorted by index)
        TreeSet<Integer> available = new TreeSet<>();
        for (int i = 0; i < k; i++) {
            available.add(i);
        }
        // busy servers: (finish_time, server_index)
        TreeMap<Integer, Integer> busy = new TreeMap<>();

        for (int i = 0; i < arrival.length; i++) {
            int t = arrival[i];
            // release servers that are done by time t
            while (!busy.isEmpty() && busy.firstKey() <= t) {
                Map.Entry<Integer, Integer> entry = busy.pollFirstEntry();
                available.add(entry.getValue());
            }
            if (available.isEmpty()) {
                continue;
            }
            // find server >= i % k, else wrap to smallest
            int preferred = i % k;
            Integer server = available.ceiling(preferred);
            if (server == null) {
                server = available.first();
            }
            available.remove(server);
            count[server]++;
            busy.put(t + load[i], server);
        }

        int maxCount = 0;
        for (int c : count) {
            maxCount = Math.max(maxCount, c);
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            if (count[i] == maxCount) {
                result.add(i);
            }
        }
        return result;
    }
}
