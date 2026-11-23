// https://leetcode.com/problems/brick-wall/
// Solution: HashMap edge frequency — O(n·w) time, O(w) space
var leastBricks = function(wall) {
    const edgeCount = new Map();
    for (const row of wall) {
        let prefix = 0;
        for (let i = 0; i < row.length - 1; i++) {
            prefix += row[i];
            edgeCount.set(prefix, (edgeCount.get(prefix) || 0) + 1);
        }
    }
    const maxEdges = edgeCount.size === 0 ? 0 : Math.max(...edgeCount.values());
    return wall.length - maxEdges;
};
