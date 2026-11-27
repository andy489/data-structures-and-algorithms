// https://leetcode.com/problems/maximum-score-of-a-node-sequence/

class Solution {
    public int maximumScore(int[] scores, int[][] edges) {
        int n = scores.length;
        // top3[v] = top 3 neighbors of v by score
        List<int[]>[] top3 = new List[n];
        for (int i = 0; i < n; i++) {
            top3[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            addTop3(top3[u], v, scores[v]);
            addTop3(top3[v], u, scores[u]);
        }

        int ans = -1;
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            for (int[] nu : top3[u]) {
                for (int[] nv : top3[v]) {
                    int a = nu[0], b = nv[0];
                    if (a != v && b != u && a != b) {
                        int score = scores[u] + scores[v] + scores[a] + scores[b];
                        if (score > ans) {
                            ans = score;
                        }
                    }
                }
            }
        }
        return ans;
    }

    private void addTop3(List<int[]> list, int node, int score) {
        list.add(new int[]{node, score});
        list.sort((x, y) -> y[1] - x[1]);
        if (list.size() > 3) {
            list.remove(3);
        }
    }
}
