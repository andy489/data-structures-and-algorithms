// https://leetcode.com/problems/reconstruct-itinerary/

// Solution: Hierholzer's Algorithm — O(E log E) time, O(E) space
var findItinerary = function(tickets) {
    const graph = {};
    for (const [from, to] of tickets.sort().reverse()) {
        graph[from] = graph[from] || [];
        graph[from].push(to);
    }
    const result = [];
    function dfs(airport) {
        while (graph[airport] && graph[airport].length) {
            dfs(graph[airport].pop());
        }
        result.push(airport);
    }
    dfs('JFK');
    return result.reverse();
};
