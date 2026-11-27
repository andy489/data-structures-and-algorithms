// https://leetcode.com/problems/count-nodes-with-the-highest-score/

// Solution: DFS Subtree Sizes — O(n) time, O(n) space
class Solution {
    public int countHighestScoreNodes(int[] parents) {
        int n = parents.length;
        List<List<Integer>> children = new ArrayList<>();
        for (int i = 0; i < n; i++) { children.add(new ArrayList<>()); }
        for (int i = 1; i < n; i++) { children.get(parents[i]).add(i); }
        int[] size = new int[n];
        computeSize(0, children, size);
        long maxScore = 0;
        int count = 0;
        for (int i = 0; i < n; i++) {
            long score = 1;
            int left = children.get(i).size() > 0 ? size[children.get(i).get(0)] : 0;
            int right = children.get(i).size() > 1 ? size[children.get(i).get(1)] : 0;
            int up = n - 1 - left - right;
            if (left > 0) { score *= left; }
            if (right > 0) { score *= right; }
            if (up > 0) { score *= up; }
            if (score > maxScore) { maxScore = score; count = 1; }
            else if (score == maxScore) { count++; }
        }
        return count;
    }
    private void computeSize(int node, List<List<Integer>> children, int[] size) {
        size[node] = 1;
        for (int child : children.get(node)) { computeSize(child, children, size); size[node] += size[child]; }
    }
}
