// https://leetcode.com/problems/largest-component-size-by-common-factor/

// Solution: Union-Find on Prime Factors — O(n√M) time, O(M) space
class Solution {
    private int[] parent;

    private int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    private void union(int a, int b) {
        parent[find(a)] = find(b);
    }

    public int largestComponentSize(int[] nums) {
        int max = 0;
        for (int n : nums) {
            if (n > max) { max = n; }
        }
        parent = new int[max + 1];
        for (int i = 0; i <= max; i++) {
            parent[i] = i;
        }
        for (int n : nums) {
            for (int f = 2; f * f <= n; f++) {
                if (n % f == 0) {
                    union(n, f);
                    union(n, n / f);
                }
            }
        }
        int[] count = new int[max + 1];
        int ans = 0;
        for (int n : nums) {
            int root = find(n);
            count[root]++;
            if (count[root] > ans) { ans = count[root]; }
        }
        return ans;
    }
}
