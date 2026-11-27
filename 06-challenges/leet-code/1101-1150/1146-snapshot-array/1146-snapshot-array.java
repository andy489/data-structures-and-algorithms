// https://leetcode.com/problems/snapshot-array/

// Solution: Per-Index History with Binary Search — O(log S) get, O(1) set/snap
class SnapshotArray {
    private List<int[]>[] history;
    private int snapId;

    @SuppressWarnings("unchecked")
    public SnapshotArray(int length) {
        history = new List[length];
        for (int i = 0; i < length; i++) {
            history[i] = new ArrayList<>();
            history[i].add(new int[]{0, 0});
        }
        snapId = 0;
    }

    public void set(int index, int val) {
        List<int[]> h = history[index];
        if (h.get(h.size() - 1)[0] == snapId) {
            h.get(h.size() - 1)[1] = val;
        } else {
            h.add(new int[]{snapId, val});
        }
    }

    public int snap() {
        return snapId++;
    }

    public int get(int index, int snap_id) {
        List<int[]> h = history[index];
        int lo = 0, hi = h.size() - 1;
        while (lo < hi) {
            int mid = (lo + hi + 1) / 2;
            if (h.get(mid)[0] <= snap_id) {
                lo = mid;
            } else {
                hi = mid - 1;
            }
        }
        return h.get(lo)[1];
    }
}
