// https://leetcode.com/problems/find-all-people-with-secret/

// Solution: Union-Find by time groups — O(m log m) time, O(n) space
class Solution {
    int[] parent, rank;
    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        parent = new int[n]; rank = new int[n];
        for (int i = 0; i < n; i++) { parent[i] = i; }
        union(0, firstPerson);
        Arrays.sort(meetings, (a, b) -> a[2] - b[2]);
        int i = 0, m = meetings.length;
        while (i < m) {
            int j = i, t = meetings[i][2];
            while (j < m && meetings[j][2] == t) { j++; }
            List<Integer> people = new ArrayList<>();
            for (int k = i; k < j; k++) { union(meetings[k][0], meetings[k][1]); people.add(meetings[k][0]); people.add(meetings[k][1]); }
            for (int p : people) { if (find(p) != find(0)) { parent[p] = p; rank[p] = 0; } }
            i = j;
        }
        List<Integer> res = new ArrayList<>();
        for (int p = 0; p < n; p++) { if (find(p) == find(0)) { res.add(p); } }
        return res;
    }
    int find(int x) { return parent[x] == x ? x : (parent[x] = find(parent[x])); }
    void union(int a, int b) {
        a = find(a); b = find(b);
        if (a == b) { return; }
        if (rank[a] < rank[b]) { int t = a; a = b; b = t; }
        parent[b] = a;
        if (rank[a] == rank[b]) { rank[a]++; }
    }
}
