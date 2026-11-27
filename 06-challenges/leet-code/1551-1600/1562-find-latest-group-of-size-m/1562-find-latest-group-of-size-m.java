// https://leetcode.com/problems/find-latest-group-of-size-m/

// Solution: Reverse Simulation with Union-Find Sizes — O(n) time, O(n) space
class Solution {
    public int findLatestStep(int[] arr, int m) {
        int n = arr.length;
        int[] size = new int[n + 2];
        int[] parent = new int[n + 2];
        boolean[] active = new boolean[n + 2];
        int[] groupCount = new int[n + 1];
        int result = -1;

        for (int i = 0; i <= n + 1; i++) {
            parent[i] = i;
        }

        for (int step = 0; step < n; step++) {
            int pos = arr[step];
            active[pos] = true;
            size[pos] = 1;
            groupCount[1]++;

            if (active[pos - 1]) {
                merge(parent, size, groupCount, pos - 1, pos);
            }
            if (active[pos + 1]) {
                merge(parent, size, groupCount, pos, pos + 1);
            }

            if (groupCount[m] > 0) {
                result = step + 1;
            }
        }
        return result;
    }

    private int find(int[] parent, int x) {
        if (parent[x] != x) {
            parent[x] = find(parent, parent[x]);
        }
        return parent[x];
    }

    private void merge(int[] parent, int[] size, int[] groupCount, int a, int b) {
        int ra = find(parent, a), rb = find(parent, b);
        if (ra == rb) {
            return;
        }
        groupCount[size[ra]]--;
        groupCount[size[rb]]--;
        if (size[ra] < size[rb]) {
            parent[ra] = rb;
            size[rb] += size[ra];
            groupCount[size[rb]]++;
        } else {
            parent[rb] = ra;
            size[ra] += size[rb];
            groupCount[size[ra]]++;
        }
    }
}
