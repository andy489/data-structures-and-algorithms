// https://leetcode.com/problems/online-majority-element-in-subarray/

// Solution: Segment Tree (Boyer-Moore) + Binary Search — O(n log n) build, O(log² n) query
class MajorityChecker {
    private int[] candidate;
    private int[] count;
    private int n;
    private Map<Integer, List<Integer>> positions;

    public MajorityChecker(int[] arr) {
        n = arr.length;
        candidate = new int[4 * n];
        count = new int[4 * n];
        positions = new HashMap<>();
        for (int i = 0; i < n; i++) {
            positions.computeIfAbsent(arr[i], k -> new ArrayList<>()).add(i);
        }
        build(arr, 1, 0, n - 1);
    }

    private void build(int[] arr, int node, int l, int r) {
        if (l == r) {
            candidate[node] = arr[l];
            count[node] = 1;
            return;
        }
        int mid = (l + r) / 2;
        build(arr, 2 * node, l, mid);
        build(arr, 2 * node + 1, mid + 1, r);
        merge(node);
    }

    private void merge(int node) {
        int lc = candidate[2 * node], rc = candidate[2 * node + 1];
        int lv = count[2 * node], rv = count[2 * node + 1];
        if (lc == rc) {
            candidate[node] = lc;
            count[node] = lv + rv;
        } else if (lv >= rv) {
            candidate[node] = lc;
            count[node] = lv - rv;
        } else {
            candidate[node] = rc;
            count[node] = rv - lv;
        }
    }

    private int[] query(int node, int l, int r, int ql, int qr) {
        if (ql <= l && r <= qr) {
            return new int[]{candidate[node], count[node]};
        }
        int mid = (l + r) / 2;
        if (qr <= mid) {
            return query(2 * node, l, mid, ql, qr);
        }
        if (ql > mid) {
            return query(2 * node + 1, mid + 1, r, ql, qr);
        }
        int[] left = query(2 * node, l, mid, ql, qr);
        int[] right = query(2 * node + 1, mid + 1, r, ql, qr);
        if (left[0] == right[0]) {
            return new int[]{left[0], left[1] + right[1]};
        } else if (left[1] >= right[1]) {
            return new int[]{left[0], left[1] - right[1]};
        } else {
            return new int[]{right[0], right[1] - left[1]};
        }
    }

    public int query(int left, int right, int threshold) {
        int cand = query(1, 0, n - 1, left, right)[0];
        List<Integer> pos = positions.getOrDefault(cand, Collections.emptyList());
        int lo = Collections.binarySearch(pos, left);
        if (lo < 0) {
            lo = -lo - 1;
        }
        int hi = Collections.binarySearch(pos, right);
        if (hi < 0) {
            hi = -hi - 2;
        }
        return (hi - lo + 1 >= threshold) ? cand : -1;
    }
}
