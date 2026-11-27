// https://leetcode.com/problems/course-schedule-ii/

// Solution: Kahn's Algorithm (BFS Topological Sort) — O(V+E) time, O(V+E) space
class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        int[] inDegree = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] pre : prerequisites) {
            graph.get(pre[1]).add(pre[0]);
            inDegree[pre[0]]++;
        }

        Queue<Integer> queue = new ArrayDeque<>();

        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        int[] order = new int[numCourses];
        int idx = 0;

        while (!queue.isEmpty()) {
            int course = queue.poll();
            order[idx++] = course;

            for (int next : graph.get(course)) {
                if (--inDegree[next] == 0) {
                    queue.offer(next);
                }
            }
        }

        return idx == numCourses ? order : new int[0];
    }
}

// Solution 2: DFS Post-order — O(V+E) time, O(V+E) space
class Solution2 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] pre : prerequisites) {
            graph.get(pre[0]).add(pre[1]);
        }

        int[] state = new int[numCourses];
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < numCourses; i++) {
            if (state[i] == 0 && !dfs(graph, state, stack, i)) {
                return new int[0];
            }
        }

        int[] order = new int[numCourses];
        int idx = 0;

        while (!stack.isEmpty()) {
            order[idx++] = stack.pop();
        }

        return order;
    }

    private boolean dfs(List<List<Integer>> graph, int[] state, Deque<Integer> stack, int node) {
        state[node] = 1;

        for (int neighbour : graph.get(node)) {
            if (state[neighbour] == 1) {
                return false;
            }

            if (state[neighbour] == 0 && !dfs(graph, state, stack, neighbour)) {
                return false;
            }
        }

        state[node] = 2;
        stack.push(node);
        return true;
    }
}
