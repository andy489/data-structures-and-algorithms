// https://leetcode.com/problems/lexicographical-numbers/

// Solution: DFS Trie Traversal — O(n) time, O(1) extra space
var lexicalOrder = function(n) {
    const result = [];
    let cur = 1;
    while (result.length < n) {
        result.push(cur);
        if (cur * 10 <= n) {
            cur *= 10;
        } else {
            while (cur % 10 === 9 || cur + 1 > n) cur = Math.floor(cur / 10);
            cur++;
        }
    }
    return result;
};
