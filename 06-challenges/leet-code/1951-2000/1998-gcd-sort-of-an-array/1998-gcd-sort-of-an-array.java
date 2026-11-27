// https://leetcode.com/problems/gcd-sort-of-an-array/
class Solution {
    private int[] parent;

    public boolean gcdSort(int[] nums) {
        int maxVal = 0;
        for (int x : nums) {
            maxVal = Math.max(maxVal, x);
        }
        parent = new int[maxVal + 1];
        for (int i = 0; i <= maxVal; i++) {
            parent[i] = i;
        }
        for (int x : nums) {
            int temp = x;
            for (int p = 2; (long) p * p <= temp; p++) {
                if (temp % p == 0) {
                    union(x, p);
                    while (temp % p == 0) {
                        temp /= p;
                    }
                }
            }
            if (temp > 1) {
                union(x, temp);
            }
        }
        int[] sorted = nums.clone();
        Arrays.sort(sorted);
        for (int i = 0; i < nums.length; i++) {
            if (find(nums[i]) != find(sorted[i])) {
                return false;
            }
        }
        return true;
    }

    private int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    private void union(int a, int b) {
        int ra = find(a), rb = find(b);
        if (ra != rb) {
            parent[ra] = rb;
        }
    }
}
