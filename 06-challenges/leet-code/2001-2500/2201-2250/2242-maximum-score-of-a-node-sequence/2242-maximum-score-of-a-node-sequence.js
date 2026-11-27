// https://leetcode.com/problems/maximum-score-of-a-node-sequence/

/**
 * @param {number[]} scores
 * @param {number[][]} edges
 * @return {number}
 */
var maximumScore = function(scores, edges) {
    const n = scores.length;
    const top3 = Array.from({length: n}, () => []);

    const addTop3 = (lst, node, score) => {
        lst.push([score, node]);
        lst.sort((a, b) => b[0] - a[0]);
        if (lst.length > 3) {
            lst.pop();
        }
    };

    for (const [u, v] of edges) {
        addTop3(top3[u], v, scores[v]);
        addTop3(top3[v], u, scores[u]);
    }

    let ans = -1;
    for (const [u, v] of edges) {
        for (const [sa, a] of top3[u]) {
            for (const [sb, b] of top3[v]) {
                if (a !== v && b !== u && a !== b) {
                    const total = scores[u] + scores[v] + sa + sb;
                    if (total > ans) {
                        ans = total;
                    }
                }
            }
        }
    }
    return ans;
};
