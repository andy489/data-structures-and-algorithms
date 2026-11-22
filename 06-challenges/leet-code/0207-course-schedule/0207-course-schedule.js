// https://leetcode.com/problems/course-schedule/

// Solution: DFS Cycle Detection (3-colour) — O(V+E) time, O(V+E) space
var canFinish = function(numCourses, prerequisites) {
    const graph = Array.from({ length: numCourses }, () => []);

    for (const [a, b] of prerequisites) {
        graph[a].push(b);
    }

    const state = new Array(numCourses).fill(0);

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
        return true;
    }

    for (let i = 0; i < numCourses; i++) {
        if (state[i] === 0 && !dfs(i)) {
            return false;
        }
    }

    return true;
};

// Solution 2: Kahn's Algorithm (BFS Topological Sort) — O(V+E) time, O(V+E) space
var canFinish2 = function(numCourses, prerequisites) {
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

    let count = 0;
    let head = 0;

    while (head < queue.length) {
        const course = queue[head++];
        count++;

        for (const next of graph[course]) {
            if (--inDegree[next] === 0) {
                queue.push(next);
            }
        }
    }

    return count === numCourses;
};
