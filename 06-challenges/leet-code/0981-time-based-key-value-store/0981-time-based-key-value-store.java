// https://leetcode.com/problems/time-based-key-value-store/

// Solution: HashMap + Binary Search — O(log n) per get, O(1) per set
class TimeMap {
    private Map<String, List<int[]>> times = new HashMap<>();
    private Map<String, List<String>> vals = new HashMap<>();

    public void set(String key, String value, int timestamp) {
        times.computeIfAbsent(key, k -> new ArrayList<>()).add(new int[]{timestamp});
        vals.computeIfAbsent(key, k -> new ArrayList<>()).add(value);
    }

    public String get(String key, int timestamp) {
        if (!times.containsKey(key)) { return ""; }
        List<int[]> ts = times.get(key);
        int lo = 0, hi = ts.size() - 1, idx = -1;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (ts.get(mid)[0] <= timestamp) { idx = mid; lo = mid + 1; }
            else { hi = mid - 1; }
        }
        return idx == -1 ? "" : vals.get(key).get(idx);
    }
}
