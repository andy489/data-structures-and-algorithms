// https://leetcode.com/problems/range-sum-query-mutable/

// Solution: Fenwick Tree (BIT) — O(log n) per operation time, O(n) space
class NumArray {
    private int[] bit;
    private int[] nums;
    private int n;

    public NumArray(int[] nums) {
        this.n = nums.length;
        this.nums = nums.clone();
        this.bit = new int[n + 1];
        for (int i = 0; i < n; i++) {
            add(i + 1, nums[i]);
        }
    }

    public void update(int index, int val) {
        add(index + 1, val - nums[index]);
        nums[index] = val;
    }

    public int sumRange(int left, int right) {
        return query(right + 1) - query(left);
    }

    private void add(int i, int delta) {
        for (; i <= n; i += i & -i) {
            bit[i] += delta;
        }
    }

    private int query(int i) {
        int s = 0;
        for (; i > 0; i -= i & -i) {
            s += bit[i];
        }
        return s;
    }
}
