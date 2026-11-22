// https://leetcode.com/problems/course-schedule-ii/

// Solution: Kahn's Algorithm (BFS Topological Sort) — O(V+E) time, O(V+E) space
var findOrder = function(numCourses, prerequisites) {
    const graph = Array.from({ length: numCourses }, () => []);
    const inDegree = new Array(numCourses).fill(0);

    for (const [a, b] of prerequisites) {
        graph[b].push(a);
        inDegree[a]++;
    }

    const queue = [];

    for (let i = 0; i < numCourses; i++) {
        if (inDegree[i] === 0) {
            queue.push(i);
        }
    }

    const order = [];
    let head = 0;

    while (head < queue.length) {
        const course = queue[head++];
        order.push(course);

        for (const next of graph[course]) {
            if (--inDegree[next] === 0) {
                queue.push(next);
            }
        }
    }

    return order.length === numCourses ? order : [];
};

// Solution 2: DFS Post-order — O(V+E) time, O(V+E) space
var findOrder2 = function(numCourses, prerequisites) {
    const graph = Array.from({ length: numCourses }, () => []);

    for (const [a, b] of prerequisites) {
        graph[a].push(b);
    }

    const state = new Array(numCourses).fill(0);
    const stack = [];

    function dfs(node) {
        state[node] = 1;

        for (const nb of graph[node]) {
            if (state[nb] === 1) {
                return false;
            }

            if (state[nb] === 0 && !dfs(nb)) {
                return false;
            }
        }

        state[node] = 2;
        stack.push(node);
        return true;
    }

    for (let i = 0; i < numCourses; i++) {
        if (state[i] === 0 && !dfs(i)) {
            return [];
        }
    }

    return stack.reverse();
};
