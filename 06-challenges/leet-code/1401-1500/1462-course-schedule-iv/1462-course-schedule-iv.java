// https://leetcode.com/problems/course-schedule-iv/

// Solution: Floyd-Warshall Transitive Closure — O(n^3) time, O(n^2) space
class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        boolean[][] reach = new boolean[numCourses][numCourses];
        for (int[] p : prerequisites) reach[p[0]][p[1]] = true;
        for (int k = 0; k < numCourses; k++)
            for (int i = 0; i < numCourses; i++)
                for (int j = 0; j < numCourses; j++)
                    if (reach[i][k] && reach[k][j]) reach[i][j] = true;
        List<Boolean> res = new ArrayList<>();
        for (int[] q : queries) res.add(reach[q[0]][q[1]]);
        return res;
    }
}
