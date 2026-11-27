// https://leetcode.com/problems/handling-sum-queries-after-update/

// Solution: Segment Tree with Lazy Propagation — O((n+q) log n) time
class Solution {
    private int[] tree;
    private boolean[] lazy;
    private int n;

    public long[] handleQuery(int[] nums1, int[] nums2, int[][] queries) {
        n = nums1.length;
        tree = new int[4 * n];
        lazy = new boolean[4 * n];
        build(nums1, 1, 0, n - 1);

        long sum2 = 0;
        for (int x : nums2) {
            sum2 += x;
        }

        List<Long> result = new ArrayList<>();
        for (int[] q : queries) {
            if (q[0] == 1) {
                flip(1, 0, n - 1, q[1], q[2]);
            } else if (q[0] == 2) {
                sum2 += (long) query(1, 0, n - 1, 0, n - 1) * q[1];
            } else {
                result.add(sum2);
            }
        }

        long[] ans = new long[result.size()];
        for (int i = 0; i < result.size(); i++) {
            ans[i] = result.get(i);
        }
        return ans;
    }

    private void build(int[] nums, int node, int l, int r) {
        if (l == r) {
            tree[node] = nums[l];
            return;
        }
        int mid = (l + r) / 2;
        build(nums, 2 * node, l, mid);
        build(nums, 2 * node + 1, mid + 1, r);
        tree[node] = tree[2 * node] + tree[2 * node + 1];
    }

    private void pushDown(int node, int l, int r) {
        if (lazy[node]) {
            int mid = (l + r) / 2;
            int leftLen = mid - l + 1;
            int rightLen = r - mid;
            tree[2 * node] = leftLen - tree[2 * node];
            tree[2 * node + 1] = rightLen - tree[2 * node + 1];
            lazy[2 * node] = !lazy[2 * node];
            lazy[2 * node + 1] = !lazy[2 * node + 1];
            lazy[node] = false;
        }
    }

    private void flip(int node, int l, int r, int ql, int qr) {
        if (ql <= l && r <= qr) {
            tree[node] = (r - l + 1) - tree[node];
            lazy[node] = !lazy[node];
            return;
        }
        pushDown(node, l, r);
        int mid = (l + r) / 2;
        if (ql <= mid) {
            flip(2 * node, l, mid, ql, qr);
        }
        if (qr > mid) {
            flip(2 * node + 1, mid + 1, r, ql, qr);
        }
        tree[node] = tree[2 * node] + tree[2 * node + 1];
    }

    private int query(int node, int l, int r, int ql, int qr) {
        if (ql <= l && r <= qr) {
            return tree[node];
        }
        pushDown(node, l, r);
        int mid = (l + r) / 2;
        int res = 0;
        if (ql <= mid) {
            res += query(2 * node, l, mid, ql, qr);
        }
        if (qr > mid) {
            res += query(2 * node + 1, mid + 1, r, ql, qr);
        }
        return res;
    }
}
