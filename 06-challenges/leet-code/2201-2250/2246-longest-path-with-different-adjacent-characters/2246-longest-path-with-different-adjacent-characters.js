// https://leetcode.com/problems/longest-path-with-different-adjacent-characters/

/**
 * @param {number[]} parent
 * @param {string} s
 * @return {number}
 */
var longestPath = function (parent, s) {
    const n = parent.length;
    const children = Array.from({ length: n }, () => []);
    for (let i = 1; i < n; i++) {
        children[parent[i]].push(i);
    }

    let ans = 1;

    function dfs(node) {
        let top1 = 0, top2 = 0;
        for (const child of children[node]) {
            const len = dfs(child);
            if (s[child] === s[node]) {
                continue;
            }
            if (len > top1) {
                top2 = top1;
                top1 = len;
            } else if (len > top2) {
                top2 = len;
            }
        }
        ans = Math.max(ans, top1 + top2 + 1);
        return top1 + 1;
    }

    dfs(0);
    return ans;
};
