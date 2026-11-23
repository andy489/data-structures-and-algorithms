// https://leetcode.com/problems/most-frequent-subtree-sum/

var findFrequentTreeSum = function(root) {
    const counts = new Map();
    let maxFreq = 0;

    function dfs(node) {
        if (!node) return 0;
        const s = node.val + dfs(node.left) + dfs(node.right);
        const freq = (counts.get(s) || 0) + 1;
        counts.set(s, freq);
        maxFreq = Math.max(maxFreq, freq);
        return s;
    }

    dfs(root);
    const result = [];
    for (const [s, freq] of counts) {
        if (freq === maxFreq) result.push(s);
    }
    return result;
};
