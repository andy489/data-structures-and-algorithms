// https://leetcode.com/problems/validate-binary-tree-nodes/

// Solution: Union-Find / BFS — O(n) time, O(n) space
class Solution {
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        int[] parent = new int[n];
        Arrays.fill(parent, -1);
        for (int i = 0; i < n; i++) {
            for (int child : new int[]{leftChild[i], rightChild[i]}) {
                if (child == -1) continue;
                if (parent[child] != -1) return false;
                parent[child] = i;
            }
        }
        int root = -1;
        for (int i = 0; i < n; i++) {
            if (parent[i] == -1) {
                if (root != -1) return false;
                root = i;
            }
        }
        if (root == -1) return false;
        boolean[] visited = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        q.offer(root);
        visited[root] = true;
        int count = 1;
        while (!q.isEmpty()) {
            int node = q.poll();
            for (int child : new int[]{leftChild[node], rightChild[node]}) {
                if (child != -1) {
                    if (visited[child]) return false;
                    visited[child] = true;
                    q.offer(child);
                    count++;
                }
            }
        }
        return count == n;
    }
}
