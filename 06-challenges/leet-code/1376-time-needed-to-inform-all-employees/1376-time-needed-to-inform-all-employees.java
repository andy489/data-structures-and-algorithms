// https://leetcode.com/problems/time-needed-to-inform-all-employees/

// Solution: DFS — O(n) time, O(n) space
class Solution {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        List<List<Integer>> children = new ArrayList<>();
        for (int i = 0; i < n; i++) children.add(new ArrayList<>());
        for (int i = 0; i < n; i++) if (manager[i] != -1) children.get(manager[i]).add(i);
        return dfs(headID, children, informTime);
    }
    private int dfs(int emp, List<List<Integer>> children, int[] informTime) {
        int max = 0;
        for (int sub : children.get(emp)) max = Math.max(max, dfs(sub, children, informTime));
        return informTime[emp] + max;
    }
}
