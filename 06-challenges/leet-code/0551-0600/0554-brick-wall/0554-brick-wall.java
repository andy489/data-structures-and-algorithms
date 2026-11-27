// https://leetcode.com/problems/brick-wall/
// Solution: HashMap edge frequency — O(n·w) time, O(w) space
class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        Map<Integer, Integer> edgeCount = new HashMap<>();
        int maxEdges = 0;
        for (List<Integer> row : wall) {
            int prefix = 0;
            for (int i = 0; i < row.size() - 1; i++) {
                prefix += row.get(i);
                int count = edgeCount.merge(prefix, 1, Integer::sum);
                maxEdges = Math.max(maxEdges, count);
            }
        }
        return wall.size() - maxEdges;
    }
}
